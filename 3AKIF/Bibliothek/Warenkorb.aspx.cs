using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using Bibliothek.Fachlogik;


namespace Bibliothek
{
    public partial class Warenkorb : System.Web.UI.Page
    {
        private BuchVerwaltung warenkorb;
        private BuchVerwaltung verwaltung;

        protected void Page_Load(object sender, EventArgs e)
        {
            warenkorb = (BuchVerwaltung)Session["warenkorb"];
            if (warenkorb == null)
            {
                warenkorb = new BuchVerwaltung();
                Session["warenkorb"] = warenkorb;
            }

            BuchListe.DataSource = warenkorb.Buecher;
            BuchListe.DataBind();

            verwaltung = (BuchVerwaltung)Application["verwaltung"];

            if (verwaltung != null && !IsPostBack)
            {
                Auswahl.DataSource = verwaltung.Buecher;
                Auswahl.DataBind();
            }

        }

        protected void BtnEinfuegen_Click(object sender, EventArgs e)
        {
            int index = Auswahl.SelectedIndex;
            Buch b = verwaltung.Buecher[index];
            warenkorb.Add(b);
            BuchListe.DataBind();

        }
    }
}