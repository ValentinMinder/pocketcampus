namespace java org.pocketcampus.plugin.authentication.shared

enum AuthStatusCode {
  // The request was successful
  OK = 200,
  // A network error occurred
  NETWORK_ERROR = 404,
  // The provided session is invalid
  INVALID_SESSION = 407
}

struct AuthTokenResponse {
  1: optional string tequilaToken;
  2: required AuthStatusCode statusCode;
}

struct AuthSessionResponse {
  1: optional string sessionId;
  2: required AuthStatusCode statusCode;
}

struct AuthSessionRequest {
  1: required string tequilaToken;
  2: optional bool rememberMe;
}

service AuthenticationService {
    AuthTokenResponse getAuthTequilaToken();
    AuthSessionResponse getAuthSession(1: AuthSessionRequest req); // TODO add logout func
    AuthSessionResponse getAuthSessionId(1: string tequilaToken); // deprecated
}
