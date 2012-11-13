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

namespace Schule2000WPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private schule2000Entities context = new schule2000Entities();

        public MainWindow()
        {
            InitializeComponent();

            context.schueler.Load();
            DataContext = context;
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            context.SaveChanges();
        }
    }
}
