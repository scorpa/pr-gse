using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Bibliothek.Fachlogik
{
    public class Buch
    {
        public string Titel { get; set; }
        public string Autor { get; set; }
        public float Preis { get; set; }

        public override string ToString()
        {
            return Autor + " " + Titel;
        }
    }
}