using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Globalization;

namespace Rechnungen
{
    public class Rechnung
    {
        public int Nummer { get; set; }
        public DateTime Datum { get; set; }
        public float Betrag { get; set; }
        public string Bezeichnung { get; set; }
        public bool Relevant { get; set; }

        public Rechnung()
        {
            Relevant = false;
        }

        public Rechnung(string csv)
        {
            try
            {
                string[] tokens = csv.Split('\t');
                Nummer = int.Parse(tokens[0]);
                Datum = DateTime.Parse(tokens[1]);
                Betrag = float.Parse(tokens[2]);
                Bezeichnung = tokens[3];
                Relevant = false;
            }
            catch (Exception e)
            {
                throw new Exception("Fehler im CSV-Format", e);
            }
        }

        public string ToCsv()
        {
            StringBuilder str = new StringBuilder();
            str.Append(Nummer);
            str.Append('\t').Append(Datum.ToString("dd.MM.yyyy"));
            str.Append('\t').Append(Betrag);
            str.Append('\t').Append(Bezeichnung);
            return str.ToString();
        }

        public override string ToString()
        {
            return String.Format("{0,3} {1}", Nummer, Bezeichnung);
        }

    }
}
