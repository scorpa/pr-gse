using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace EinfuehrungASP
{
    public partial class HelloWorld : System.Web.UI.Page
    {

        public List<string> klassen()
        {
            List<string> liste = new List<string>();
            liste.Add("1AKIF");
            return liste;
        }

        protected void Page_Load(object sender, EventArgs e)
        {
           // lKlasse.Items.Add("1AKIF");
        }

        protected void ok_Click(object sender, EventArgs e)
        {
            try
            {
                string name = tbName.Text;
                DateTime datum = DateTime.Parse(tbGeburt.Text);
                string klasse = lKlasse.SelectedValue;
                lbAusgabe.Text = String.Format("{0} ({1}) ist {2} Jahre alt",
                    name, klasse, (DateTime.Today - datum).Days/365);
            }
            catch (Exception ex)
            {
                lbAusgabe.Text = "Geburtsdatum ist ungültig";
                lbAusgabe.ForeColor = System.Drawing.Color.Red;
            }


        }


    }
}