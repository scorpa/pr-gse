using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using Bibliothek.Fachlogik;

namespace Bibliothek
{
    public partial class Verwaltung : System.Web.UI.Page
    {
        private BuchVerwaltung bvw;

        public Verwaltung()
        {
            bvw = new BuchVerwaltung();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            bvw = (BuchVerwaltung)Application["verwaltung"];
            if (bvw == null)
            {
                bvw = new BuchVerwaltung();
                Application["verwaltung"] = bvw;
            }


            BuchListe.DataSource = bvw.Buecher;
            BuchListe.DataBind();
        }

        protected void BtnNeu_Click(object sender, EventArgs e)
        {
            Buch b = new Buch
            {
                Titel = TBTitel.Text,
                Autor = TBAutor.Text,
                Preis = float.Parse(TBPreis.Text)
            };
            bvw.Add(b);
            BuchListe.DataBind();

//            Response.Redirect("Warenkorb.aspx");

            Server.Transfer("Warenkorb.aspx");
        }
    }
}