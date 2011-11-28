
CREATE TABLE fluege (
  id int(10) unsigned NOT NULL auto_increment,
  von text,
  nach text,
  datum date default NULL,
  letztes_update timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE reservierungen (
  id int(10) unsigned NOT NULL auto_increment,
  fk_f_id int(10) unsigned NOT NULL,
  `name` text,
  letztes_update timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (id),
  KEY reservierungen_FKIndex1 (fk_f_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



ALTER TABLE reservierungen
  ADD CONSTRAINT FK451A40CA18F0C890 FOREIGN KEY (fk_f_id) REFERENCES fluege (id),
  ADD CONSTRAINT reservierungen_ibfk_1 FOREIGN KEY (fk_f_id) REFERENCES fluege (id) ON DELETE NO ACTION ON UPDATE NO ACTION;
