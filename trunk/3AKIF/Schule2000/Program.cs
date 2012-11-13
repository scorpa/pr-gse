using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;



namespace Schule2000
{
    class Program
    {
        static void Main(string[] args)
        {
            schule2000Entities schule = new schule2000Entities();

            schueler s2 = new schueler();
            s2.S_SCHNR = 2;
            s2.S_Name = "MeierHuber";
            schule.schueler.Add(s2);


            schueler s1 = schule.schueler.OrderBy(s => s.S_SCHNR).First();

            s1.S_Name = "HuberMeier";

            int n = schule.SaveChanges();

            Console.WriteLine("{0} Datensätze wurden verändert", n);
 
            Console.ReadLine();
        }
    }
}
