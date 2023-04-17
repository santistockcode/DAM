package com.santi.ficusing;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;

//Class to load the file into a reasonably sized Bitmap objeect.
public class PictureUtils {

    //Method to estimate PhotoView size. When fragment initially starts up, we don't know how big
    //PhotoView is
    public static Bitmap getScaledBitmap (String path, Activity activity){
        //Este metodo comprueba el tamaño de pantalla y reduce el de la imagen
        //hasta que ambos coinciden
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay()
                .getSize(size);
        Bitmap bitmap = getScaledBitmap(path,size.x,size.y);
        bitmap = rotateImage(bitmap, 90);
        return bitmap;
    }

    //Method to escalate images
    public static Bitmap getScaledBitmap(String path, int destWidth, int destHeight){
        //Leemos las dimensiones de la imagen en disco
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float scrWidth = options.outWidth;
        float srcHeight = options.outHeight;

        //Averiguamos cuanto reducir el tamaño
        int intSampleSize = 1;
        if(srcHeight>destHeight || scrWidth>destWidth){
            float heightScale = srcHeight / destHeight;
            float widthScale = scrWidth / destWidth;

            intSampleSize = Math.round(heightScale>widthScale?heightScale:
                    widthScale);
        }
        options = new BitmapFactory.Options();
        options.inSampleSize = intSampleSize;

        //Volvemos a leerlo y creamos el mapa de bits definitivo
        return BitmapFactory.decodeFile(path,options);
    }
    //Because most phone cameras are set for landscape photos
    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }
}