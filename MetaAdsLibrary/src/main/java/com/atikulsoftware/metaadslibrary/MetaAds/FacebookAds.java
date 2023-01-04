package com.atikulsoftware.metaadslibrary.MetaAds;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

/*

Copyright @ Atikul Software
Name    : Md. Atikul Islam
GitHub  : https://github.com/AtikulSoftware
Website : https://www.bdtopcoder.xyz/
YouTube : https://www.youtube.com/AwesomeDesigner

*/

public class FacebookAds {

    public static onDismiss onDismiss;

    public FacebookAds(com.atikulsoftware.metaadslibrary.MetaAds.onDismiss onDismiss) {
        FacebookAds.onDismiss = onDismiss;
    }

    public FacebookAds() {

    }

    public static void setBanner(LinearLayout BannerLayout, Context context) {

        if (AdsUnit.isAds) {
            AdView adView = new AdView(context, AdsUnit.BANNER, AdSize.BANNER_HEIGHT_50);
            BannerLayout.addView(adView);

            AdListener adListener = new AdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {
                    // Ad error callback
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    // Ad loaded callback
                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Ad clicked callback
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    // Ad impression logged callback
                }
            };

            // Request an ad
            adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());

            // load ad
            adView.loadAd();

        } // Ads Checked End Here ===========
    } //SetBanner End Here ================

    public static void loadInterstitial(Context context) {
        if (AdsUnit.isAds) {
            // Initialize the Audience Network SDK
            AudienceNetworkAds.initialize(context);
            AdsUnit.interstitialAd = new InterstitialAd(context, AdsUnit.INTERSTITIAL);

            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    // Interstitial ad displayed callback

                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    // Interstitial dismissed callback
                    AdsUnit.interstitialAd = null;
                    FacebookAds.loadInterstitial(context);
                    onDismiss.OnDismiss();
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    // Ad error callback
                    // onDismiss.OnDismiss();

                }

                @Override
                public void onAdLoaded(Ad ad) {
                    // Interstitial ad is loaded and ready to be displayed

                }

                @Override
                public void onAdClicked(Ad ad) {
                    // Ad clicked callback
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    // Ad impression logged callback
                }
            };

            // For auto play video ads, it's recommended to load the ad
            // at least 30 seconds before it is shown
            AdsUnit.interstitialAd.loadAd(AdsUnit.interstitialAd.buildLoadAdConfig()
                    .withAdListener(interstitialAdListener)
                    .build());

        } // Ads Checked End Here ======

    } // loadInterstitial End Here =====

    public void showInterstitial() {
        if (AdsUnit.interstitialAd.isAdLoaded()) {
            // Show the ad
            AdsUnit.interstitialAd.show();
        } else {
            onDismiss.OnDismiss();
        }
    } // showInterstitial End Here ==========


} // FacebookAds End Here =================
