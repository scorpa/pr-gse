using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Tabellen
{
    public partial class Default : System.Web.UI.Page
    {
        private static List<Person> personen = new List<Person>();
        private static List<string> auswahlListe = new List<string>();

        static Default()
        {
            personen.Add(new Person { Id = 1, Name = "NN1", Geburtstag = new DateTime(1990, 1, 1) });
            personen.Add(new Person { Id = 2, Name = "NN2", Geburtstag = new DateTime(1990, 2, 2) });
            personen.Add(new Person { Id = 3, Name = "NN2", Geburtstag = new DateTime(1990, 3, 3) });

            auswahlListe.Add("Auswahl1");
            auswahlListe.Add("Auswahl2");
            auswahlListe.Add("Auswahl3");
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            ScriptManager.ScriptResourceMapping.AddDefinition("jquery",
                new ScriptResourceDefinition { Path = "~/jquery-1.7.1.js", ResourceName = "jquery" });

            if (!IsPostBack)
            {
                DropDownList1.DataSource = personen;
                DropDownList1.DataBind();
                GridView1.DataSource = personen;
                GridView1.DataBind();
                Grid2.DataSource = personen;
                Grid2.DataBind();
            }
        }

        protected void OK_Click(object sender, EventArgs e)
        {
            string value = DropDownList1.SelectedValue;
            int id = int.Parse(value);

            Person selected = null;

            foreach (Person p in personen)
            {
                if (p.Id == id)
                    selected = p;
            }




            
            /*
             * Person selected = db.personen.Single(p => p.Id == id)
             */ 

        }

        protected void GridView1_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            int id = (int)e.Keys["Id"];
            Person pers = personen.Single(p => p.Id == id);

            personen.Remove(pers);

            GridView1.DataSource = personen;
            GridView1.DataBind();
        }

        protected void GridView1_RowEditing(object sender, GridViewEditEventArgs e)
        {
            GridView1.EditIndex = e.NewEditIndex;
            GridView1.DataSource = personen;
            GridView1.DataBind();

        }

        protected void GridView1_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            int id = (int)e.Keys["Id"];
            Person pers = personen.Single(p => p.Id == id);

            pers.Name = (string)e.NewValues["Name"];
            GridView1.EditIndex = -1;


            GridView1.DataSource = personen;
            GridView1.DataBind();

            
            
        }

        protected void GridView1_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
        {
            GridView1.EditIndex = -1;
            GridView1.DataSource = personen;
            GridView1.DataBind();

            
        }

        protected void GridView2_RowEditing(object sender, GridViewEditEventArgs e)
        {
            Grid2.EditIndex = e.NewEditIndex;
            Grid2.DataSource = personen;
            Grid2.DataBind();
            


            DropDownList auswahl = (DropDownList) Grid2.Rows[e.NewEditIndex].FindControl("Auswahl");
            auswahl.DataSource = auswahlListe;
            auswahl.DataBind();




        }


        protected void GridView2_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            int id = (int)e.Keys["Id"];
            Person pers = personen.Single(p => p.Id == id);

            DropDownList auswahl = (DropDownList)Grid2.Rows[Grid2.EditIndex].FindControl("Auswahl");


            pers.Name = auswahl.SelectedValue;
            Grid2.EditIndex = -1;


            Grid2.DataSource = personen;
            Grid2.DataBind();
        }


    }
}