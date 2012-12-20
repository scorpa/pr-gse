using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Tabellen
{
    public class Person
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public DateTime Geburtstag { get; set; }
        public string Kinder { get; set; }

        public Person()
        {
            Kinder = "eins";
            Geburtstag = DateTime.Today;

        }
    }
}