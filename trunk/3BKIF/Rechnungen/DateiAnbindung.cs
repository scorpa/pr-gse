using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Rechnungen
{
    public class DateiAnbindung
    {
        public static void Speichern(List<Rechnung> liste, string datei)
        {
            try
            {
                using (StreamWriter writer = new StreamWriter(datei))
                {
                    foreach (Rechnung r in liste)
                        writer.WriteLine(r.ToCsv());
                }
            }
            catch (Exception e)
            {
                throw new Exception("Fehler beim Speichern", e);
            }
        }

        public static List<Rechnung> Laden(string datei)
        {
            List<Rechnung> liste = new List<Rechnung>();
            try
            {
                using (StreamReader reader = new StreamReader(datei))
                {
                    string line;
                    while ((line = reader.ReadLine()) != null)
                    {
                        if (line.Trim().Length > 0)
                            liste.Add(new Rechnung(line));
                    }
                }
            }
            catch (Exception e)
            {
                throw new Exception("Fehler beim Einlesen", e);
            }

            return liste;
        }
            
    }
}
