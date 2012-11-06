using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Serialization;
using System.IO;

namespace Wetter
{
    class DateiAnbindung
    {
        private static XmlSerializer serializer = new XmlSerializer(typeof(WetterStation));

        public static void speichern(WetterStation station, string datei)
        {
            StreamWriter writer = new StreamWriter(datei);

            serializer.Serialize(writer, station);
            writer.Close();
        }

        public static WetterStation laden(string datei)
        {
            StreamReader reader = new StreamReader(datei);
            return (WetterStation)serializer.Deserialize(reader);
        }
    }
}
