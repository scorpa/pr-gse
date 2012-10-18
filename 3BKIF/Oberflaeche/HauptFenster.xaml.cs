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
using Microsoft.Win32;
using System.IO;
using Dateianbindung;

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
        }

        private void bOK_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("button angeklickt");
        }

        private void textBox1_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void textBox1_MouseEnter(object sender, MouseEventArgs e)
        {

        }

        private void MenuItem_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog open = new OpenFileDialog();
            if (open.ShowDialog() == true)
            {
                FileInfo file = new FileInfo(open.FileName);
                List<Person> liste = DateiAnbindung.einlesen(file);
                personenListe.ItemsSource = liste;
            }
        }

        private void auswahl(object sender, SelectionChangedEventArgs e)
        {
            string nummer = (string)personenListe.SelectedItem;

            textBox1.Text = ....
        }

 
    }
}
