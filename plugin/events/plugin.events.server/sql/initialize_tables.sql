SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

INSERT INTO `eventcategs` (`categKey`, `categValue`) VALUES
(-2, 'Favorites'),
(-1, 'My events'),
(0, 'All'),
(1, 'Conferences - Seminars'),
(2, 'Meetings management tips'),
(4, 'Miscellaneous'),
(5, 'Exhibitions'),
(6, 'Movies'),
(7, 'Celebrations'),
(8, 'Inaugural lessons - Lessons of honor'),
(9, 'Cultural events'),
(10, 'Sporting events'),
(11, 'Dating EPFL - economy'),
(12, 'Thesis defenses'),
(13, 'Academic calendar'),
(101, 'Participants'),
(102, 'First Day'),
(103, 'Talks'),
(104, 'Posters'),
(105, 'Labs'),
(-3, 'Me'),
(1000000, 'Uncategorized'),
(106, 'Professors'),
(107, 'Poster Authors'),
(108, 'Groups of Labs'),
(109, 'Individual Labs'),
(110, 'Second Day'),
(111, 'Schedule'),
(112, 'Venue'),
(113, 'Links'),
(114, 'Affiliates'),
(115, 'Research Areas'),
(116, 'Useful Information');

INSERT INTO `eventtags` (`feedKey`, `feedValue`, `isMemento`) VALUES
('epfl', 'EPFL', 1),
('sti', 'STI', 1),
('iic', 'Civil Engineering', 1),
('craft', 'Pedagogical Research and Support', 1),
('laseminars', 'Seminars at the Automatic Control Lab', 1),
('academic-calendar', 'Academic calendar', 1),
('edar', 'Architecture & Sciences of the City', 1),
('cultural', 'cultural events', 1),
('geom', 'Chair of Geometry', 1),
('eess', 'Environmental engineering seminar series', 1),
('architecture', 'Architecture', 1),
('isrec', 'Swiss Institute for Experimental Cancer Research', 1),
('environmental-engineering', 'Environmental engineering', 1),
('fccf', 'Flow Cytometry Core Facility', 1),
('ic', 'IC', 1),
('leso', 'Solar Energy and Building Physics Laboratory', 1),
('lch', 'Hydraulic Constructions Laboratory LCH', 1),
('ghi', 'Global Health Institute', 1),
('enac', 'ENAC', 1),
('mtei', 'Management of Technology and Entrepreneurship Institute', 1),
('sv', 'SV', 1),
('campus-durable', 'Sustainable campus', 1),
('agenda-lcav', 'Agenda LCAV', 1),
('brain-mind-institute', 'Brain Mind Institute', 1),
('lcpm-related', 'LCPM related', 1),
('icom', 'Steel Structures Laboratory ICOM', 1),
('ic-colloquium', 'IC Colloquium', 1),
('cnp', 'CNP Center for Neuroprosthetics', 1),
('maths', 'maths', 1),
('promotionetudes', 'study programs promotion', 1),
('nccr-synapsy', 'National Centre of Competence in Research Synapsy', 1),
('inter', 'Urban Planning', 1),
('archizoom', 'Archizoom', 1),
('isic', 'Institute of Chemical Sciences and Engineering', 1),
('cdm', 'CDM', 1),
('sb', 'SB', 1),
('associations', 'Associations', 1),
('cdh', 'CdH', 1),
('lms', 'Laboratory of Soil Mechanics LMS', 1),
('artificial-intelligence-and-machine-learning', 'Artificial Intelligence & Machine Learning', NULL),
('algorithms-and-theoretical-computer-science', 'Algorithms & Theoretical Computer Science', NULL),
('unlabeled', 'Unlabeled', NULL),
('sfiepfl', 'Swiss Finance Institute @ EPFL', 1),
('polyprog', 'PolyProg', 1),
('last-events', 'LAST EVENTS', 1),
('cess', 'Civil engineering seminar series', 1),
('computational-biology', 'Computational Biology', NULL),
('computer-architecture-and-integrated-systems', 'Computer Architecture & Integrated Systems', NULL),
('data-management-and-information-retrieval', 'Data Management & Information Retrieval', NULL),
('graphics-and-vision', 'Graphics & Vision', NULL),
('human-computer-interaction', 'Human-Computer Interaction', NULL),
('information-and-communication-theory', 'Information & Communication Theory', NULL),
('programming-languages-and-formal-methods', 'Programming Languages & Formal Methods', NULL),
('security-and-cryptography', 'Security & Cryptography', NULL),
('signal-and-image-processing', 'Signal & Image Processing', NULL),
('systems-and-networks', 'Systems & Networks', NULL),
('crpp', 'Center for Research In Plasma Physics', 1),
('sph', 'Physics Section', 1),
('lcpm-meetings', 'LCPM meetings', 1),
('enac-field-campaigns', 'ENAC - Ongoing and upcoming field campaigns', 1),
('leso-lunchtime-lectures', 'LESO LUNCHTIME LECTURES', 1),
('cape', 'Teaching Support Centre', 1),
('brain-mind-institute-seminars', 'BMI Seminars', 1),
('kis', 'kis', 1),
('equality', 'Equal Opportunities Office', 1),
('upnae', 'Prof. Naef Group', 1),
('brain-mind-institute-seminars-series', 'BMI Seminars Series', 1),
('lms-lab-logs', 'Lab Logs', 1),
('sfi', 'Swiss Finance Institute @ EPFL', 1),
('candidacy-exams', 'EDIC Candidacy Exams schedule', 1),
('lastro', 'Laboratory of Astrophysics', 1),
('computational-neuroscience-seminars', 'Computational Neuroscience Seminars', 1),
('imt-talks', 'Institute of Microengineering Talks', 1),
('dhlab', 'Digital Humanities Laboratory', 1),
('lsms', 'Computational Solid Mechanics Laboratory', 1),
('enseignants-secondaire', 'Highschool teachers', 1),
('moocs', 'Massive Open Online Courses', 1),
('travelgc', 'Travel GC', 1),
('sectiongc', 'Section de génie civil', 1),
('bioengineering', 'Institute of Bioengineering - IBI', 1),
('crag', 'Center on Risk Analysis and Risk Governance', 1),
('fifa13', 'FIFA 13 tournament', 1),
('sfi-epfl', 'Swiss Finance Institute at EPFL', 1),
('cdm-sfi-seminars', 'Finance Research Seminars', 1),
('innovationpark', 'INNOVATION PARK', 1);

INSERT INTO `eventpools` (`poolId`, `poolPicture`, `poolTitle`, `poolPlace`, `poolDetails`, `disableStar`, `disableFilterByCateg`, `disableFilterByTags`, `enableScan`, `refreshOnBack`, `sendStarred`, `noResultText`, `overrideLink`, `parentEvent`) VALUES
(-1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL);
