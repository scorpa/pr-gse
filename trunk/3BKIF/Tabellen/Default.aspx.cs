using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Tabellen
{
    public partial class Default : System.Web.UI.Page
    {
        private static List<Person> personen = new List<Person>();

        static Default()
        {
            personen.Add(new Person { Id = 1, Name = "NN1", Geburtstag = new DateTime(1990, 1, 1) });
            personen.Add(new Person { Id = 2, Name = "NN2", Geburtstag = new DateTime(1990, 2, 2) });
            personen.Add(new Person { Id = 3, Name = "NN2", Geburtstag = new DateTime(1990, 3, 3) });
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }
    }
}