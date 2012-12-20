using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Tabellen
{
    public partial class PersonenAnzeige : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
     
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Person p = new Person { Name = TextBox4.Text };
            new PersonenVerwaltung().Insert(p);
        }
    }
}