using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

using System.Xml.Serialization;


namespace Dateizugriff
{
    public class DateiAnbindung
    {
        public static List<Person> einlesen(FileInfo file)
        {
            List<Person> personen = new List<Person>();
            StreamReader reader = new StreamReader(file.OpenRead());

            string zeile;

            while ((zeile = reader.ReadLine()) != null)
            {
                if (zeile.Trim().Length > 0)
                {
                    string[] tokens = zeile.Split(':');
                    Person p = new Person();
                    p.Vorname = tokens[0];
                    p.Nachname = tokens[1];
                    p.Geburt = DateTime.ParseExact(tokens[2], "dd.MM.yyyy", null);
                    p.Groesse = Int32.Parse(tokens[3]);
                    personen.Add(p);

                }
            }
            return personen;
        }


        public static void speichern(List<Person> personen, FileInfo datei)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(List<Person>));
            serializer.Serialize(datei.OpenWrite(), personen);

        }

    }
}
