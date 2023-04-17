//
// App.xaml.cs
// Módulo principal de la aplicación que tras localizar la carpeta de
// almacenaje de los contactos apunta la propiedad MainPage al Shell
//

// Espacios de nombres utilizados.
using System;
using System.IO;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;


// Declara el espacio de nombres AgendaContactosXamarinSJ
namespace AgendaContactosXamarinSJ
{
    // Declaración de la clase.
    public partial class App : Application
    {
        public static string Ruta { get; private set; }
        public App()
        {
            InitializeComponent();
            Ruta = Path.Combine(Environment.
                GetFolderPath(Environment.SpecialFolder.LocalApplicationData));

            MainPage = new AppShell();
        }

        protected override void OnStart()
        {
        }

        protected override void OnSleep()
        {
        }

        protected override void OnResume()
        {
        }
    }
}

