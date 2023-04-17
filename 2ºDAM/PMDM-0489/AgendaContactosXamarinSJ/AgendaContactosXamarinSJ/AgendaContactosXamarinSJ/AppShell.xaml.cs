//
// AppShell.xaml.cs
// Código asociado a la página AppShell subclase de Shell, template de
// Xamarin Forms que facilita la navegación
//

// Espacios de nombres utilizados.
using System;
using System.Collections.Generic;
using AgendaContactosXamarinSJ.Modelos;
using AgendaContactosXamarinSJ;
using Xamarin.Forms;

// Declara el espacio de nombres AgendaContactosXamarinSJ
namespace AgendaContactosXamarinSJ
{
    // Declaración de la clase.
    public partial class AppShell : Xamarin.Forms.Shell
    {
        public AppShell()
        {
            InitializeComponent();
            /*
            Routing.RegisterRoute(nameof(PaginaContactos), typeof(PaginaEcrituraContacto));
            Routing.RegisterRoute(nameof(PaginaEscrituraContacto), typeof(PaginaEscrituraContacto));
            */
            
        }

    }
}

