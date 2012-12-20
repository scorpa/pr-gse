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
            TextBox tbName = (TextBox)GridView1.FooterRow.FindControl("TbName");
            Person p = new Person { Name = tbName.Text };
            new PersonenVerwaltung().Insert(p);          
        }

    }
}