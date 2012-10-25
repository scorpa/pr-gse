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

namespace Anrufe
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private AnrufStatistik statistik = new AnrufStatistik();

        public MainWindow()
        {
            InitializeComponent();
            DataContext = statistik;
        }

        private void neuerAnruf(object sender, RoutedEventArgs e)
        {
            statistik.Add(new Anruf() { Nummer = "9876654443" });
            listBox1.GetBindingExpression(ListBox.ItemsSourceProperty).UpdateTarget();
            //listBox1.Items.Refresh();

          

        }

        private void select(object sender, SelectionChangedEventArgs e)
        {
            AnrufInfo i = (AnrufInfo)listBox1.SelectedItem;
            MessageBox.Show(i.ToString());
        }
    }
}
