-- phpMyAdmin SQL Dump
-- version 2.6.4-pl3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Erstellungszeit: 16. April 2010 um 22:54
-- Server Version: 5.0.15
-- PHP-Version: 5.0.5
-- 
-- Datenbank: `vhs`
-- 

-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `anmeldungen`
-- 

CREATE TABLE IF NOT EXISTS anmeldungen (
  C_NUMMER int(10) unsigned NOT NULL,
  KURSE_K_CODE varchar(20) collate latin1_general_ci NOT NULL,
  STUDENTEN_S_ID int(10) unsigned NOT NULL,
  PRIMARY KEY  (C_NUMMER,KURSE_K_CODE,STUDENTEN_S_ID),
  KEY CONTAINER_FKIndex1 (KURSE_K_CODE),
  KEY CONTAINER_FKIndex2 (STUDENTEN_S_ID)
) AUTO_INCREMENT=1 ;

-- 
-- Daten für Tabelle `anmeldungen`
-- 


-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `kurse`
-- 

CREATE TABLE IF NOT EXISTS kurse (
  K_CODE varchar(20) collate latin1_general_ci NOT NULL,
  K_TITEL varchar(128) collate latin1_general_ci default NULL,
  K_BEGINN datetime default NULL,
  K_ENDE datetime default NULL,
  K_PLAETZE int(10) unsigned default NULL,
  PRIMARY KEY  (K_CODE)
);

-- 
-- Daten für Tabelle `kurse`
-- 


-- --------------------------------------------------------

-- 
-- Tabellenstruktur für Tabelle `studenten`
-- 

CREATE TABLE IF NOT EXISTS studenten (
  S_ID int(10) unsigned NOT NULL,
  S_NAME varchar(128) collate latin1_general_ci default NULL,
  S_ADRESSE varchar(256) collate latin1_general_ci default NULL,
  S_TELEFON varchar(32) collate latin1_general_ci default NULL,
  PRIMARY KEY  (S_ID)
) AUTO_INCREMENT=1 ;

-- 
-- Daten für Tabelle `studenten`
-- 

