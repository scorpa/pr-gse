using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ASPEinfuehrung
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            ScriptManager.ScriptResourceMapping.AddDefinition("jquery",
                new ScriptResourceDefinition { Path = "~/scripts/jquery-1.7.1.js" });
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            int alter = (DateTime.Today - DateTime.Parse(tbDatum.Text)).Days / 365;
            lbAusgabe.Text = String.Format("{0} aus Klasse {1} ist {2} Jahre alt",
                tbName.Text, klassenliste.SelectedValue, alter);
        }
    }
}