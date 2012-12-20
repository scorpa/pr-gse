using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Tabellen
{
    public class PersonenVerwaltung
    {
        static private List<Person> personen = new List<Person>
        {
            new Person{ Id=1, Name="Fritz", Geburtstag = new DateTime(1990, 1,1)},
            new Person{ Id=2, Name="Susi", Geburtstag = new DateTime(1991, 1,1)},
            new Person{ Id=3, Name="Hans", Geburtstag = new DateTime(1992, 1,1)},
            new Person{ Id=4, Name="Lea", Geburtstag = new DateTime(1993, 1,1)},
            new Person{ Id=5, Name="Sepp", Geburtstag = new DateTime(1994, 1,1)}
        };


        public List<Person> Select()
        {
            return personen;
        }

        public void Delete(int Id)
        {
            Person pers = personen.Single(p => p.Id == Id);
            personen.Remove(pers);
        }

        public void Update(int Id, string Name, DateTime Geburtstag)
        {
            Person pers = personen.Single(p => p.Id == Id);
            pers.Name = Name;
            pers.Geburtstag = Geburtstag;
        }

    }
}