using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace schule2000ASP
{
    public class SchuelerVerwaltung
    {
        private static Schule2000 schule = new Schule2000();

        public IEnumerable<Schueler> Select(string k_id)
        {
            var liste = from s in schule.schueler 
                        where s.klasse.K_ID == k_id
                        select s;
            return liste;
        
        }

        public void Delete(int s_schnr)
        {
            Schueler sch = schule.schueler.Single(s => s.S_SCHNR == s_schnr);

           // var sch1 = (from s1 in schule.schueler where s1.S_SCHNR == s_schnr select s1).Single();

            schule.schueler.Remove(sch);

            schule.SaveChanges();

        }


        public void Update(int s_schnr, string s_name, string s_vorname, DateTime s_gebdat, string s_adresse)
        {
            Schueler sch = schule.schueler.Single(s => s.S_SCHNR == s_schnr);
            sch.S_Name = s_name;
            sch.S_Vorname = s_vorname;
            sch.S_Gebdat = s_gebdat;
            sch.S_Adresse = s_adresse;
            schule.SaveChanges();
        }

    }
}