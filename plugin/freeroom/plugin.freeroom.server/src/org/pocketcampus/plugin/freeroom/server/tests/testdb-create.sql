CREATE TABLE IF NOT EXISTS `roomslist` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `building` varchar(255) NOT NULL,
  `room_number` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `capacity` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `roomsoccupancy` (
  `rid` int(11) NOT NULL DEFAULT '-1',
  `timestampStart` bigint(20) NOT NULL,
  `timestampEnd` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
