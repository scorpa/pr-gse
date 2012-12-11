using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Bibliothek
{
    public partial class WarenkorbVerwaltung : System.Web.UI.Page
    {
        private Warenkorb warenkorb;
        private BuchVerwaltung verwaltung;

        protected void Page_Load(object sender, EventArgs e)
        {
            warenkorb = (Warenkorb)Session["warenkorb"];
            if (warenkorb == null)
            {
                warenkorb = new Warenkorb();
                Session["warenkorb"] = warenkorb;
            }
            GWarenkorb.DataSource = warenkorb.Buecher;
            GWarenkorb.DataBind();


            verwaltung = (BuchVerwaltung)Application["verwaltung"];
            if (verwaltung != null && !IsPostBack)
            {
                DAuswahl.DataSource = verwaltung.Buecher;
                DAuswahl.DataBind();
            }
        }

        protected void BnHinzu_Click(object sender, EventArgs e)
        {
            int index = DAuswahl.SelectedIndex;
            if (index >= 0)
            {
                warenkorb.Add(verwaltung.Buecher[index]);
                GWarenkorb.DataBind();
            }
        }

 
    }
}