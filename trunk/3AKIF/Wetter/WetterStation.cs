using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Collections.ObjectModel;

namespace Wetter
{
    public class WetterStation
    {
        public ObservableCollection<Eintrag> Werte { get; set; }

        public WetterStation()
        {
            Werte = new ObservableCollection<Eintrag>();
        }

        public static WetterStation operator +(WetterStation station, Eintrag eintrag)
        {
            station.Werte.Add(eintrag);
            return station;
        }

        public static WetterStation operator -(WetterStation station, Eintrag eintrag)
        {
            station.Werte.Remove(eintrag);
            return station;
        }

    }
}
