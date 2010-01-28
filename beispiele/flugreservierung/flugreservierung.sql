
CREATE TABLE fluege (
  flugnummer int(11) NOT NULL auto_increment,
  von varchar(128) NOT NULL,
  nach varchar(128) NOT NULL,
  abflug datetime NOT NULL,
  ankunft datetime NOT NULL,
  sitzplaetze int(11) NOT NULL,
  PRIMARY KEY  (flugnummer)
);


CREATE TABLE reservierungen (
  reservierungsnummer int(11) NOT NULL auto_increment,
  flugnummer int(11) NOT NULL,
  passagier_name varchar(128) NOT NULL,
  PRIMARY KEY  (reservierungsnummer)
);
