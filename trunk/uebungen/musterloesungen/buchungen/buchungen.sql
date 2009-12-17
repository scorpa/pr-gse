CREATE TABLE buchungen(
	id INTEGER PRIMARY KEY,
	datum DATE,
	buchungstext VARCHAR(120),
	betrag DECIMAL
);

INSERT INTO buchungen VALUES (1, '2009-02-01', 'Bareinzahlung', 120);
INSERT INTO buchungen VALUES (2, '2009-02-02', 'Abhebung', -10.50);
INSERT INTO buchungen VALUES (3, '2009-02-03', 'Zinsen', 1.22);
INSERT INTO buchungen VALUES (4, '2009-02-01', 'Abbuchung', -22.22);
INSERT INTO buchungen VALUES (5, '2009-02-01', 'Überweisung', 1000);
