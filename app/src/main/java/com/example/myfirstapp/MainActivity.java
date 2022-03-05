package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText url, url2, url3, url4, url5;
    private Button download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = (EditText)findViewById(R.id.url);
        url2 = (EditText)findViewById(R.id.url2);
        url3 = (EditText)findViewById(R.id.url3);
        url4 = (EditText)findViewById(R.id.url4);
        url5 = (EditText)findViewById(R.id.url5);
        download = (Button) findViewById(R.id.download);

        download.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String getUrl = url.getText().toString();
                String getUrl2 = url2.getText().toString();
                String getUrl3 = url3.getText().toString();
                String getUrl4 = url4.getText().toString();
                String getUrl5 = url5.getText().toString();

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(getUrl));
                DownloadManager.Request request2 = new DownloadManager.Request(Uri.parse(getUrl2));
                DownloadManager.Request request3 = new DownloadManager.Request(Uri.parse(getUrl3));
                DownloadManager.Request request4 = new DownloadManager.Request(Uri.parse(getUrl4));
                DownloadManager.Request request5 = new DownloadManager.Request(Uri.parse(getUrl5));
                String title = URLUtil.guessFileName(getUrl, null, null);
                String title2 = URLUtil.guessFileName(getUrl2, null, null);
                String title3 = URLUtil.guessFileName(getUrl3, null, null);
                String title4 = URLUtil.guessFileName(getUrl4, null, null);
                String title5 = URLUtil.guessFileName(getUrl5, null, null);
                request.setTitle(title);
                request.setDescription("Downloading File please wait....");
                request2.setTitle(title2);
                request2.setDescription("Downloading File please wait....");
                request3.setTitle(title3);
                request3.setDescription("Downloading File please wait....");
                request4.setTitle(title4);
                request4.setDescription("Downloading File please wait....");
                request5.setTitle(title5);
                request5.setDescription("Downloading File please wait....");
//                String cookies = CookieManager.getInstance().getCookie(getUrl);
//                request.addRequestHeader(header: "cookies", cookies);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+ System.currentTimeMillis());
                request2.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request2.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+ System.currentTimeMillis());
                request3.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request3.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+ System.currentTimeMillis());
                request4.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request4.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+ System.currentTimeMillis());
                request5.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request5.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+ System.currentTimeMillis());

                DownloadManager downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                downloadManager.enqueue(request);
                downloadManager.enqueue(request2);
                downloadManager.enqueue(request3);
                downloadManager.enqueue(request4);
                downloadManager.enqueue(request5);

//                Toast.makeText(context: MainActivity.this, text: "Dowload Started.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}