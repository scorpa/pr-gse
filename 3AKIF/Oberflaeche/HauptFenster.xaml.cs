using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using Dateizugriff;

namespace Oberflaeche
{
    /// <summary>
    /// Interaction logic for HauptFenster.xaml
    /// </summary>
    public partial class HauptFenster : Window
    {
        public HauptFenster()
        {
            InitializeComponent();


            Person p1 = new Person() { Vorname = "Hans", Nachname = "Huber" };
            Person p2 = new Person() { Vorname = "Susi", Nachname = "Sauer" };
            Person p3 = new Person() { Vorname = "Max", Nachname = "Mustermann" };

            //personenListe.Items.Add(p1);
            //personenListe.Items.Add(p2);
            //personenListe.Items.Add(p3);

            List<Person> personen = new List<Person>();
            personen.Add(p1);
            personen.Add(p2);
            personen.Add(p3);

            personenListe.ItemsSource = personen;

        }

        private void ok(object sender, RoutedEventArgs e)
        {

        }
    }
}
