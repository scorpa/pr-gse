using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Linq
{
    public enum SORTIERUNG { NR_ASC, NR_DESC, ANZ_ASC, ANZ_DESC }

    public class AnrufStatistik
    {
        
        private List<Anruf> anrufe = new List<Anruf>();

        public SORTIERUNG Sortierung { get; set; }

        public void Add(Anruf a)
        {
            anrufe.Add(a);
        }

        public void AddAll(List<Anruf> liste)
        {
            foreach (Anruf a in liste)
                Add(a);
        }

        public List<Anruf> AlleAnrufe { get { return anrufe; } }

        public object NummernInfo
        {
            get
            {
                var liste = from a in anrufe
                            group a by a.Rufnummer into nrgroup
                            select new
                            {
                                Rufnummer = nrgroup.Key,
                                Anzahl = nrgroup.Count(),
                                GesamtDauer = new TimeSpan(nrgroup.Sum(a => a.Dauer.Ticks)),
                                GesamtKosten = nrgroup.Sum(a => a.Kosten)
                            };


                switch (Sortierung)
                {
                    case SORTIERUNG.NR_ASC:
                        liste = liste.OrderBy(nr => nr.Rufnummer);
                        break;
                    case SORTIERUNG.NR_DESC:
                        liste =  liste.OrderBy(nr => nr.Rufnummer).Reverse();
                        break;
                    case SORTIERUNG.ANZ_ASC:
                        liste = liste.OrderBy(nr => nr.Anzahl);
                        break;
                    case SORTIERUNG.ANZ_DESC:
                        liste = liste.OrderBy(nr => nr.Anzahl).Reverse();
                        break;
                }

                

                return liste;
            }
        }

    }
}
