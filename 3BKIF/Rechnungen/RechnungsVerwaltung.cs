using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections.ObjectModel;

namespace Rechnungen
{
    class RechnungsVerwaltung
    {
        public RechnungsVerwaltung()
        {
            Rechnungen = new ObservableCollection<Rechnung>();
        }

        // ObervableCollection notifiziert bei Datenbindung das Oberflächenelement
        // wenn Daten dazu/weg-gekommen sind
        public ObservableCollection<Rechnung> Rechnungen { get; set; }

        public void Add(Rechnung r)
        {
            Rechnungen.Add(r);
        }

        public void Add(List<Rechnung> liste)
        {
            foreach (Rechnung r in liste)
                Add(r);
        }

        public void Clear()
        {
            Rechnungen.Clear();
        }

        public float SummeAuswahl
        {
            get
            {
                float sum = 0;
                foreach (Rechnung r in Rechnungen)
                {
                    if (r.Relevant)
                        sum += r.Betrag;
                }
                return sum;
            }
        }

        public List<Rechnung> AuswahlListe
        {
            get
            {
                List<Rechnung> liste = new List<Rechnung>();
                foreach (Rechnung r in Rechnungen)
                {
                    if (r.Relevant)
                        liste.Add(r);
                }
                return liste;
            }
        }



    }
}
