using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using System.ComponentModel;
using System.Windows.Data;
using System.Globalization;

namespace Wetter
{
    public enum RICHTUNG {NORD, OST, SUED, WEST}
    public enum WETTER{SONNIG, REGEN, SCHNEEFALL, BEWOELKT}

    public class Eintrag
    {
        public DateTime Datum { get; set; }
        public WETTER Wetter { get; set; }
        public RICHTUNG Wind { get; set; }
        public int Temperatur { get; set; }

        public Eintrag()
        {
            Datum = DateTime.Today;
        }

        public override string ToString()
        {
            return Datum.ToString("dd.MM.yyyy");
        }

    }



}
