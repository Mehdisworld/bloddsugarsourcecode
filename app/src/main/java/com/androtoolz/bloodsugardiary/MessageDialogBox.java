package com.androtoolz.bloodsugardiary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MessageDialogBox extends Dialog implements OnClickListener {
    public static boolean choosen = false;
    private Button btn_no;
    private Button btn_no1;
    private Button btn_send;
    private Button btn_send1;
    private LinearLayout buttons_star1;
    private LinearLayout buttons_star5;
    private Context f3633c;
    private int chosen_stars;
    private EditText edit;
    private TextView info1;
    private String msg;
    private View seperator;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;

    private class PostReview extends AsyncTask<Void, Void, Void> {
        int app_id;
        int chosen_stars;
        String msg;

        public PostReview(int i, int i2, String str) {
            this.app_id = i;
            this.chosen_stars = i2;
            this.msg = str;
        }

        public Void doInBackground(Void... voidArr) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://130.255.77.192/u/scripts/send_review.php").openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                StringBuilder sb = new StringBuilder();
                sb.append(URLEncoder.encode("app_id", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(String.valueOf(this.app_id), "UTF-8"));
                sb.append("&");
                sb.append(URLEncoder.encode("chosen_stars", "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(String.valueOf(this.chosen_stars), "UTF-8"));
                String sb2 = sb.toString();
                if (this.msg != null && !this.msg.trim().equals("")) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sb2);
                    sb3.append("&");
                    sb3.append(URLEncoder.encode("msg", "UTF-8"));
                    sb3.append("=");
                    sb3.append(URLEncoder.encode(this.msg, "UTF-8"));
                    sb2 = sb3.toString();
                }
                bufferedWriter.write(sb2);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                StringBuilder sb4 = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read < 0) {
                        break;
                    }
                    sb4.append((char) read);
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                String sb5 = sb4.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("message: ");
                sb6.append(sb5);
                Log.d("STRING", sb6.toString());
            } catch (IOException unused) {
            }
            return null;
        }
    }

    public MessageDialogBox(Activity activity, Context context) {
        super(activity);
        this.f3633c = context;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.rate);
        this.star1 = (ImageView) findViewById(R.id.star1);
        this.star2 = (ImageView) findViewById(R.id.star2);
        this.star3 = (ImageView) findViewById(R.id.star3);
        this.star4 = (ImageView) findViewById(R.id.star4);
        this.star5 = (ImageView) findViewById(R.id.star5);
        this.edit = (EditText) findViewById(R.id.edittext);
        this.info1 = (TextView) findViewById(R.id.info1);
        this.seperator = findViewById(R.id.seperator);
        this.btn_send = (Button) findViewById(R.id.btn_send_msg);
        this.btn_no = (Button) findViewById(R.id.btn_no_send_msg);
        this.btn_send1 = (Button) findViewById(R.id.btn_send_msg1);
        this.btn_no1 = (Button) findViewById(R.id.btn_no_send_msg1);
        this.buttons_star1 = (LinearLayout) findViewById(R.id.buttons_star1);
        this.buttons_star5 = (LinearLayout) findViewById(R.id.buttons_star5);
        this.star1.setOnClickListener(this);
        this.star2.setOnClickListener(this);
        this.star3.setOnClickListener(this);
        this.star4.setOnClickListener(this);
        this.star5.setOnClickListener(this);
        this.btn_send.setOnClickListener(this);
        this.btn_no.setOnClickListener(this);
        this.btn_send1.setOnClickListener(this);
        this.btn_no1.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_no_send_msg /*2131230768*/:
                dismiss();
                return;
            case R.id.btn_no_send_msg1 /*2131230769*/:
                dismiss();
                return;
            case R.id.btn_send_msg /*2131230770*/:
                this.msg = this.edit.getText().toString().trim();
                postReview(195, this.chosen_stars, this.msg);
                dismiss();
                return;
            case R.id.btn_send_msg1 /*2131230771*/:
                try {
                    this.msg = "";
                    postReview(195, this.chosen_stars, this.msg);
                    StringBuilder sb = new StringBuilder();
                    sb.append("market://details?id=");
                    sb.append(this.f3633c.getPackageName());
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
                    if (intent.resolveActivity(this.f3633c.getPackageManager()) != null) {
                        this.f3633c.startActivity(intent);
                    }
                } catch (Exception unused) {
                }
                dismiss();
                return;
            default:
                switch (id) {
                    case R.id.star1 /*2131230982*/:
                        if (!choosen) {
                            greyStars();
                            this.buttons_star5.setVisibility(View.GONE);
                            this.star1.setImageResource(R.drawable.s_yel);
                            this.seperator.setVisibility(View.VISIBLE);
                            this.info1.setVisibility(View.VISIBLE);
                            this.edit.setVisibility(View.VISIBLE);
                            this.buttons_star1.setVisibility(View.VISIBLE);
                            choosen = true;
                            this.chosen_stars = 1;
                            return;
                        }
                        return;
                    case R.id.star2 /*2131230983*/:
                        if (!choosen) {
                            greyStars();
                            this.buttons_star5.setVisibility(View.GONE);
                            this.star1.setImageResource(R.drawable.s_yel);
                            this.star2.setImageResource(R.drawable.s_yel);
                            this.seperator.setVisibility(View.VISIBLE);
                            this.info1.setVisibility(View.VISIBLE);
                            this.edit.setVisibility(View.VISIBLE);
                            this.buttons_star1.setVisibility(View.VISIBLE);
                            choosen = true;
                            this.chosen_stars = 2;
                            return;
                        }
                        return;
                    case R.id.star3 /*2131230984*/:
                        if (!choosen) {
                            greyStars();
                            this.buttons_star1.setVisibility(View.GONE);
                            this.edit.setVisibility(View.GONE);
                            this.star1.setImageResource(R.drawable.s_yel);
                            this.star2.setImageResource(R.drawable.s_yel);
                            this.star3.setImageResource(R.drawable.s_yel);
                            this.seperator.setVisibility(View.VISIBLE);
                            this.info1.setVisibility(View.VISIBLE);
                            this.buttons_star5.setVisibility(View.VISIBLE);
                            choosen = true;
                            this.chosen_stars = 3;
                            return;
                        }
                        return;
                    case R.id.star4 /*2131230985*/:
                        if (!choosen) {
                            greyStars();
                            this.buttons_star1.setVisibility(View.GONE);
                            this.edit.setVisibility(View.GONE);
                            this.star1.setImageResource(R.drawable.s_yel);
                            this.star2.setImageResource(R.drawable.s_yel);
                            this.star3.setImageResource(R.drawable.s_yel);
                            this.star4.setImageResource(R.drawable.s_yel);
                            this.seperator.setVisibility(View.VISIBLE);
                            this.info1.setVisibility(View.VISIBLE);
                            this.buttons_star5.setVisibility(View.VISIBLE);
                            choosen = true;
                            this.chosen_stars = 4;
                            return;
                        }
                        return;
                    case R.id.star5 /*2131230986*/:
                        if (!choosen) {
                            greyStars();
                            this.buttons_star1.setVisibility(View.GONE);
                            this.edit.setVisibility(View.GONE);
                            this.star1.setImageResource(R.drawable.s_yel);
                            this.star2.setImageResource(R.drawable.s_yel);
                            this.star3.setImageResource(R.drawable.s_yel);
                            this.star4.setImageResource(R.drawable.s_yel);
                            this.star5.setImageResource(R.drawable.s_yel);
                            this.seperator.setVisibility(View.VISIBLE);
                            this.info1.setVisibility(View.VISIBLE);
                            this.buttons_star5.setVisibility(View.VISIBLE);
                            choosen = true;
                            this.chosen_stars = 5;
                            return;
                        }
                        return;
                    default:
                        return;
                }
        }
    }

    public void greyStars() {
        this.star1.setImageResource(R.drawable.s_gra);
        this.star2.setImageResource(R.drawable.s_gra);
        this.star3.setImageResource(R.drawable.s_gra);
        this.star4.setImageResource(R.drawable.s_gra);
        this.star5.setImageResource(R.drawable.s_gra);
    }

    private void postReview(int i, int i2, String str) {
        new PostReview(i, i2, str).execute(new Void[0]);
    }
}
