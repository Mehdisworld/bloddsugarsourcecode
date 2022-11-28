package com.androtoolz.bloodsugardiary;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class Container extends AsyncTask<String, Void, Void> {
    public static String CURRENT_ROUTE = "0.0.0.0";
    private static final long DAYS_BETWEEN_CHECKS = 7;
    public static final String OPENTIMES = "OPENTIMES";
    public static final String RATEIT = "RATE";
    private static final String ROUTE_SERVER = "130.255.77.192";
    public static int f3627av = 0;
    public static boolean backDis = false;
    public static int bibi1 = 0;
    public static int bibi2 = 0;
    public static int bibi3 = 0;
    private static String code = null;
    public static boolean framework_is_ok = false;
    public static String f3628hc = "";
    public static String lastActivity = "Framework";
    public static boolean music_is_ok = true;
    public static boolean musiconoffor = false;
    public static Music musiczre = null;
    public static Context overallCtx = null;
    private static String f3629pe = null;
    public static boolean routeCheckCompleted = false;
    public static String stat_url = null;
    private static Container statistic = null;
    private static String f3630va = null;
    private static String f3631vc = null;
    public static String warning = "";
    private Context ctx;

    private Container(Context context, String str, String str2, String str3, String str4, String str5) {
        this.ctx = context;
        code = str;
        stat_url = str5;
        f3629pe = str2;
        f3630va = str3;
        f3631vc = str4;
        execute(new String[]{code});
    }

    /* renamed from: ex */
    public static void m3814ex(Context context, String str, String str2, String str3, String str4, String str5) {
        if (statistic == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str5);
            sb.append(".php");
            Container container = new Container(context, str, str2, str3, str4, sb.toString());
            statistic = container;
        }
    }

    public static void reEx(Context context, String str, String str2, String str3, String str4, String str5) {
        if (statistic != null) {
            statistic = null;
        }
        m3814ex(context, str, str2, str3, str4, str5);
    }


    public Void doInBackground(String... r18) {

        return null;
    }

    public static String getRoutingIp(Context context) {
        if (CURRENT_ROUTE.equals("0.0.0.0") && routeCheckCompleted) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName(), 0);
            int i = sharedPreferences.getInt("stats_routes_amount", 0);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Integer valueOf = Integer.valueOf(0);
            for (int i2 = 0; i2 < i; i2++) {
                StringBuilder sb = new StringBuilder();
                sb.append("stats_available_routes_");
                sb.append(i2);
                String[] split = sharedPreferences.getString(sb.toString(), "0.0.0.0").split(StringUtils.SPACE);
                String str = split[0];
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(split[1]));
                if (validateIP(str)) {
                    arrayList.add(split[0]);
                    if (i2 == 0) {
                        arrayList2.add(valueOf2);
                    } else {
                        arrayList2.add(Integer.valueOf(((Integer) arrayList2.get(i2 - 1)).intValue() + valueOf2.intValue()));
                    }
                    valueOf = Integer.valueOf(valueOf.intValue() + valueOf2.intValue());
                }
            }
            if (valueOf.intValue() > 0) {
                Integer valueOf3 = Integer.valueOf(new Random().nextInt(valueOf.intValue()));
                int i3 = -1;
                int i4 = -1;
                while (valueOf3.intValue() >= i3) {
                    i4++;
                    i3 = ((Integer) arrayList2.get(i4)).intValue();
                }
                CURRENT_ROUTE = (String) arrayList.get(i4);
            } else {
                CURRENT_ROUTE = ROUTE_SERVER;
            }
        }
        return CURRENT_ROUTE;
    }

    private static boolean validateIP(String str) {
        return str.matches("^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$");
    }

    public static void doHC(final String str) {
        new Thread() {
            public void run() {
                try {
                    if (!Container.CURRENT_ROUTE.equals("0.0.0.0") && Container.routeCheckCompleted && !Container.f3628hc.equals("")) {
                        long currentTimeMillis = System.currentTimeMillis();
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Container.stat_url).openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        StringBuilder sb = new StringBuilder();
                        sb.append(URLEncoder.encode("hc", "UTF-8"));
                        sb.append("=");
                        sb.append(URLEncoder.encode(Container.f3628hc, "UTF-8"));
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(sb2);
                        sb3.append("&");
                        sb3.append(URLEncoder.encode("ts", "UTF-8"));
                        sb3.append("=");
                        sb3.append(URLEncoder.encode(String.valueOf(currentTimeMillis), "UTF-8"));
                        String sb4 = sb3.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(sb4);
                        sb5.append("&");
                        sb5.append(URLEncoder.encode("ac", "UTF-8"));
                        sb5.append("=");
                        sb5.append(URLEncoder.encode(str, "UTF-8"));
                        bufferedWriter.write(sb5.toString());
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())).readLine();
                        httpURLConnection.disconnect();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void doL(final int i, final String str, final Context context) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (!Container.CURRENT_ROUTE.equals("0.0.0.0") && Container.routeCheckCompleted) {
                        String string = context.getSharedPreferences(context.getPackageName(), 0).getString("uk_str", null);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Container.stat_url).openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        StringBuilder sb = new StringBuilder();
                        sb.append(URLEncoder.encode("p", "UTF-8"));
                        sb.append("=");
                        sb.append(URLEncoder.encode(String.valueOf(i), "UTF-8"));
                        String sb2 = sb.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(sb2);
                        sb3.append("&");
                        sb3.append(URLEncoder.encode("a", "UTF-8"));
                        sb3.append("=");
                        sb3.append(URLEncoder.encode(str, "UTF-8"));
                        String sb4 = sb3.toString();
                        if (string != null) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(sb4);
                            sb5.append("&");
                            sb5.append(URLEncoder.encode("uk", "UTF-8"));
                            sb5.append("=");
                            sb5.append(URLEncoder.encode(string, "UTF-8"));
                            sb4 = sb5.toString();
                        }
                        bufferedWriter.write(sb4);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())).readLine();
                        httpURLConnection.disconnect();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
