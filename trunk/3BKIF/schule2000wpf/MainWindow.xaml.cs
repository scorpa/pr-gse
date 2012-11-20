using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

using System.Data.Entity;

namespace schule2000wpf
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Schule2000Entities schule = new Schule2000Entities();

        public MainWindow()
        {
            InitializeComponent();

            schule.schueler.Load();

            DataContext = schule;
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            schule.SaveChanges();
        }
    }
}
