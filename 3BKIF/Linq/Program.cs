


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using LinqInAction.LinqBooks.Common;
using DataSampleBinding;

namespace Linq
{
    class Program
    {
        static void Main(string[] args)
        {

            var liste = SampleDataAccess.DBooks
                .OrderBy(buch => buch.PageCount);

    

            var liste2 = liste
                .GroupBy(b => b.Publisher);

            ObjectDumper.Write(liste);


            foreach (var group in liste2)
            {
                Console.WriteLine("{0} {1}", 
                    group.Key, group);
            }


           // ObjectDumper.Write(liste, 3);
 

            Console.ReadLine();










        //    Book[] books = SampleDataAccess.DBooks;

        //    var liste = (from b in books
        //                 where b.PageCount > 200
        //                 select new { Titel = b.Title, Seiten = b.PageCount }).
        //                 OrderBy(buch => buch.Seiten).Reverse();

        //    var liste2 = from b in SampleDataAccess.DBooks
        //                 join r in SampleDataAccess.DReviews on b equals r.Book
        //                 group r by b.Title into g
        //                 select new { Titel = g.Key, Anzahl = g.Count() };


        //    var liste3 = from b in books
        //                 where b.Publisher.Name == "FunBooks"
        //                 select b.Title;

        //    Author a = (from author in SampleDataAccess.DAuthors
        //                where author.LastName == "Good"
        //                select author).First();

        //    var liste4 = from b in books
        //                 where b.Authors.Contains(a)
        //                 select b.Title;




        //    foreach (var b in liste4)
        //    {
        //        Console.WriteLine(b);
        //    }

        //    Console.ReadLine();


        }
    }
}
