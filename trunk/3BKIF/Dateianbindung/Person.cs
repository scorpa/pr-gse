using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Serialization;

namespace Dateianbindung 
{

    public class Person :IComparable<Person>
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



        public int CompareTo(Person other)
        {
            return Vorname.CompareTo(other.Vorname);
        }
    }


    public enum KRITERIUM { VORNAME, NACHNAME, GEBURTSDATUM }

    public class PersonComparer : IComparer<Person>
    {
        public KRITERIUM Kriterium { get; set; }

        public PersonComparer()
        {
            Kriterium = KRITERIUM.VORNAME;
        }

        public int Compare(Person x, Person y)
        {
            switch (Kriterium)
            {
                case KRITERIUM.VORNAME:
                    return x.Vorname.CompareTo(y.Vorname);

                case KRITERIUM.NACHNAME:
                    return x.Nachname.CompareTo(y.Nachname);

                case KRITERIUM.GEBURTSDATUM:
                    return x.Geburt.CompareTo(y.Geburt);
            }
            return 0;
        }
    }
}
