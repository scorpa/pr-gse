using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jazzverein
{
    public class Instrument
    {
        public string Bezeichnung { get; set; }
        public string Kuerzel { get; set; }
    }

    public class Musiker
    {
        public string Vorname { get; set; }
        public string Nachname { get; set; }
        public string EMail { get; set; }
        public List<Instrument> Instrumente { get; set; }
    }

    public class Location
    {
        public string Bezeichnung { get; set; }
        public string StrasseHausnr { get; set; }
        public string Ort { get; set; }
        public int AnzahlPersonen { get; set; }
    }

    public class Gruppe
    {
        public string Bezeichnung { get; set; }
        public List<Musiker> Musikerliste { get; set; }
    }

    public class Konzert
    {
        public string Bezeichnung { get; set; }
        public Location Veranstaltungsort { get; set; }
        public DateTime Beginn { get; set; }
        public string Beschreibung { get; set; }
        public List<Gruppe> Gruppen { get; set; }
    }
}
