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
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Controls.Primitives;

using Dateizugriff;

namespace Oberflaeche
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private TextBox tbNachname = new TextBox();
        private TextBox tbGeburt = new TextBox();


        public MainWindow()
        {
            InitializeComponent();

            // UI zusammenbauen
            UniformGrid grid = new UniformGrid();
            grid.Columns = 2;
            this.Content = grid;
            grid.Children.Add(new Label() { Content = "Nachname" });
            grid.Children.Add(tbNachname);
            grid.Children.Add(new Label() { Content = "Geburtsdatum" });
            grid.Children.Add(tbGeburt);

            Button btn = new Button(){ Content = "OK"};
            btn.Click +=new RoutedEventHandler(ok);

            grid.Children.Add(btn);


            // Person anzeigen
            Person p = new Person()
            {
                Nachname = "Meier",
                Vorname = "Fritz",
                Geburt = new DateTime(1990, 1, 1),
                Groesse = 185
            };

            AngezeigtePerson = p;
        }

        private void ok(object o, RoutedEventArgs args)
        {
            MessageBox.Show(AngezeigtePerson.ToString());
        }

        public Person AngezeigtePerson
        {
            set
            {
                tbNachname.Text = value.Nachname;
                tbGeburt.Text = value.Geburt.ToString("dd.MM.yyyy");
            }

            get
            {
                Person p = new Person(){
                    Nachname = tbNachname.Text,
                    Geburt = DateTime.Parse(tbGeburt.Text) 
                };
                return p;
            }
        }
    }
}
