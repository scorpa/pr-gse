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
    
    public partial class raeume
    {
        public raeume()
        {
            this.stunden = new HashSet<stunden>();
        }
    
        public string R_ID { get; set; }
        public Nullable<short> R_Plaetze { get; set; }
    
        public virtual ICollection<stunden> stunden { get; set; }
    }
}
