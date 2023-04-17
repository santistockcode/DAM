using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace JuegoMemoria_SAS
{
    public partial class MainPage : ContentPage
    {
        private int contador_linea2 = 0;
        private int contador_linea3 = 0;
        
        public MainPage()
        {
            InitializeComponent();
            Fimagen1.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.carta.png");
            Bimagen1.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.casa.png");

            Fimagen2_a.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.carta.png");
            Bimagen2_a.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.casa.png");
            Fimagen2_b.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.carta.png");
            Bimagen2_b.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.persona.png");

            Fimagen3_a.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.carta.png");
            Bimagen3_a.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.huella.png");
            Fimagen3_b.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.carta.png");
            Bimagen3_b.Source = ImageSource.FromResource("JuegoMemoria_SAS.imagenes.huella.png");
        }
        private async Task Flip(VisualElement from, VisualElement to)
        {
            await from.RotateYTo(-90, 300, Easing.SpringIn);
            to.RotationY = 90;
            to.IsVisible = true;
            from.IsVisible = false;
            await to.RotateYTo(0, 300, Easing.SpringOut);
        }

        private async Task Vibra(VisualElement par1, VisualElement par2)
        {
            uint timeout = 10;

            await par1.TranslateTo(-15, 0, timeout);
            await par2.TranslateTo(-15, 0, timeout);

            await par1.TranslateTo(15, 0, timeout);
            await par2.TranslateTo(15, 0, timeout);

            await par1.TranslateTo(-10, 0, timeout);
            await par2.TranslateTo(-10, 0, timeout);

            await par1.TranslateTo(10, 0, timeout);
            await par2.TranslateTo(10, 0, timeout);

            await par1.TranslateTo(-5, 0, timeout);
            await par2.TranslateTo(-5, 0, timeout);

            await par1.TranslateTo(5, 0, timeout);
            await par2.TranslateTo(5, 0, timeout);

            par1.TranslationX = 0;
            par2.TranslationX = 0;
        }

        private async Task Celebra(VisualElement par1, VisualElement par2)
        {
            await par1.RotateTo(360);
            await par1.FadeTo(0);
            await par2.RotateTo(360);
            await par2.FadeTo(0);
            par1.IsEnabled = false;
            par2.IsEnabled = false;
        }

        private async void Voltear(System.Object sender, System.EventArgs e)
        {
            var front = sender as Grid;
            var back = front.Parent.FindByName<Grid>("BackView_imagen1");
            await Flip(front, back);
        }
        private async void Vuelta(System.Object sender, System.EventArgs e)
        {
            var back = sender as Grid;
            var front = back.Parent.FindByName<Grid>("FrontView_imagen1");
            await Flip(back, front);
        }

       
        private async void Voltear2_a(System.Object sender, System.EventArgs e)
        {
            contador_linea2++;
            var front = sender as Grid;
            var back = front.Parent.FindByName<Grid>("BackView_imagen2_a");
            await Flip(front, back);

            var adicional = front.Parent.FindByName<Grid>("BackView_imagen2_b");
            if (Bimagen2_b.IsVisible && (contador_linea2%2==0)) { 
                await Vibra(back, adicional);
            }
        }
        private async void Vuelta2_a(System.Object sender, System.EventArgs e)
        {
            contador_linea2++;
            var back = sender as Grid;
            var front = back.Parent.FindByName<Grid>("FrontView_imagen2_a");
            await Flip(back, front);
        }
        private async void Voltear2_b(System.Object sender, System.EventArgs e)
        {
            contador_linea2++;
            var front = sender as Grid;
            var back = front.Parent.FindByName<Grid>("BackView_imagen2_b");
            await Flip(front, back);

            var adicional = front.Parent.FindByName<Grid>("BackView_imagen2_a");
            if (Bimagen2_a.IsVisible && (contador_linea2 % 2 == 0))
            {
                await Vibra(back, adicional);
            }
        }
        private async void Vuelta2_b(System.Object sender, System.EventArgs e)
        {
            contador_linea2++;
            var back = sender as Grid;
            var front = back.Parent.FindByName<Grid>("FrontView_imagen2_b");
            await Flip(back, front);
        }

        private async void Voltear3_a(System.Object sender, System.EventArgs e)
        {
            contador_linea3++;
            var front = sender as Grid;
            var back = front.Parent.FindByName<Grid>("BackView_imagen3_a");
            await Flip(front, back);
            var adicional = front.Parent.FindByName<Grid>("BackView_imagen3_b");
            if (Bimagen3_b.IsVisible && (contador_linea3 % 2 == 0))
            {
                await Celebra(back, adicional);
            }
        }
        private async void Vuelta3_a(System.Object sender, System.EventArgs e)
        {
            contador_linea3++;
            var back = sender as Grid;
            var front = back.Parent.FindByName<Grid>("FrontView_imagen3_a");
            await Flip(back, front);
        }
        private async void Voltear3_b(System.Object sender, System.EventArgs e)
        {
            contador_linea3++;
            var front = sender as Grid;
            var back = front.Parent.FindByName<Grid>("BackView_imagen3_b");
            await Flip(front, back);

            var adicional = front.Parent.FindByName<Grid>("BackView_imagen3_a");
            if (Bimagen3_a.IsVisible && (contador_linea3 % 2 == 0))
            {
                await Celebra(back, adicional);
            }
        }
        private async void Vuelta3_b(System.Object sender, System.EventArgs e)
        {
            contador_linea3++;
            var back = sender as Grid;
            var front = back.Parent.FindByName<Grid>("FrontView_imagen3_b");
            await Flip(back, front);
        }


    }
}

