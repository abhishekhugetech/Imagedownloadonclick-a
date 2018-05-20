package com.example.rohan.abhishek;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    //

    public void click(View view){
        Log.i("Image Changing","Image changing to Brodband Image");
        DownloadImage downloadImage = new DownloadImage();
        Bitmap myBitmap;
        try{
            myBitmap = downloadImage.execute("https://ovc2-ustokyyneikyfasnm.stackpathdns.com/assets/images/extract-url-icon.png").get();
            imageView.setImageBitmap(myBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paul(View view){
        Log.i("Image Changing","Image changing to Paul Wesely");
        DownloadImage downloadImage = new DownloadImage();
        Bitmap myBitmap;
        try{
            myBitmap = downloadImage.execute("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Paul_Wesley_by_Gage_Skidmore_2.jpg/170px-Paul_Wesley_by_Gage_Skidmore_2.jpg").get();
            imageView.setImageBitmap(myBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ian(View view){
        Log.i("Image Changing","Image changing to ian somerhalder");
        DownloadImage downloadImage = new DownloadImage();
        Bitmap myBitmap;
        try{
            myBitmap = downloadImage.execute("https://tv-fanatic-res.cloudinary.com/iu/s--i1jwm5Lt--/t_xlarge_p/cs_srgb,f_auto,fl_strip_profile.lossy,q_auto:420/v1522946316/ian-somerhalder-attends-elle-event.jpg").get();
            imageView.setImageBitmap(myBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stephen(View view){
        Log.i("Image Changing","Image changing to stephen amell");
        DownloadImage downloadImage = new DownloadImage();
        Bitmap myBitmap;
        try{
            myBitmap = downloadImage.execute("https://www.trainmag.com/wp-content/uploads/2018/01/Stephen-amell-post.jpg").get();
            imageView.setImageBitmap(myBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void flash(View view){
        Log.i("Image Changing","Image changing to Flash");
        DownloadImage downloadImage = new DownloadImage();
        Bitmap myBitmap;
        try{
            myBitmap = downloadImage.execute("http://media.comicbook.com/2016/03/fla218b-0150b-176673.jpg").get();
            imageView.setImageBitmap(myBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class DownloadImage extends AsyncTask<String,Void,Bitmap>{
        @Override
        protected Bitmap doInBackground(String... params){
            try{
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                return myBitmap;

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
}
