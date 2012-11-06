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

namespace Wetter
{
    /// <summary>
    /// Interaction logic for MainWindowWithBinding.xaml
    /// </summary>
    public partial class MainWindowWithBinding : Window
    {
        private WetterStation station;

        public MainWindowWithBinding()
        {
            InitializeComponent();
            station = new WetterStation();
            DataContext = station;
            cbWind.ItemsSource = Enum.GetValues(typeof(RICHTUNG));
            cbWetter.ItemsSource = Enum.GetValues(typeof(WETTER));
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

        private void datumAenderung(object sender, SelectionChangedEventArgs e)
        {
            lbEintraege.Items.Refresh();
        }
    }
}
