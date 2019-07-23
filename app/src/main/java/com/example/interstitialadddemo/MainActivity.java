package com.example.interstitialadddemo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    //AdView mAdview;
    InterstitialAd interstitialAd;

    //private InterstitialAd interstitial;
    //Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  btn1=(Button)findViewById(R.id.btn1);
        //interstitial = new InterstitialAd(MainActivity.this);


       interstitialAd=new InterstitialAd(this);

       interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
       interstitialAd.loadAd(new  AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());

 interstitialAd.setAdListener(new AdListener()
 {
     @Override
     public void onAdClosed() {
         startActivity(new Intent(MainActivity.this,Main2Activity.class));
         interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
     }
 });

    }


    public void mainActivity2(View view) {

        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }
        else{
            startActivity( new Intent(this,Main2Activity.class));
        }
    }
}
