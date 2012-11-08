using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Jazzverein
{
    public class Beispieldaten
    {
        public static List<Instrument> Instrumente = new List<Instrument>()
            {
                new Instrument() {Bezeichnung="Saxophon", Kuerzel="sax"},
                new Instrument() {Bezeichnung="Clarinet", Kuerzel="cla"},
                new Instrument() {Bezeichnung="Gitarre", Kuerzel="g"},
                new Instrument() {Bezeichnung="Keyboard", Kuerzel="kb"},
                new Instrument() {Bezeichnung="Schlagzeug", Kuerzel="dr"},
                new Instrument() {Bezeichnung="Bass", Kuerzel="b"},
                new Instrument() {Bezeichnung="Gesang", Kuerzel="voc"},
                new Instrument() {Bezeichnung="Flöte", Kuerzel="flu"}
            };

        public static List<Location> Locs = new List<Location>()
        {
            new Location() {Bezeichnung="Ballingerhalle", StrasseHausnr="Franzenskai 23", Ort="Wien", AnzahlPersonen=2300},
            new Location() {Bezeichnung="Theater am Berg", StrasseHausnr="Berggasse 15", Ort="Krauttal", AnzahlPersonen=70},
            new Location() {Bezeichnung="Jazztheatre", StrasseHausnr="Grabengasse 18", Ort="Mödling", AnzahlPersonen=100},
            new Location() {Bezeichnung="Peter and Pan", StrasseHausnr="Kollmitzergasse 29", Ort="Wien", AnzahlPersonen=300},
            new Location() {Bezeichnung="Casino- kleiner Saal", StrasseHausnr="Franz Josefs Ring 1", Ort="Baden", AnzahlPersonen=180},
            new Location() {Bezeichnung="Weberhaus", StrasseHausnr="Hauptstr. 73", Ort="Brunn am Gebirge", AnzahlPersonen=80}
        };

        public static List<Musiker> Musikers = new List<Musiker>()
        {
            new Musiker() {Vorname="Helmut", Nachname="Gruener", EMail="helmut.gruener@gmx.at",
                Instrumente= new List<Instrument>(){Instrumente[3], Instrumente[4]} },
            new Musiker() {Vorname="Toni", Nachname="Rabl", EMail="trabl@telering.at",
                Instrumente= new List<Instrument>(){Instrumente[5]} },
            new Musiker() {Vorname="Werner", Nachname="Potter", EMail="w.potter@gmail.com",
                Instrumente= new List<Instrument>(){Instrumente[6], Instrumente[5]} },
            new Musiker() {Vorname="Willi", Nachname="Ratz", EMail="",
                Instrumente= new List<Instrument>(){Instrumente[0], Instrumente[1]} },
            new Musiker() {Vorname="Gerhard", Nachname="Wollner", EMail="gwollner@gmx.at",
                Instrumente= new List<Instrument>(){Instrumente[0], Instrumente[1], Instrumente[3], Instrumente[5]} },
            new Musiker() {Vorname="Anna", Nachname="Gruber", EMail="anna@gruber.at",
                Instrumente= new List<Instrument>(){Instrumente[6], Instrumente[4]} },
            new Musiker() {Vorname="Maria", Nachname="Vesa", EMail="vesamaria@jazzclub.at",
                Instrumente= new List<Instrument>(){Instrumente[7]} },
            new Musiker() {Vorname="Hans", Nachname="Hollmann", EMail="",
                Instrumente= new List<Instrument>(){Instrumente[2], Instrumente[5], Instrumente[6]} },
            new Musiker() {Vorname="Fred", Nachname="Miller", EMail="Fred.Miller@gmx.net",
                Instrumente= new List<Instrument>(){Instrumente[2], Instrumente[4]} }
        };

        public static List<Gruppe> Groups = new List<Gruppe>()
        {
            new Gruppe() { Bezeichnung= "Montreux Group", Musikerliste=new List<Musiker>(){Musikers[0], Musikers[3], Musikers[4], Musikers[5] }},
            new Gruppe() { Bezeichnung= "Vienna Jazz Musicians", Musikerliste=new List<Musiker>(){Musikers[1], Musikers[3], Musikers[6], Musikers[8] }},
            new Gruppe() { Bezeichnung= "Grasshoppers", Musikerliste=new List<Musiker>(){Musikers[0], Musikers[2], Musikers[7], Musikers[8] }},
            new Gruppe() { Bezeichnung= "Brave Men Trio", Musikerliste=new List<Musiker>(){Musikers[2], Musikers[3], Musikers[4] }},
            new Gruppe() { Bezeichnung= "The 4 Men", Musikerliste=new List<Musiker>(){Musikers[6], Musikers[7], Musikers[8], Musikers[5] }},
            new Gruppe() { Bezeichnung= "Kramer Band", Musikerliste=new List<Musiker>(){Musikers[0], Musikers[3], Musikers[4], Musikers[5], Musikers[6], Musikers[7], Musikers[8] }}
        };

        public static List<Konzert> Konzerte = new List<Konzert>()
        {
            new Konzert() { Bezeichnung= "Herbstfestival", Beginn=new DateTime(2012,11,10,19,00,00), Veranstaltungsort=Locs[2], Beschreibung="Ein Fest der Jazzfamilie",
                Gruppen= new List<Gruppe>(){Groups[0], Groups[2], Groups[3], Groups[5]}  },
            new Konzert() { Bezeichnung= "Jazzcafe", Beginn=new DateTime(2012,10,31,19,30,00), Veranstaltungsort=Locs[1], Beschreibung="",
                Gruppen= new List<Gruppe>() {Groups[5]}  },
            new Konzert() { Bezeichnung= "Jazzcafe", Beginn=new DateTime(2012,11,03,19,00,00), Veranstaltungsort=Locs[1], Beschreibung="Kunststücke",
                Gruppen= new List<Gruppe>() {Groups[4]}  },
            new Konzert() { Bezeichnung= "Jazzcocktail", Beginn=new DateTime(2012,12,01,19,30,00), Veranstaltungsort=Locs[4], Beschreibung="",
                Gruppen= new List<Gruppe>() {Groups[1], Groups[4], Groups[3], Groups[5]}  },
            new Konzert() { Bezeichnung= "Jazz Today", Beginn=new DateTime(2012,10,29,19,00,00), Veranstaltungsort=Locs[0], Beschreibung="",
                Gruppen= new List<Gruppe>() {Groups[0], Groups[1], Groups[4]}  }
        };


    }


     
}
