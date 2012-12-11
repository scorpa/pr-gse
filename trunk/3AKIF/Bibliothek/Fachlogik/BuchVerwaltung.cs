using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Bibliothek.Fachlogik
{
    public class BuchVerwaltung
    {
        private List<Buch> buecher = new List<Buch>();

        public List<Buch> Buecher { get { return buecher; } }

        public void Add(Buch b)
        {
            buecher.Add(b);
        }
    }
}