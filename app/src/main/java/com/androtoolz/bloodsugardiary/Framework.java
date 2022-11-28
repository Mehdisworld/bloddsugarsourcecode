package com.androtoolz.bloodsugardiary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import Ads.AdmobAds;
import androidx.appcompat.app.AppCompatActivity;
/*
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback; */

import org.apache.commons.lang3.StringUtils;


public class Framework extends AppCompatActivity {

    Button btn_share;
    Button btn_start, btnRateus, btnPolicy;

    RelativeLayout adLayout;
    AdmobAds admobAds;



    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_framework);


        adLayout = findViewById(R.id.adLayout);
        admobAds = new AdmobAds(this);
        admobAds.loadInter();
        if (MyApp.NetworkAds.equalsIgnoreCase("admob")) {
            admobAds.showBanner(adLayout);

        }
        Container.overallCtx = this;
        init();
    }



    private void init() {
        if (!Container.framework_is_ok) {
            Container.framework_is_ok = true;
            try {
                Container.musiczre = new Music(R.raw.zre_music, this);
            } catch (Exception unused) {
            }
        }

        this.btn_start = (Button) findViewById(R.id.btn_start);
        this.btn_share = (Button) findViewById(R.id.btn_share);
        btnRateus = (Button) findViewById(R.id.btnRateus);
        btnPolicy = (Button) findViewById(R.id.btnPolicy);

        setButtonActions();

    }


    private void setButtonActions() {


        this.btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admobAds.showInter(new AdmobAds.AdFinished() {
                    @Override
                    public void onAdFinished() {

                        Container.bibi1 = 0;
                        Container.bibi2 = 0;
                        Container.bibi3 = 0;
                        Intent intent = new Intent(getApplicationContext(), LogDiaryActivity.class);
                        startActivity(intent);

                    }
                });

            }
        });

        this.btn_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        StringBuilder sb = new StringBuilder();
                        sb.append(Framework.this.getString(R.string.share_text));
                        sb.append(StringUtils.SPACE);
                        sb.append(Framework.this.generateStoreURL(Framework.this.getPackageName()));
                        intent.putExtra("android.intent.extra.TEXT", sb.toString());
                        intent.setType("text/plain");
                        Framework.this.startActivity(intent);

            }

        });

        btnRateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateUs();
            }
        });

        btnPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String url = "https://www.google.com/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                } catch (Exception e) {

                }
            }
        });

    }


    public String generateStoreURL(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://play.google.com/store/apps/details?id=");
        sb.append(str);
        return sb.toString();
    }

    public void rateUs() {

        final String appPackageName = getPackageName();
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + appPackageName)));
        } catch (ActivityNotFoundException anfe) {
            startActivity(new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id="
                            + appPackageName)));
        }
    }


}
