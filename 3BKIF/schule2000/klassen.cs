//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace schule2000
{
    using System;
    using System.Collections.Generic;
    
    public partial class klassen
    {
        public klassen()
        {
            this.schueler2 = new HashSet<schueler>();
            this.stunden = new HashSet<stunden>();
        }
    
        public string K_ID { get; set; }
        public string K_Bez { get; set; }
    
        public virtual lehrer lehrer { get; set; }
        public virtual schueler schueler { get; set; }
        public virtual schueler schueler1 { get; set; }
        public virtual ICollection<schueler> schueler2 { get; set; }
        public virtual ICollection<stunden> stunden { get; set; }
    }
}
