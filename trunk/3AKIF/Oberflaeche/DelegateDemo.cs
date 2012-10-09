using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Oberflaeche
{
    public delegate int Rechnen(int a, int b);

    class DelegateDemo
    {
        private Rechnen r;

        public DelegateDemo()
        {
            setRechnen(new Rechnen(addieren));
           // setRechnen(subtrahieren);

            Rechnungen rechnungen = new Rechnungen();
            setRechnen(new Rechnen(rechnungen.mulitplizieren));


            int ergebnis = r(5, 6);
        }


        public void setRechnen(Rechnen r)
        {
            this.r = r;
        }


        private int addieren(int x, int y)
        {
            return x + y;
        }

        private int subtrahieren(int a, int b)
        {
            return a - b;
        }
    }



    public class Rechnungen
    {
        public int mulitplizieren(int a, int b)
        {
            return a * b;
        }
    }
}
