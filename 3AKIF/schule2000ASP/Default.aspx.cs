using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Data.Entity;

namespace schule2000ASP
{
    public partial class Default : System.Web.UI.Page
    {
        private static Schule2000 schule = new Schule2000();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                schule.klassen.Load();
                KlassenAuswahl.DataSource = schule.klassen.Local;
                KlassenAuswahl.DataBind();
                Session["klasse"] = KlassenAuswahl.SelectedValue;
            }

        }

        protected void KlassenAuswahl_SelectedIndexChanged(object sender, EventArgs e)
        {
            Session["klasse"] = KlassenAuswahl.SelectedValue;

        }
    }
}