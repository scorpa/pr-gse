using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace schule2000
{
    class Program
    {
        static void Main(string[] args)
        {
            Schule2000Entities schule = new Schule2000Entities();

            schueler s1 = schule.schueler.First();
            Console.WriteLine(s1.S_Name);

            s1.S_Name = "Hugo";



            Console.WriteLine("{0} Datensätze geändert", schule.SaveChanges());




            Console.ReadLine();
        }
    }
}
