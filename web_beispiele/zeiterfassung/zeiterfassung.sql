-- phpMyAdmin SQL Dump
-- version 2.6.4-pl3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 11. März 2011 um 15:58
-- Server Version: 5.0.15
-- PHP-Version: 5.0.5
--
-- Datenbank: `zeiterfassung`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `mitarbeiter`
--

CREATE TABLE `mitarbeiter` (
  `m_nr` int(11) NOT NULL auto_increment,
  `m_name` varchar(64) collate latin1_general_ci NOT NULL,
  `m_pwd` varchar(16) collate latin1_general_ci NOT NULL,
  `m_stunden` int(11) NOT NULL,
  PRIMARY KEY  (`m_nr`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

--
-- Daten für Tabelle `mitarbeiter`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `zeitstempel`
--

CREATE TABLE `zeitstempel` (
  `z_id` int(11) NOT NULL auto_increment,
  `fk_m_id` int(11) NOT NULL,
  `z_kommen` tinyint(1) NOT NULL,
  `z_timestamp` timestamp NULL default NULL,
  PRIMARY KEY  (`z_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

--
-- Daten für Tabelle `zeitstempel`
--

