//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace schule2000ASP
{
    using System;
    using System.Collections.Generic;
    
    public partial class gegenstaende
    {
        public gegenstaende()
        {
            this.pruefungen = new HashSet<pruefungen>();
            this.stunden = new HashSet<stunden>();
        }
    
        public string G_ID { get; set; }
        public string G_Bez { get; set; }
    
        public virtual ICollection<pruefungen> pruefungen { get; set; }
        public virtual ICollection<stunden> stunden { get; set; }
    }
}
