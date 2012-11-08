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
using Microsoft.Win32;

namespace Rechnungen
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private RechnungsVerwaltung rv = new RechnungsVerwaltung();

        public MainWindow()
        {
            InitializeComponent();
            DataContext = rv;
        }

        private void laden(object sender, RoutedEventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            if (ofd.ShowDialog() == true)
            {
                try
                {
                    rv.Clear();
                    rv.Add(DateiAnbindung.Laden(ofd.FileName));
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
            }


        }

        private void speichern(object sender, RoutedEventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            if (sfd.ShowDialog() == true)
            {
                try
                {
 
                    DateiAnbindung.Speichern(rv.AuswahlListe, sfd.FileName);
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
            }
        }

        private void auswahl(object sender, RoutedEventArgs e)
        {
            lbSumme.Content = rv.SummeAuswahl.ToString("#.00");
        }


    }
}
