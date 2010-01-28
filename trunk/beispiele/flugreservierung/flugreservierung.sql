
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


INSERT INTO `flugreservierung`.`fluege` (
`flugnummer` ,
`von` ,
`nach` ,
`abflug` ,
`ankunft` ,
`sitzplaetze`
)
VALUES (
'123', 'Wien', 'London', '2010-01-29 12:55:40', '2010-01-29 14:55:48', '2'
);

INSERT INTO `flugreservierung`.`fluege` (
`flugnummer` ,
`von` ,
`nach` ,
`abflug` ,
`ankunft` ,
`sitzplaetze`
)
VALUES (
'456', 'Wien', 'Amsterdam', '2010-01-28 12:56:55', '2010-01-28 13:56:55', '150'
);
