package org.pocketcampus.plugin.camipro.server;

import com.google.gson.*;
import org.apache.thrift.TException;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;
import org.pocketcampus.platform.shared.utils.Cookie;
import org.pocketcampus.platform.shared.utils.StringUtils;
import org.pocketcampus.plugin.camipro.shared.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * CamiproServiceImpl
 * <p/>
 * The implementation of the server side of the Camipro Plugin.
 * <p/>
 * It fetches the user's Camipro data from the Camipro servers. And sends the
 * e-banking information to the user by email.
 *
 * @author Amer <amer.chamseddine@epfl.ch>
 */
public class CamiproServiceImpl implements CamiproService.Iface {
    public CamiproServiceImpl() {
        // Nothing to do.
    }

    @Override
    public TequilaToken getTequilaTokenForCamipro() throws TException {
        try {
            String cmdLine = "curl --include https://cmp2www.epfl.ch/ws/balance";
            String resp = executeCommand(cmdLine, "UTF-8");
            Cookie cookie = new Cookie();
            TequilaToken teqToken = new TequilaToken();
            for (String header : resp.split("\r\n")) {
                String shdr[] = header.split(":", 2);
                if (shdr.length != 2)
                    continue;
                if ("Set-Cookie".equalsIgnoreCase(shdr[0])) {
                    cookie.addFromHeader(shdr[1].trim());
                } else if ("Location".equalsIgnoreCase(shdr[0])) {
                    URL url = new URL(shdr[1].trim());
                    MultiMap<String> params = new MultiMap<>();
                    UrlEncoded.decodeTo(url.getQuery(), params, "UTF-8");
                    teqToken.setITequilaKey(params.getString("requestkey"));
                }
            }
            teqToken.setLoginCookie(cookie.cookie());
            return teqToken;
        } catch (IOException e) {
            e.printStackTrace();
            throw new TException("Failed to getTequilaToken from upstream server");
        }
    }

    @Override
    public CamiproSession getCamiproSession(TequilaToken iTequilaToken)
            throws TException {
        return new CamiproSession(iTequilaToken == null ? ""
                : iTequilaToken.getLoginCookie());
    }

    @Override
    public BalanceAndTransactions getBalanceAndTransactions(CamiproRequest iRequest)
            throws TException {
        return getBalanceAndTransactionsWAPI(iRequest);
    }

    @Override
    public StatsAndLoadingInfo getStatsAndLoadingInfo(CamiproRequest iRequest)
            throws TException {
        return getStatsAndLoadingInfoWAPI(iRequest);
    }

    @Override
    public SendMailResult sendLoadingInfoByEmail(CamiproRequest iRequest)
            throws TException {
        return sendLoadingInfoByEmailWAPI(iRequest);
    }

    public BalanceAndTransactions getBalanceAndTransactionsWAPI(
            CamiproRequest iRequest) throws TException {
        String balPage;
        String trxPage;
        BalanceJson tBalance;
        TransactionsJson tTransactions;
        Gson gson = getGson();
        Cookie cookie = new Cookie();
        cookie.importFromString(iRequest.getISessionId().getCamiproCookie());

        try {
            balPage = getPageWithCookie("https://cmp2www.epfl.ch/ws/balance", cookie);
            trxPage = getPageWithCookie("https://cmp2www.epfl.ch/ws/transactions", cookie);
        } catch (IOException e) {
            e.printStackTrace();
            return new BalanceAndTransactions(404);
        }
        if (balPage == null || trxPage == null) {
            System.out.println("Camipro: not logged in");
            return new BalanceAndTransactions(407);
        }

        try {
            tBalance = gson.fromJson(balPage, BalanceJson.class);
            tTransactions = gson.fromJson(trxPage, TransactionsJson.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return new BalanceAndTransactions(404);
        }
        if (!"Success".equals(tBalance.Status)
                || !"Success".equals(tTransactions.Status)) {
            System.out.println("camipro upstream server has failed");
            return new BalanceAndTransactions(404);
        }

        LinkedList<Transaction> decodedTrx = new LinkedList<>();
        if (tTransactions.LastTransactionsList.LastTransactions != null)
            for (TransactionsJson.TransactionsListJson.TransactionJson t : tTransactions.LastTransactionsList.LastTransactions) {
                if (t.TransactionDate == null || t.TransactionType == null
                        || t.ElementDescription == null) {
                    continue;
                }
                decodedTrx.add(new Transaction(
                        transcribeDate(t.TransactionDate), t.TransactionType,
                        t.ElementDescription, t.TransactionAmount));
            }

        BalanceAndTransactions bt = new BalanceAndTransactions(200);
        bt.setIBalance(tBalance.PersonalAccountBalance);
        bt.setITransactions(decodedTrx);
        bt.setIDate(transcribeDate(tBalance.LastUpdated));
        return bt;
    }

    public StatsAndLoadingInfo getStatsAndLoadingInfoWAPI(
            CamiproRequest iRequest) throws TException {
        String ebnkPage;
        EbankingJson tEbanking;
        Gson gson = getGson();
        Cookie cookie = new Cookie();
        cookie.importFromString(iRequest.getISessionId().getCamiproCookie());

        try {
            ebnkPage = getPageWithCookie("https://cmp2www.epfl.ch/ws/ebanking",
                    cookie);
        } catch (IOException e) {
            e.printStackTrace();
            return new StatsAndLoadingInfo(404);
        }
        if (ebnkPage == null) {
            System.out.println("Camipro: not logged in");
            return new StatsAndLoadingInfo(407);
        }

        try {
            tEbanking = gson.fromJson(ebnkPage, EbankingJson.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return new StatsAndLoadingInfo(404);
        }
        if (!"Success".equals(tEbanking.Status)) {
            System.out.println("camipro upstream server has failed");
            return new StatsAndLoadingInfo(404);
        }

        CardStatistics tCardStatistics = new CardStatistics(
                tEbanking.TotalAmount1M, tEbanking.TotalAmount3M);
        CardLoadingWithEbankingInfo tCardLoadingWithEbankingInfo = new CardLoadingWithEbankingInfo(
                tEbanking.PaidNameTo, tEbanking.AccountNr,
                tEbanking.BvrReadableReference);

        StatsAndLoadingInfo sl = new StatsAndLoadingInfo(200);
        sl.setICardStatistics(tCardStatistics);
        sl.setICardLoadingWithEbankingInfo(tCardLoadingWithEbankingInfo);
        return sl;
    }

    public SendMailResult sendLoadingInfoByEmailWAPI(CamiproRequest iRequest)
            throws TException {
        String ebmPage;
        EbankingemailJson tEbankingemail;
        Gson gson = getGson();
        Cookie cookie = new Cookie();
        cookie.importFromString(iRequest.getISessionId().getCamiproCookie());

        try {
            ebmPage = getPageWithCookie(
                    "https://cmp2www.epfl.ch/ws/ebankingemail?lang="
                            + iRequest.getILanguage(), cookie);
        } catch (IOException e) {
            e.printStackTrace();
            return new SendMailResult(404);
        }
        if (ebmPage == null) {
            System.out.println("Camipro: not logged in");
            return new SendMailResult(407);
        }

        try {
            tEbankingemail = gson.fromJson(ebmPage, EbankingemailJson.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return new SendMailResult(404);
        }
        if (!"Success".equals(tEbankingemail.Status)) {
            System.out.println("camipro upstream server has failed");
            return new SendMailResult(404);
        }

        SendMailResult mr = new SendMailResult(200);
        mr.setIResultText(tEbankingemail.Message);
        return mr;
    }

    private Gson getGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(double.class, new EnglishDoubleDeserializer());
        return builder.create();
    }

    private String executeCommand(String cmd, String encoding)
            throws IOException {
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        try {
            pr.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new IOException("Camipro executeCommand: waitFor Interrupted");
        }

        return StringUtils.fromStream(pr.getInputStream(), encoding);
    }

    private String getPageWithCookie(String url, Cookie cookie)
            throws IOException {
        String resp = executeCommand("curl --cookie " + cookie.cookie() + " "
                + url, "UTF-8");
        if (resp.length() == 0)
            return null;
        return resp;
    }

    private String transcribeDate(String date) {
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat out = new SimpleDateFormat("dd.MM.yy HH'h'mm");
        try {
            date = out.format(in.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * HELPER CLASSES
     */

    public class BalanceJson {
        public double PersonalAccountBalance;
        public String LastUpdated;
        public String Status;
    }

    public class EbankingJson {
        public String PaidNameTo;
        public String AccountNr;
        public String BvrReadableReference;
        public double TotalAmount1M;
        public double TotalAmount3M;
        public String Status;
    }

    public class TransactionsJson {
        public TransactionsListJson LastTransactionsList;
        public String Status;

        public class TransactionsListJson {
            public List<TransactionJson> LastTransactions;

            public class TransactionJson {
                public String TransactionType;
                public String ElementDescription;
                public String TransactionDate;
                public double TransactionAmount;
            }
        }
    }

    public class EbankingemailJson {
        public String Message;
        public String Status;
    }

    /**
     * Special deserializer that uses a set format to parse double, rather than depending on the current locale.
     */
    private static final class EnglishDoubleDeserializer implements
            JsonDeserializer<Double> {

        private static final NumberFormat NUMBER_FORMAT = NumberFormat
                .getInstance(Locale.ENGLISH);

        @Override
        public Double deserialize(JsonElement elem, Type type,
                                  JsonDeserializationContext context) throws JsonParseException {
            JsonPrimitive primitive = (JsonPrimitive) elem;
            if (primitive.isNumber()) {
                return primitive.getAsDouble();
            }
            try {
                return NUMBER_FORMAT.parse(elem.getAsString()).doubleValue();
            } catch (ParseException e) {
                throw new JsonParseException("Unexpected number format.", e);
            }
        }
    }
}
