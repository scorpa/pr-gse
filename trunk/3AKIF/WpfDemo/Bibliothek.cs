using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace WpfDemo
{
    class Bibliothek
    {
        public List<Buch> Liste()
        {
            List<Buch> liste = new List<Buch>();
            liste.Add(new Buch() { Titel = "Rotkäppchen", Seiten = 10 });
            liste.Add(new Buch() { Titel = "Schneewittchen", Seiten = 20 });

            return liste;
        }

    }
}
