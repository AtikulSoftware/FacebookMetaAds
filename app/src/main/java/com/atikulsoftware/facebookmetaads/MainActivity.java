package com.atikulsoftware.facebookmetaads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.atikulsoftware.metaadslibrary.MetaAds.AdsUnit;
import com.atikulsoftware.metaadslibrary.MetaAds.FacebookAds;
import com.atikulsoftware.metaadslibrary.MetaAds.onDismiss;

public class MainActivity extends AppCompatActivity {

    LinearLayout banner_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdsUnit.BANNER = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID";
        AdsUnit.INTERSTITIAL = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID";
        FacebookAds.loadInterstitial(MainActivity.this);

        FacebookAds.setBanner(findViewById(R.id.banner_container), MainActivity.this);

        Button showInterstitial = findViewById(R.id.showInterstitial);
        showInterstitial.setOnClickListener(v -> {
            // Code here
            new FacebookAds(() -> {
                // Next Action
                Toast.makeText(MainActivity.this, "Ads Closed", Toast.LENGTH_SHORT).show();
            }).showInterstitial();
        });


    } // OnCreate Method End Here ====


} // Public Class End Here ===========