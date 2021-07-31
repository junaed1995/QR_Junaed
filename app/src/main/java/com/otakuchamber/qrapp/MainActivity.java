package com.otakuchamber.qrapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {

    EditText ed;
    Button genbutton,scanbutton;
    ImageView QR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QR=findViewById(R.id.QRdisplay);
        genbutton=findViewById(R.id.genbt);
        scanbutton=findViewById(R.id.scanbt);
        ed= findViewById(R.id.ed1);

        genbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = ed.getText().toString();
                if (data.isEmpty()) {
                        ed.setError("Please enter some value");
                } else {
                }
                QRGEncoder enc = new QRGEncoder(data, null, QRGContents.Type.TEXT, 500);
                Bitmap bm = enc.getBitmap();
                QR.setImageBitmap(bm);
            }



        });

            scanbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),scanner_activity.class));
                }
            });



    }
}
