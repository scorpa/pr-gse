using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Bibliothek
{
    public partial class Default : System.Web.UI.Page
    {
        private BuchVerwaltung verwaltung;

        protected void Page_Load(object sender, EventArgs e)
        {
            verwaltung = (BuchVerwaltung)Application["verwaltung"];
            if (verwaltung == null)
            {
                verwaltung = new BuchVerwaltung();
                Application["verwaltung"] = verwaltung;
            }

            GBuecher.DataSource = verwaltung.Buecher;
            GBuecher.DataBind();
        }

        protected void BnNeu_Click(object sender, EventArgs e)
        {
            Buch b = new Buch
            {
                Titel = TBTitel.Text,
                Isbn = TBIsbn.Text,
                Seiten = int.Parse(TBSeiten.Text)
            };
            verwaltung.Add(b);
            GBuecher.DataBind();
        }
    }
}