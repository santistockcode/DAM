//
// PaginaContactos.xaml.cs
// Código c# bajo la Content Page de XAML PaginaContactos
// PaginaContactos muestra los contactos almacenados y da la opción de
// desplegarlos en una nueva página detalle. 
//

// Espacios de nombres utilizados.
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using Xamarin.Forms;
using AgendaContactosXamarinSJ.Modelos;

// Declara el espacio de nombres AgendaContactosXamarinSJ
namespace AgendaContactosXamarinSJ
{
    // Declaración de la clase parcial PaginaContactos
    public partial class PaginaContactos : ContentPage
    {
        //Inicializa el componente
        public PaginaContactos()
        {
            InitializeComponent();
        }

        //Método vinculado al añadido de este código a la página visual
        protected override void OnAppearing()
        {
            //La llamada al OnAppearing en sí
            base.OnAppearing();
            //crea una lista de contactos llamada "contactos"
            var contactos = new List<Contacto>();
            //Toma la ruta principal de la aplicación y busca todos los archivos
            //con la extensión .contactos.txt para guardarlos en "archivos"
            var archivos = Directory.EnumerateFiles(App.Ruta, "*.contactos.txt");
            foreach (var archivo in archivos)
            {
                //Distribuye los archivos en el IEnumerable lines (ya son strings)
                IEnumerable<string> lines = File.ReadLines(archivo);
            }
            //Construye los objetos Contacto
            foreach (var archivo in archivos)
            {
                string[] lines = File.ReadAllLines(archivo);
                contactos.Add(new Contacto
                {
                    Archivo = archivo,
                    Nombre = lines[0],
                    Telefono = lines[1],
                    E_mail = lines[2]
                });
            }

            listView.ItemsSource = contactos
                .OrderBy(d => d.Nombre)
                .ToList();
        }
        //Manejador del evento "añadir nota"
        async void OnNoteAddedClicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new PaginaEcrituraContacto
            {
                BindingContext = new Contacto()
            });
        }
        //Manejador del evento "generar la lista con los items Contacto
        async void OnListViewItemSelected(object sender, SelectedItemChangedEventArgs e)
        {
            if (e.SelectedItem != null)
            {
                //Navegación hacia la página detalle del item seleccionado
                await Navigation.PushAsync(new PaginaEcrituraContacto
                {
                    BindingContext = e.SelectedItem as Contacto
                });
            }
        }
    }
}