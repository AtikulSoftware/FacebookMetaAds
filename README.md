# FacebookMetaAds
FacebookMetaAds Library
> How to Use Facebook / Meta Audience Network Ads Implantation 2023 || Facebook Banner And Interstitial Ads </br>
Video - https://youtu.be/MvUHSKD4c_Q


> Step 1. Add the JitPack repository to your build file

```Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  > Step 2. Add the dependency
  ```
  dependencies {
	        implementation 'com.github.AtikulSoftware:FacebookMetaAds:1.0.0'
	}
  ```
  > Important : If show any Worning you have to add this line in gradle.properties
  ```
  android.enableJetifier=true
  ```
  
  > Step 3. Banner Ads Layout
  ```
   <LinearLayout
        android:layout_marginTop="10dp"
        android:id="@+id/banner_container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:orientation="vertical"
        />
  ```
  
  > Step 4. Set Placement ID
  ```
  AdsUnit.BANNER = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID";
  AdsUnit.INTERSTITIAL = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID";
  ```
  
  > Step 5. Initialize the Audience Network SDK
  ```
    FacebookAds.loadInterstitial(MainActivity.this);
  ```
  > Step 6. Load Banner Ads
  ```
  FacebookAds.setBanner(findViewById(R.id.banner_container), MainActivity.this);
  ```
  > Step 7. Show Interstitial Ads Button Clicked
  ```
    Button showInterstitial = findViewById(R.id.showInterstitial);
        showInterstitial.setOnClickListener(v -> {
            // Code here
            new FacebookAds(() -> {
                // Next Action
                Toast.makeText(MainActivity.this, "Ads Closed", Toast.LENGTH_SHORT).show();
            }).showInterstitial();
        });
  ```
  
  > Step 8. Show Interstitial Ads
  ```
   // Code here
            new FacebookAds(() -> {
                // Next Action
                Toast.makeText(MainActivity.this, "Ads Closed", Toast.LENGTH_SHORT).show();
            }).showInterstitial();
  ```
  
  
