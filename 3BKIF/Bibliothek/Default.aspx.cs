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
        }
    }
}