using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Globalization;

namespace Linq
{
    public class DateiAnbindung
    {
        public static List<Anruf> einlesen(string datei)
        {
            List<Anruf> liste = new List<Anruf>();
            StreamReader reader = new StreamReader(datei);
            string line;
            while ((line = reader.ReadLine()) != null)
            {
                if (line.Trim().Length > 0)
                {
                    string[] tokens = line.Split('\t');
                    Anruf a = new Anruf();
                    a.Rufnummer = tokens[4];
                    a.Zeitpunkt = DateTime.Parse(tokens[0]) + TimeSpan.Parse(tokens[1]);
                    a.Dauer = TimeSpan.Parse(tokens[2]);
                    a.Kosten = float.Parse(tokens[5], CultureInfo.InvariantCulture);
                    switch (tokens[3])
                    {
                        case "Festnetz": a.Typ = TYP.FESTNETZ; break;
                        case "Mobilnetze": a.Typ = TYP.MOBILFUNK; break;
                        default: a.Typ = TYP.SONSTIGE; break;

                    }
                    liste.Add(a);
                }
            }
            return liste;
        }
    }
}
