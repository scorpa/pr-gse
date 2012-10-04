using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;


namespace Dateizugriff
{
    public class Program
    {
        static void Main(string[] args)
        {
            FileInfo datei = new FileInfo(@"..\..\Personen.txt");
            FileInfo datei2 = new FileInfo(@"..\..\Personen.xml");

            IList<Person> personen = DateiAnbindung.einlesen(datei);

            foreach (Person p in personen)
                Console.WriteLine(p);



            DateiAnbindung.speichern(personen[0], datei);



            Console.ReadLine();

        }

    }

 
}
