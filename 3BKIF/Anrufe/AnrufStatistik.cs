using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Anrufe
{
    class AnrufStatistik
    {
        private List<Anruf> anrufe = new List<Anruf>();

        public AnrufStatistik()
        {
            Add(new Anruf() { Nummer = "1234567", Zeitpunkt = DateTime.Now });
            Add(new Anruf() { Nummer = "1234567", Zeitpunkt = DateTime.Now });
            Add(new Anruf() { Nummer = "45678", Zeitpunkt = DateTime.Now });
        }

        public void Add(Anruf a)
        {
            anrufe.Add(a);
        }

        public List<AnrufInfo> AlleNummern
        {
            get
            {
                List<AnrufInfo> liste = new List<AnrufInfo>();
                foreach (Anruf a in anrufe)
                {
                    bool gefunden = false;
                    foreach (AnrufInfo info in liste)
                    {
                        if (info.Nummer == a.Nummer)
                        {
                            info.Anzahl++;
                            gefunden = true;
                        }
                    }
                    if (!gefunden)
                    {
                        AnrufInfo info = new AnrufInfo() { Nummer = a.Nummer, Anzahl = 1 };
                        liste.Add(info);
                    }
                }
                return liste;
            }
        }

        
    }

    public class AnrufInfo
    {
        public string Nummer { get; set; }
        public int Anzahl { get; set; }

        public override string ToString()
        {
            return Nummer + "   " + Anzahl;
        }
    }
}
