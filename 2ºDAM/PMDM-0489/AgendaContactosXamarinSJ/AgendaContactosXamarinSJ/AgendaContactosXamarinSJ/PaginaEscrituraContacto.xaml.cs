//
// PaginaEscrituraContacto.xaml.cs
// Código c# bajo la Content Page de XAML PaginaEscrituraContacto.
// PaginaEscrituraContacto es la página en la que se visualizan, editan y
// crean los contactos. 
//

// Espacios de nombres utilizados.
using System;
using System.IO;
using Xamarin.Forms;
using AgendaContactosXamarinSJ.Modelos;

// Declara el espacio de nombres AgendaContactosXamarinSJ
namespace AgendaContactosXamarinSJ
{
    // Declaración de la clase partial (por la generación automática de fuente)
    public partial class PaginaEcrituraContacto : ContentPage
    {
        //Inicializa la página
        public PaginaEcrituraContacto()
        {
            InitializeComponent();
        }
        //Manejador del evento "guardar" el contacto
        async void OnSaveButtonClicked(object sender, EventArgs e)
        {
            //Establece el BindingContext entre el modelo y la variable contacto
            var contacto = (Contacto)BindingContext;
            //valida que se hayan rellenado los tres campos
            bool adelante = (!String.IsNullOrWhiteSpace(contacto.Nombre)
                && !String.IsNullOrWhiteSpace(contacto.Telefono)
                && !String.IsNullOrWhiteSpace(contacto.E_mail));
           
            //guarda el nuevo contacto en un archivo con la extension .contactos.txt
            if (string.IsNullOrWhiteSpace(contacto.Archivo) && adelante)
            {
                //en un nuevo archivo
                var filename = Path.Combine(App.Ruta,
                    $"{Path.GetRandomFileName()}.contactos.txt");
                File.WriteAllText(filename, contacto.Nombre);
                File.AppendAllText(filename, "\n" + contacto.Telefono);
                File.AppendAllText(filename, "\n" + contacto.E_mail);
                await Navigation.PopAsync();
            }
            else if(adelante)
            {
                //modifica el archivo ya existente
                File.WriteAllText(contacto.Archivo, contacto.Nombre);
                File.AppendAllText(contacto.Archivo, "\n" + contacto.Telefono);
                File.AppendAllText(contacto.Archivo, "\n" + contacto.E_mail);
                await Navigation.PopAsync();
            }
            //si no ha rellenado algún campo no realiza ninguna acción
            else
            {

            }  
        }

        //Manejador del evento "eliminar" el contacto
        async void OnDeleteButtonClicked(object sender, EventArgs e)
        {
            var contacto = (Contacto)BindingContext;

            if (File.Exists(contacto.Archivo))
            {
                File.Delete(contacto.Archivo);
            }
            await Navigation.PopAsync();
        }
        //Manejador del ImageButton para hacer una llamada al numero del contacto
        private void ButtonCallClicked(object sender, EventArgs e)
        {
            var contacto = (Contacto)BindingContext;

            string phoneNumber = contacto.Telefono;

            if (string.IsNullOrEmpty(phoneNumber))
            {
                return;
            }
            Uri uri = (new Uri(string.Format("tel:{0}", phoneNumber)));

            Xamarin.Essentials.Launcher.OpenAsync(uri);
        }
        //Manejador del Imagebutton para enviar un e-mail vacío al email del contacto
        private void ButtonMailClicked(object sender, EventArgs e)
        {
            var contacto = (Contacto)BindingContext;

            string toEmail = contacto.E_mail;
            string emailSubject = "";
            string emailBody = "";

            if (string.IsNullOrEmpty(toEmail))
            {
                return;
            }
            Xamarin.Essentials.Launcher.OpenAsync(new Uri(String.Format("mailto:{0}?subject={1}&body={2}", toEmail, emailSubject, emailBody)));
        }
    }
}
