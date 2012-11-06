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
using System.Xml.Serialization;
using Microsoft.Win32;

namespace Wetter
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private WetterStation station;
        private Eintrag selected;

        public MainWindow()
        {
            InitializeComponent();
            station = new WetterStation();
            station += new Eintrag();
            DataContext = station;
            lbEintraege.ItemsSource = station.Werte;
            lbEintraege.SelectedIndex = 0;
            cbWind.ItemsSource = Enum.GetValues(typeof(RICHTUNG));
            cbWetter.ItemsSource = Enum.GetValues(typeof(WETTER));

        }

        private void auswahl(object sender, SelectionChangedEventArgs e)
        {
            int index = lbEintraege.SelectedIndex;

            if (selected != null)
            {
                try
                {

                    // aktuelle Eingaben übernehmen
                    selected.Wetter = (WETTER)cbWetter.SelectedItem;
                    selected.Wind = (RICHTUNG)cbWind.SelectedItem;
                    selected.Temperatur = (int)slTemp.Value;
                    selected.Datum = (DateTime)dpDatum.SelectedDate;
                    lbEintraege.Items.Refresh();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("ungültige Werte wurden nicht übernommen");
 
                }
            }

            selected = (Eintrag)lbEintraege.SelectedItem;
            if (selected != null)
            {
                // Felder aus neuer Selektion belegen
                cbWind.SelectedItem = selected.Wind;
                cbWetter.SelectedItem = selected.Wetter;
                slTemp.Value = selected.Temperatur;
                dpDatum.SelectedDate = selected.Datum;
            }
        }

        private void neu(object sender, RoutedEventArgs e)
        {
            station += new Eintrag();
        }

        private void loeschen(object sender, RoutedEventArgs e)
        {
            Eintrag eintrag = (Eintrag)lbEintraege.SelectedItem;
            if (eintrag != null)
                station -= eintrag;
            else
                MessageBox.Show("bitte Eintrag auswählen");
        }

        private void speichern(object sender, RoutedEventArgs e)
        {
            SaveFileDialog saver = new SaveFileDialog();
            if (saver.ShowDialog() == true)
            {
                try
                {
                    DateiAnbindung.speichern(station, saver.FileName);
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
            }
                
        }

        private void laden(object sender, RoutedEventArgs e)
        {
            OpenFileDialog opener = new OpenFileDialog();
            if (opener.ShowDialog() == true)
            {
                try
                {
                    station = DateiAnbindung.laden(opener.FileName);
                    lbEintraege.ItemsSource = station.Werte;
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
            }

        }
    }
}
