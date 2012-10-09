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

using Dateianbindung;

namespace Oberflaeche
{

    public delegate int Berechnen(int a, int b);

    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private TextBox tbName = new TextBox();
        private TextBox tbGeburt = new TextBox();
        private Person pers;


        public Berechnen B { get; set; }


        private int addieren(int a, int b)
        {
            return a + b;
        }

        private int subtrahieren(int x, int y)
        {
            return x - y;
        }


        public MainWindow()
        {
            InitializeComponent();

            B = new Berechnen(subtrahieren);
            B = subtrahieren;

            int ergebnis = B(1, 2);

            UniformGrid grid = new UniformGrid();
            Content = grid;
            grid.Columns = 2;
            grid.Children.Add(new Label(){Content = "Name"});
            grid.Children.Add(tbName);
            grid.Children.Add(new Label(){Content = "Geburtsdatum"});
            grid.Children.Add(tbGeburt);

            Button btn = new Button();
            btn.Content = "OK";
            grid.Children.Add(btn);

            // btn.Click += ok;
            btn.Click += new RoutedEventHandler(ok);


            Person = new Person()
            {
                Nachname = "Maier",
                Vorname = "Franz",
                Geburt = new DateTime(1990, 1, 1),
                Groesse = 180
            };

        }

        public Person Person
        {
            set
            {
                pers = value;
                tbName.Text = value.Nachname;
                tbGeburt.Text = value.Geburt.ToString("dd.MM.yyyy");
            }
            get
            {
                pers.Nachname = tbName.Text;
                pers.Geburt = DateTime.Parse(tbGeburt.Text);
                return pers;
            }
        }


        private void ok(object sender, RoutedEventArgs e)
        {
            MessageBox.Show(Person.ToString());
        }
    }
}
