


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

            Book[] books = SampleDataAccess.DBooks;

            var liste = (from b in books
                         where b.PageCount > 200
                         select new { Titel = b.Title, Seiten = b.PageCount }).
                         OrderBy(buch => buch.Seiten).Reverse();

            var liste2 = from b in SampleDataAccess.DBooks
                         join r in SampleDataAccess.DReviews on b equals r.Book
                         group r by b.Title into g
                         select new { Titel = g.Key, Anzahl = g.Count() };
                        
            


            foreach (var b in liste2)
            {
                Console.WriteLine(b);
            }

            Console.ReadLine();


        }
    }
}
