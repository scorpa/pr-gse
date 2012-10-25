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

using Linq;

namespace AnrufGui
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private AnrufStatistik stat = new AnrufStatistik();


        public MainWindow()
        {
            InitializeComponent();
            stat.AddAll(DateiAnbindung.einlesen(@"..\..\Anrufe1.csv"));
            stat.Sortierung = SORTIERUNG.ANZ_ASC;
            DataContext = stat;
        }

        private void button1_Click(object sender, RoutedEventArgs e)
        {
            stat.Sortierung = SORTIERUNG.ANZ_DESC;
            lbNummern.GetBindingExpression(ListBox.ItemsSourceProperty).UpdateTarget();
        }
    }
}
