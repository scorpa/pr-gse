CREATE TABLE IF NOT EXISTS kurse
(
	K_CODE varchar( 20 ) ,
	K_TITEL varchar( 128 ) ,
	K_BEGINN datetime,
	K_ENDE datetime,
	K_PLAETZE int( 10 ) ,
	PRIMARY KEY ( K_CODE )
);

CREATE TABLE IF NOT EXISTS studenten
(
	S_ID int( 10 ) unsigned NOT NULL AUTO_INCREMENT ,
	S_NAME varchar( 128 ) ,
	S_ADRESSE varchar( 256 ) ,
	S_TELEFON varchar( 32 ) ,
	S_KENNWORT varchar( 32 ) ,
	PRIMARY KEY ( S_ID )
);

CREATE TABLE IF NOT EXISTS anmeldungen
(
	A_NUMMER int( 10 ) unsigned NOT NULL AUTO_INCREMENT ,
	KURSE_K_CODE varchar( 20 ) ,
	STUDENTEN_S_ID int( 10 ) unsigned NOT NULL ,
	PRIMARY KEY ( A_NUMMER, KURSE_K_CODE, STUDENTEN_S_ID ) ,
	FOREIGN KEY ( KURSE_K_CODE ) REFERENCES kurse( K_CODE ) ,
	FOREIGN KEY ( STUDENTEN_S_ID ) REFERENCES studenten( S_ID )
);