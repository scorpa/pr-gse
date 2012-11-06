using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using DataSampleBinding;
using LinqInAction.LinqBooks.Common;

namespace LINQDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            Book[] books = SampleDataAccess.DBooks;

            //var liste = books
            //    .Where(buch => buch.Publisher.Name == "Joe Publishing")
            //    .Select(b => new { Titel = b.Title, Seiten = b.PageCount, Verleger = b.Publisher.Name })
            //    .OrderBy(item => item.Seiten);

            //var liste = from b in books
            //            where b.PageCount > 100
            //             select new { Titel = b.Title, Seiten = b.PageCount };


            var liste = from b in books
                        join r in SampleDataAccess.DReviews on b equals r.Book
                        group r by b into l1
                        select new { Buch = l1.Key, Reviews = l1.Count()};


            var liste2 = books.Join(SampleDataAccess.DReviews,
                b => b, r => r.Book, (b, r) => new { Buch = b, Review = r })
                .GroupBy(o => o.Buch)
                .Select(g => new {Buch = g.Key, Anzahl = g.Count()});


            var liste3 = from b in books
                         where b.Authors.Count() > 1
                         select b;


            foreach (var item in liste3)
                Console.WriteLine(item);

            IEnumerable<string> x;

            Console.ReadLine();
        }
    }


}
