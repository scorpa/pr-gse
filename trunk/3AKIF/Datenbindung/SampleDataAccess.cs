using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LinqInAction.LinqBooks.Common;

namespace DataSampleBinding
{
    public class SampleDataAccess
    {
        public static Publisher[] DPublishers
        {
            get { return SampleData.Publishers; }
        }

        public static Author[] DAuthors
        {
            get { return SampleData.Authors; }
        }

        public static Book[] DBooks
        {
            get { return SampleData.Books; }
        }

        public static Subject[] DSubjects
        {
            get { return SampleData.Subjects; }
        }

        public static Review[] DReviews
        {
            get { return SampleData.Reviews; }
        }

        public static User[] DUsers
        {
            get { return SampleData.Users; }
        }
    }

}
