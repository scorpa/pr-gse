using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Data.Entity.Infrastructure;

namespace EntityConcurrency
{
    class Program
    {
        static void Main(string[] args)
        {
            Webshop shop = new Webshop();

            Adresse a = shop.adressen.Single(adr => adr.a_id == 7);

            Console.WriteLine("originale Adresse: {0} {1} - {2}", a.a_plz, a.a_ort, a.a_strasse);
            Console.ReadLine();

            a.a_strasse = "Neue Straße 25";
            Console.WriteLine("veränderte Adresse: {0} {1} - {2}", a.a_plz, a.a_ort, a.a_strasse);





            try
            {
                shop.SaveChanges();
            }
            catch (DbUpdateConcurrencyException ex)
            {
                Console.WriteLine("Property:\toriginal\tdatabase\tlocal");
                foreach (DbEntityEntry entry in ex.Entries)
                {
                    foreach (string prop in entry.CurrentValues.PropertyNames)
                    {
                        Console.WriteLine("{0}:\t{1}\t{2}\t{3}", prop,
                            entry.OriginalValues[prop],
                            entry.GetDatabaseValues()[prop], 
                            entry.CurrentValues[prop]);
                    }
                    entry.Reload();
                }
                Console.WriteLine("Adresse in DB: {0} {1} - {2}", a.a_plz, a.a_ort, a.a_strasse);
            }

            Console.ReadLine();
        }

        

    }
}
