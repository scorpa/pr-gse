using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Serialization;

namespace Dateizugriff
{

    public class Person 
    {
        public string Vorname { get; set; }
        public string Nachname { get; set; }
        public DateTime Geburt { get; set; }
        public int Groesse { get; set; }


        public override string ToString()
        {
            return Vorname + "\t" + Nachname + "\t" + Geburt
                + "\t" + Groesse;
        }


    }
}
