using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Linq
{
    public enum TYP { SONSTIGE, FESTNETZ, MOBILFUNK }
    public class Anruf
    {
        public string Rufnummer { get; set; }
        public DateTime Zeitpunkt { get; set; }
        public TimeSpan Dauer { get; set; }
        public float Kosten { get; set; }
        public TYP Typ { get; set; }

        public override string ToString()
        {
            return Rufnummer + "\t" + Zeitpunkt + "\t" 
                + Dauer + "\t" + Kosten + "\t" + Typ;
        }
    }
}
