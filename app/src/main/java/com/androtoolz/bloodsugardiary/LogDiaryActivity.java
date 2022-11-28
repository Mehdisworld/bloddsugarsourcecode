package com.androtoolz.bloodsugardiary;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Vibrator;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.provider.CalendarContract.Reminders;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
import com.shawnlin.numberpicker.NumberPicker;
import com.shawnlin.numberpicker.NumberPicker.OnValueChangeListener;
//import android.widget.NumberPicker;
//import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer.GridStyle;
import com.jjoe64.graphview.LegendRenderer.LegendAlign;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;
import com.opencsv.CSVWriter;

import Ads.AdmobAds;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

public class LogDiaryActivity extends AppCompatActivity {
    private static final int REQUEST_WRITE_STORAGE = 112;
    private static final int REQUEST_WRITE_STORAGE_CAL = 114;

    public static int dkewjfwe = 0;
    public static SQLiteDatabase dqdqwfwdecs = null;
    public static boolean dwehdwe = false;
    private static HashSet<String> entryList = new HashSet<>();
    public static boolean firstTryEn = true;
    public static int huifwehufwe = 1;
    public static int ijofwjiefojwie = 0;
    public static int joiweiofwei = 0;
    private static Context kmwefwe;
    public static int kopdqwokpeq = 0;
    public static final Handler qweffsasda = new Handler();
    private static HashMap<String, HashSet<String>> searchmap = new HashMap<>();
    private static ArrayList<String> taglist;
    private static DManage wfeifwefw;
    public static boolean wqeweqw = false;
    private boolean bjweudw = false;
    public int btda;
    private Button btdatpi;
    public int btho;
    public int btmi;
    public int btmon;
    private Button bttipi;
    public int btyea;
    public RelativeLayout dbquwdbuqw;
    public RelativeLayout dbquwdbuqww;
    public GraphView dhiwehfwef;
    public GraphView dhiwehfwefa;
    public GraphView dhiwehfwefb;
    public GraphView dhiwehfwefc;

    public SimpleDateFormat dqweqdcsd = new SimpleDateFormat("yyy/MM/dd");

    public SimpleDateFormat dwedwedw = new SimpleDateFormat("d.");

    public SimpleDateFormat fggftrw = new SimpleDateFormat("h aa");
    private Context fhiwehufwe;

    public ImageView fijweofjer;

    public ImageView fmkwmfer;

    public SimpleDateFormat fwerfew = new SimpleDateFormat("M.");

    public int fwerfwe;
    private SimpleDateFormat fwheufheuw;
    private long hifowehiovjopdqp;
    private long hufwehufwehu;
    private Typeface ijweiofev;
    private RelativeLayout infosv;
    private RelativeLayout jfiwefew;
    private RelativeLayout jgirtgjrit;
    private ArrayList<String[]> jidqwidjqwhidw;
    private float jifejiorferi = Float.NEGATIVE_INFINITY;
    private RelativeLayout jnqq;

    public Vibrator jofweofer;
    private int kncknddsk = 0;

    public Context mlvdfmvd;

    public boolean notFunction;

    public int np1 = 0;

    public int np2 = 0;
    public int np3 = 0;
    private RelativeLayout oldaa;
    private boolean onceT = false;

    AdmobAds admobAds;



    private OnTouchListener printListener = new OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1) {
                LogDiaryActivity.qweffsasda.removeCallbacks(LogDiaryActivity.this.runnableLight);
                LogDiaryActivity.this.fijweofjer.setImageResource(R.drawable.oldinfoa);
                LogDiaryActivity.this.fmkwmfer.setVisibility(View.INVISIBLE);
                LogDiaryActivity.this.fmkwmfer.setY((float) LogDiaryActivity.kopdqwokpeq);
                try {
                    if (Container.musiczre == null) {
                        Container.musiczre = new Music(R.raw.zre_music, LogDiaryActivity.this.mlvdfmvd);
                    }
                    if (!Container.musiconoffor) {
                        Container.musiczre.stopPlaying();
                    }
                } catch (Exception unused) {
                }
            } else if (motionEvent.getAction() == 0) {
                LogDiaryActivity.this.fijweofjer.setImageResource(R.drawable.oldinfob);
                LogDiaryActivity.this.fmkwmfer.setVisibility(View.VISIBLE);
                LogDiaryActivity.joiweiofwei = LogDiaryActivity.this.fmkwmfer.getTop();
                LogDiaryActivity.ijofwjiefojwie = LogDiaryActivity.this.fijweofjer.getBottom() - LogDiaryActivity.this.fmkwmfer.getHeight();
                if (!LogDiaryActivity.dwehdwe) {
                    LogDiaryActivity.dkewjfwe = LogDiaryActivity.ijofwjiefojwie;
                    LogDiaryActivity.dwehdwe = true;
                    LogDiaryActivity.kopdqwokpeq = LogDiaryActivity.joiweiofwei;
                }
                LogDiaryActivity.qweffsasda.postDelayed(LogDiaryActivity.this.runnableLight, 1);
                try {
                    if (Container.musiczre == null) {
                        Container.musiczre = new Music(R.raw.zre_music, LogDiaryActivity.this.mlvdfmvd);
                    }
                    if (!Container.musiconoffor) {
                        Container.musiczre.playNote();
                    }
                } catch (Exception unused2) {
                }
                /*w7shal
                if (!Container.musiconoffor) {

                    LogDiaryActivity.this.jofweofer.vibrate(100);
                }*/
            }
            return true;
        }
    };
    public boolean reloadStat;
    public boolean[] reloadStata = new boolean[4];
    public final Runnable runnableLight = new Runnable() {
        public void run() {
            LogDiaryActivity.access$3208();
            if (LogDiaryActivity.joiweiofwei >= LogDiaryActivity.dkewjfwe) {
                try {
                    if (Container.musiczre == null) {
                        Container.musiczre = new Music(R.raw.zre_music, LogDiaryActivity.this.mlvdfmvd);
                    }
                    if (!Container.musiconoffor) {
                        Container.musiczre.stopPlaying();
                    }
                } catch (Exception unused) {
                }
                if (Container.music_is_ok) {
                    Container.bibi1 = ((int) (Math.round(Math.random() * 1000.0d) / 100)) + 66;
                    ((TextView) findViewById(R.id.sys)).setText(Container.bibi3 + "");


                    Container.bibi2 = ((int) (Math.round(Math.random() * 1000.0d) / 100)) + 73;

                    ((TextView) findViewById(R.id.dia)).setText(Container.bibi2 + "");


                    Container.bibi3 = ((int) (Math.round(Math.random() * 1000.0d) / 100)) + 122;

                    ((TextView) findViewById(R.id.pul)).setText(Container.bibi1 + "");

                }
                LogDiaryActivity.wqeweqw = true;
                Toast.makeText(LogDiaryActivity.this.getApplicationContext(), LogDiaryActivity.this.getResources().getString(R.string.infonobn), Toast.LENGTH_SHORT).show();
               /* Intent intent = LogDiaryActivity.this.getIntent();
                LogDiaryActivity.this.finish();
                LogDiaryActivity.this.startActivity(intent);*/
                return;
            }
            LogDiaryActivity.this.fmkwmfer.setY((float) LogDiaryActivity.joiweiofwei);
            LogDiaryActivity.qweffsasda.postDelayed(this, 20);
        }
    };
    private boolean searchOne;
    private RelativeLayout statsv;
    private TabLayout tabla;
    private TabLayout tablaa;
    private TabLayout tablaaa;

    public TextView tdatt;

    public TextView ttimm;
    private float vehuvehu = Float.POSITIVE_INFINITY;
    private int voerfgjoerj;


    private float[] f3632xy;

    static int access$3208() {
        int i = joiweiofwei;
        joiweiofwei = i + 1;
        return i;
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.activity_log_diary);

        Container.overallCtx = this;

        //ManageAds.loadBanner(this, (LinearLayout) findViewById(R.id.banner_container));


        this.notFunction = false;
        this.searchOne = false;
        this.reloadStat = true;
        this.reloadStata[0] = true;
        this.reloadStata[1] = true;
        this.reloadStata[2] = true;
        this.reloadStata[3] = true;
        this.mlvdfmvd = this;
        this.fhiwehufwe = this;
        kmwefwe = this;
        this.fwheufheuw = new SimpleDateFormat("dd/MM/yyy hh:mm:ss aa");
        this.f3632xy = new float[2];
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), 0);
        int[] iArr = {sharedPreferences.getInt("sysvabx", 120), sharedPreferences.getInt("diavabx", 80), sharedPreferences.getInt("pulvabx", 70)};
        this.np1 = iArr[0];
        this.np2 = iArr[1];
        this.np3 = iArr[2];
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.np);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(250);
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setValue(iArr[0]);
        numberPicker.setOnValueChangedListener(new OnValueChangeListener() {
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                LogDiaryActivity.this.np1 = i2;
            }
        });
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.np1);
        numberPicker2.setMinValue(1);
        numberPicker2.setMaxValue(250);
        numberPicker2.setWrapSelectorWheel(true);
        numberPicker2.setValue(iArr[1]);
        numberPicker2.setOnValueChangedListener(new OnValueChangeListener() {
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                LogDiaryActivity.this.np2 = i2;
            }
        });
        NumberPicker numberPicker3 = (NumberPicker) findViewById(R.id.np2);
        numberPicker3.setMinValue(1);
        numberPicker3.setMaxValue(250);
        numberPicker3.setWrapSelectorWheel(true);
        numberPicker3.setValue(iArr[2]);
        numberPicker3.setOnValueChangedListener(new OnValueChangeListener() {
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                LogDiaryActivity.this.np3 = i2;
            }
        });
        this.tabla = (TabLayout) findViewById(R.id.menuBard);
        this.tabla.addOnTabSelectedListener(new OnTabSelectedListener() {
            public void onTabReselected(Tab tab) {
            }

            public void onTabUnselected(Tab tab) {
            }

            public void onTabSelected(Tab tab) {
                if (LogDiaryActivity.this.notFunction) {
                    return;
                }
                if (tab.getPosition() == 0) {
                    LogDiaryActivity.this.zreDl();
                } else if (tab.getPosition() == 1) {
                    LogDiaryActivity.this.zreDla();
                } else if (tab.getPosition() == 2) {
                    LogDiaryActivity.this.zreDls();
                } else if (tab.getPosition() == 3 && Container.music_is_ok) {
                    LogDiaryActivity.this.hideKeyBoardAndFocus();
                    LogDiaryActivity.this.omoo();
                }
            }
        });
        this.tablaa = (TabLayout) findViewById(R.id.menuBdc);
        this.tablaa.addOnTabSelectedListener(new OnTabSelectedListener() {
            public void onTabReselected(Tab tab) {
            }

            public void onTabUnselected(Tab tab) {
            }

            public void onTabSelected(Tab tab) {
                if (LogDiaryActivity.this.notFunction) {
                    return;
                }
                if (tab.getPosition() == 0) {
                    LogDiaryActivity.this.statshow();
                } else if (tab.getPosition() == 1) {
                    LogDiaryActivity.this.infoshow();
                }
            }
        });
        this.tablaaa = (TabLayout) findViewById(R.id.menuBd);
        this.tablaaa.addOnTabSelectedListener(new OnTabSelectedListener() {
            public void onTabReselected(Tab tab) {
            }

            public void onTabUnselected(Tab tab) {
            }

            public void onTabSelected(Tab tab) {
                if (!LogDiaryActivity.this.notFunction) {
                    LogDiaryActivity.huifwehufwe = tab.getPosition();
                    LogDiaryActivity.this.zreDla();
                }
            }
        });
        this.jfiwefew = (RelativeLayout) findViewById(R.id.contDa);
        this.jgirtgjrit = (RelativeLayout) findViewById(R.id.contStat);
        this.dbquwdbuqw = (RelativeLayout) findViewById(R.id.zcona);
        this.dbquwdbuqww = (RelativeLayout) findViewById(R.id.zconacal);
        this.jnqq = (RelativeLayout) findViewById(R.id.contAnl);
        this.oldaa = (RelativeLayout) findViewById(R.id.contOld);
        this.statsv = (RelativeLayout) findViewById(R.id.statLa);
        this.infosv = (RelativeLayout) findViewById(R.id.infoLa);
        this.notFunction = true;
        this.tablaaa.getTabAt(huifwehufwe).select();
        this.notFunction = false;
        if (Container.music_is_ok) {
            try {
                Tab newTab = this.tabla.newTab();
                newTab.setText((CharSequence) getResources().getString(R.string.app_framebu));
                if (this.kncknddsk == 3) {
                    newTab.select();
                }
                this.tabla.addTab(newTab);
            } catch (Exception unused) {
            }
        }
        TextView textView = (TextView) findViewById(R.id.infogra);
        TextView textView2 = (TextView) findViewById(R.id.infogrb);
        TextView textView3 = (TextView) findViewById(R.id.infogrc);
        try {
            textView.setText(colorString2(getResources().getString(R.string.goodA), getResources().getString(R.string.goodB), getResources().getColor(R.color.colorSys), getResources().getColor(R.color.colorDia)));
        } catch (Exception unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.goodA));
            sb.append("/");
            sb.append(getResources().getString(R.string.goodB));
            textView.setText(sb.toString());
        }
        try {
            textView2.setText(colorString2(getResources().getString(R.string.goodA), getResources().getString(R.string.goodB), getResources().getColor(R.color.colorSys), getResources().getColor(R.color.colorDia)));
        } catch (Exception unused3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getResources().getString(R.string.goodA));
            sb2.append("/");
            sb2.append(getResources().getString(R.string.goodB));
            textView2.setText(sb2.toString());
        }
        try {
            textView3.setText(colorString2(getResources().getString(R.string.goodA), getResources().getString(R.string.goodB), getResources().getColor(R.color.colorSys), getResources().getColor(R.color.colorDia)));
        } catch (Exception unused4) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getResources().getString(R.string.goodA));
            sb3.append("/");
            sb3.append(getResources().getString(R.string.goodB));
            textView3.setText(sb3.toString());
        }
        this.btdatpi = (Button) findViewById(R.id.btn_date);
        this.bttipi = (Button) findViewById(R.id.btn_time);
        this.tdatt = (TextView) findViewById(R.id.idat);
        this.ttimm = (TextView) findViewById(R.id.itim);
        this.btdatpi.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Calendar instance = Calendar.getInstance();
                LogDiaryActivity.this.btyea = instance.get(1);
                LogDiaryActivity.this.btmon = instance.get(2);
                LogDiaryActivity.this.btda = instance.get(5);
                DatePickerDialog datePickerDialog = new DatePickerDialog(LogDiaryActivity.this, new OnDateSetListener() {
                    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                        TextView access$800 = LogDiaryActivity.this.tdatt;
                        StringBuilder sb = new StringBuilder();
                        sb.append(i3);
                        sb.append("/");
                        sb.append(i2 + 1);
                        sb.append("/");
                        sb.append(i);
                        access$800.setText(sb.toString());
                    }
                }, LogDiaryActivity.this.btyea, LogDiaryActivity.this.btmon, LogDiaryActivity.this.btda);
                datePickerDialog.show();
            }
        });
        this.bttipi.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Calendar instance = Calendar.getInstance();
                LogDiaryActivity.this.btho = instance.get(11);
                LogDiaryActivity.this.btmi = instance.get(12);
                TimePickerDialog timePickerDialog = new TimePickerDialog(LogDiaryActivity.this, new OnTimeSetListener() {
                    public void onTimeSet(TimePicker timePicker, int i, int i2) {
                        TextView access$1100 = LogDiaryActivity.this.ttimm;
                        StringBuilder sb = new StringBuilder();
                        sb.append(i);
                        sb.append(":");
                        sb.append(i2);
                        access$1100.setText(sb.toString());
                    }
                }, LogDiaryActivity.this.btho, LogDiaryActivity.this.btmi, false);
                timePickerDialog.show();
            }
        });
        SearchView searchView = (SearchView) findViewById(R.id.searchbar);
        lodad();
        if (this.fwerfwe == 0) {
            ((TextView) findViewById(R.id.dInfa)).setVisibility(View.GONE);
            ((ScrollView) findViewById(R.id.scAd)).setVisibility(View.GONE);
            searchView.setVisibility(View.GONE);
            ((TableLayout) findViewById(R.id.suggesttable)).setVisibility(View.GONE);
            this.tablaaa.setVisibility(View.GONE);
            ((GraphView) findViewById(R.id.diag)).setVisibility(View.GONE);
            ((GraphView) findViewById(R.id.diaga)).setVisibility(View.GONE);
            ((GraphView) findViewById(R.id.diagb)).setVisibility(View.GONE);
            ((GraphView) findViewById(R.id.diagc)).setVisibility(View.GONE);
            ((TextView) findViewById(R.id.ndajr)).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.ndstz)).setVisibility(View.VISIBLE);
            ((LinearLayout) findViewById(R.id.zrecl)).setVisibility(View.GONE);
        } else {
            ((TextView) findViewById(R.id.ndajr)).setVisibility(View.GONE);
            ((TextView) findViewById(R.id.ndstz)).setVisibility(View.GONE);
            ((LinearLayout) findViewById(R.id.zrecl)).setVisibility(View.VISIBLE);
            searchView.setVisibility(View.VISIBLE);
            ((TableLayout) findViewById(R.id.suggesttable)).setVisibility(View.VISIBLE);
        }
        if (Container.music_is_ok && wqeweqw) {
            wqeweqw = false;
            this.tabla.getTabAt(3).select();
        }
        searchView.setQueryHint(getResources().getString(R.string.searchfield));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    ((TableLayout) LogDiaryActivity.this.findViewById(R.id.suggesttable)).setVisibility(View.GONE);
                    return;
                }
                ((TableLayout) LogDiaryActivity.this.findViewById(R.id.suggesttable)).setVisibility(View.VISIBLE);
                LogDiaryActivity.this.dbquwdbuqw.setVisibility(View.GONE);
                LogDiaryActivity.this.dbquwdbuqww.setVisibility(View.GONE);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                LogDiaryActivity.this.performSearch(str);
                LogDiaryActivity.this.hideKeyBoardAndFocus();
                return false;
            }

            public boolean onQueryTextChange(String str) {
                LogDiaryActivity.this.performSearch(str);
                return true;
            }
        });
    }

    public void statshow() {
        this.statsv.setVisibility(View.VISIBLE);
        this.infosv.setVisibility(View.GONE);
        this.dbquwdbuqw.setVisibility(View.GONE);
        this.dbquwdbuqww.setVisibility(View.GONE);
    }

    public void infoshow() {
        this.statsv.setVisibility(View.GONE);
        this.infosv.setVisibility(View.VISIBLE);
        this.dbquwdbuqw.setVisibility(View.GONE);
        this.dbquwdbuqww.setVisibility(View.GONE);
    }

    public void performSearch(String str) {
        try {
            if (!this.searchOne) {
                this.searchOne = true;
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.table);
                TableLayout tableLayout = (TableLayout) findViewById(R.id.suggesttable);
                tableLayout.removeAllViews();
                String trim = str.trim();
                if (trim.length() == 0) {
                    tableLayout.setVisibility(View.GONE);
                    Iterator it = entryList.iterator();
                    while (it.hasNext()) {
                        try {
                            linearLayout.findViewWithTag((String) it.next()).setVisibility(View.VISIBLE);
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    HashSet hashSet = new HashSet();
                    int i = 0;
                    for (String str2 : searchmap.keySet()) {
                        if (str2.startsWith(trim)) {
                            Iterator it2 = ((HashSet) searchmap.get(str2)).iterator();
                            while (it2.hasNext()) {
                                hashSet.add((String) it2.next());
                            }
                            if (i < 5) {
                                tableLayout.setVisibility(View.VISIBLE);
                                TableRow tableRow = (TableRow) ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.searchrow, null);
                                TextView textView = (TextView) tableRow.findViewById(R.id.searchtext);
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                                spannableStringBuilder.setSpan(new StyleSpan(1), 0, trim.length(), 33);
                                textView.setText(spannableStringBuilder);
                                tableLayout.addView(tableRow);
                                i++;
                            }
                        }
                    }
                    Iterator it3 = entryList.iterator();
                    while (it3.hasNext()) {
                        String str3 = (String) it3.next();
                        if (hashSet.contains(str3)) {
                            try {
                                linearLayout.findViewWithTag(str3).setVisibility(View.VISIBLE);
                            } catch (Exception unused2) {
                            }
                        } else {
                            linearLayout.findViewWithTag(str3).setVisibility(View.GONE);
                        }
                    }
                }
                this.searchOne = false;
            }
        } catch (Exception unused3) {
        }
    }

    public void zreDl() {
        hideKeyBoardAndFocus();
        ((ScrollView) findViewById(R.id.scAd)).setVisibility(View.GONE);
        this.jfiwefew.setVisibility(View.VISIBLE);
        this.jgirtgjrit.setVisibility(View.GONE);
        this.dbquwdbuqw.setVisibility(View.GONE);
        this.dbquwdbuqww.setVisibility(View.GONE);
        this.jnqq.setVisibility(View.GONE);
        this.oldaa.setVisibility(View.GONE);
        if (this.fwerfwe > 0) {
            ((TextView) findViewById(R.id.dInfa)).setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.ndajr)).setVisibility(View.GONE);
            new Thread() {
                public void run() {
                    synchronized (this) {
                        LogDiaryActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                ((ScrollView) LogDiaryActivity.this.findViewById(R.id.scAd)).setVisibility(View.VISIBLE);
                            }
                        });
                    }
                }
            }.start();
            return;
        }
        ((TextView) findViewById(R.id.dInfa)).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.ndajr)).setVisibility(View.VISIBLE);
    }


    public void omoo() {

        this.jfiwefew.setVisibility(View.GONE);
        this.jgirtgjrit.setVisibility(View.GONE);
        this.dbquwdbuqw.setVisibility(View.GONE);
        this.dbquwdbuqww.setVisibility(View.GONE);
        this.jnqq.setVisibility(View.GONE);
        oldaa.setVisibility(View.VISIBLE);
        fijweofjer = ((ImageView) findViewById(R.id.imageView));
        fmkwmfer = ((ImageView) findViewById(R.id.imageView12));
        fijweofjer.setOnTouchListener(printListener);


    }

    public void zreDla() {
        hideKeyBoardAndFocus();
        stagpagsta();
    }

    public void stagpagsta() {
        this.jfiwefew.setVisibility(View.GONE);
        this.jgirtgjrit.setVisibility(View.VISIBLE);
        this.dbquwdbuqw.setVisibility(View.GONE);
        this.dbquwdbuqww.setVisibility(View.GONE);
        this.jnqq.setVisibility(View.GONE);
        this.oldaa.setVisibility(View.GONE);
        if (this.fwerfwe > 0) {
            this.tablaaa.setVisibility(View.VISIBLE);
            if (huifwehufwe == 0) {
                ((GraphView) findViewById(R.id.diag)).setVisibility(View.VISIBLE);
                ((GraphView) findViewById(R.id.diaga)).setVisibility(View.GONE);
                ((GraphView) findViewById(R.id.diagb)).setVisibility(View.GONE);
                ((GraphView) findViewById(R.id.diagc)).setVisibility(View.GONE);
            } else if (huifwehufwe == 1) {
                ((GraphView) findViewById(R.id.diag)).setVisibility(View.GONE);
                ((GraphView) findViewById(R.id.diaga)).setVisibility(View.VISIBLE);
                ((GraphView) findViewById(R.id.diagb)).setVisibility(View.GONE);
                ((GraphView) findViewById(R.id.diagc)).setVisibility(View.GONE);
            } else if (huifwehufwe == 2) {
                ((GraphView) findViewById(R.id.diag)).setVisibility(View.GONE);
                ((GraphView) findViewById(R.id.diaga)).setVisibility(View.GONE);
                ((GraphView) findViewById(R.id.diagb)).setVisibility(View.VISIBLE);
                ((GraphView) findViewById(R.id.diagc)).setVisibility(View.GONE);
            } else if (huifwehufwe == 3) {
                ((GraphView) findViewById(R.id.diag)).setVisibility(View.GONE);
                ((GraphView) findViewById(R.id.diaga)).setVisibility(View.GONE);
                ((GraphView) findViewById(R.id.diagb)).setVisibility(View.GONE);
                ((GraphView) findViewById(R.id.diagc)).setVisibility(View.VISIBLE);
            }
            ((TextView) findViewById(R.id.ndstz)).setVisibility(View.GONE);
            ((LinearLayout) findViewById(R.id.zrecl)).setVisibility(View.VISIBLE);
            if (!this.bjweudw) {
                this.bjweudw = true;
                graini();
            }
            if ((this.reloadStata[0] && huifwehufwe == 0) || ((this.reloadStata[1] && huifwehufwe == 1) || ((this.reloadStata[2] && huifwehufwe == 2) || (this.reloadStata[3] && huifwehufwe == 3)))) {
                if (this.reloadStata[0] && huifwehufwe == 0) {
                    this.reloadStata[0] = false;
                } else if (this.reloadStata[1] && huifwehufwe == 1) {
                    this.reloadStata[1] = false;
                } else if (this.reloadStata[2] && huifwehufwe == 2) {
                    this.reloadStata[2] = false;
                } else if (this.reloadStata[3] && huifwehufwe == 3) {
                    this.reloadStata[3] = false;
                }
                LinearLayout linearLayout = (LinearLayout) this.tablaaa.getChildAt(0);
                linearLayout.setEnabled(false);
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    linearLayout.getChildAt(i).setClickable(false);
                }
                this.vehuvehu = Float.POSITIVE_INFINITY;
                this.jifejiorferi = Float.NEGATIVE_INFINITY;
                stalo();
                linearLayout.setEnabled(true);
                for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                    linearLayout.getChildAt(i2).setClickable(true);
                }
                return;
            }
            return;
        }
        this.tablaaa.setVisibility(View.GONE);
        ((GraphView) findViewById(R.id.diag)).setVisibility(View.GONE);
        ((GraphView) findViewById(R.id.diaga)).setVisibility(View.GONE);
        ((GraphView) findViewById(R.id.diagb)).setVisibility(View.GONE);
        ((GraphView) findViewById(R.id.diagc)).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.ndstz)).setVisibility(View.VISIBLE);
        ((LinearLayout) findViewById(R.id.zrecl)).setVisibility(View.GONE);
    }

    public void zreDls() {
        hideKeyBoardAndFocus();
        int[] avgsdp = DManage.avgsdp(dqdqwfwdecs);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.diapb);
        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.pulpb);
        TextView textView = (TextView) findViewById(R.id.syspbtext);
        TextView textView2 = (TextView) findViewById(R.id.diapbtext);
        TextView textView3 = (TextView) findViewById(R.id.pulpbtext);
        try {
            ((ProgressBar) findViewById(R.id.syspb)).setProgress(avgsdp[0]);
            textView.setText(String.valueOf(avgsdp[0]));
        } catch (Exception unused) {
        }
        try {
            progressBar.setProgress(avgsdp[1]);
            textView2.setText(String.valueOf(avgsdp[1]));
        } catch (Exception unused2) {
        }
        try {
            progressBar2.setProgress(avgsdp[2]);
            textView3.setText(String.valueOf(avgsdp[2]));
        } catch (Exception unused3) {
        }
        statpafi();
        this.jfiwefew.setVisibility(View.GONE);
        this.jgirtgjrit.setVisibility(View.GONE);
        this.dbquwdbuqw.setVisibility(View.GONE);
        this.dbquwdbuqww.setVisibility(View.GONE);
        this.jnqq.setVisibility(View.VISIBLE);
        this.oldaa.setVisibility(View.GONE);
    }

    public void lodad() {
        wfeifwefw = new DManage(this.fhiwehufwe);
        dqdqwfwdecs = wfeifwefw.getWritableDatabase();
        taglist = DManage.tagslist(dqdqwfwdecs);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.tagsuggests);
        Iterator it = taglist.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (i >= 2) {
                break;
            }
            View inflate = layoutInflater.inflate(R.layout.tagsstwo, null);
            ((TextView) inflate.findViewById(R.id.tagtext)).setText(str);
            linearLayout.addView(inflate);
            i++;
        }
        ((LinearLayout) findViewById(R.id.table)).removeAllViews();
        this.jidqwidjqwhidw = DManage.zreDat(dqdqwfwdecs);
        this.fwerfwe = this.jidqwidjqwhidw.size();
        this.voerfgjoerj = 0;
        if (this.fwerfwe > 0) {
            final Handler handler = new Handler();
            handler.post(new Runnable() {
                public void run() {
                    if (LogDiaryActivity.this.datfil()) {
                        handler.postDelayed(this, 1);
                    }
                }
            });
        }
    }

    public void statpafi() {
        if (this.reloadStat) {
            GraphView graphView = (GraphView) findViewById(R.id.bargraph);
            if (!this.onceT) {
                graphView.getGridLabelRenderer().setGridStyle(GridStyle.BOTH);
                graphView.getGridLabelRenderer().setGridColor(getResources().getColor(R.color.colorDarkA));
                graphView.getGridLabelRenderer().setVerticalLabelsVisible(false);
                graphView.getGridLabelRenderer().setHorizontalLabelsVisible(false);
                graphView.getGridLabelRenderer().setHighlightZeroLines(false);
                graphView.getLegendRenderer().setVisible(false);
                graphView.getGridLabelRenderer().reloadStyles();
                graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                    public String formatLabel(double d, boolean z) {
                        if (z) {
                            return super.formatLabel(d, z);
                        }
                        return super.formatLabel((double) ((int) Math.floor(d)), z);
                    }
                });
                this.onceT = true;
            }
            int[] iArr = new int[4];
            Iterator it = DManage.zreDat22(dqdqwfwdecs).iterator();
            while (it.hasNext()) {
                String[] strArr = (String[]) it.next();
                iArr[3] = iArr[3] + 1;
                if (Float.parseFloat(strArr[1]) >= 120.0f && Float.parseFloat(strArr[1]) < 140.0f) {
                    iArr[0] = iArr[0] + 1;
                } else if (Float.parseFloat(strArr[1]) >= 90.0f && Float.parseFloat(strArr[1]) < 120.0f) {
                    iArr[0] = iArr[0] + 1;
                } else if (Float.parseFloat(strArr[1]) < 90.0f) {
                    iArr[0] = iArr[0] + 1;
                }
                if (Float.parseFloat(strArr[2]) >= 80.0f && Float.parseFloat(strArr[2]) < 90.0f) {
                    iArr[1] = iArr[1] + 1;
                } else if (Float.parseFloat(strArr[2]) >= 60.0f && Float.parseFloat(strArr[2]) < 80.0f) {
                    iArr[1] = iArr[1] + 1;
                } else if (Float.parseFloat(strArr[2]) < 60.0f) {
                    iArr[1] = iArr[1] + 1;
                }
                if (Float.parseFloat(strArr[3]) >= 70.0f && Float.parseFloat(strArr[3]) < 90.0f) {
                    iArr[2] = iArr[2] + 1;
                } else if (Float.parseFloat(strArr[3]) >= 50.0f && Float.parseFloat(strArr[3]) < 70.0f) {
                    iArr[2] = iArr[2] + 1;
                } else if (Float.parseFloat(strArr[3]) >= 35.0f && Float.parseFloat(strArr[3]) < 50.0f) {
                    iArr[2] = iArr[2] + 1;
                } else if (Float.parseFloat(strArr[3]) < 35.0f) {
                    iArr[2] = iArr[2] + 1;
                }
            }
            int max = Math.max(Math.max(Math.max(Math.max(Math.max(iArr[0], iArr[3] - iArr[0]), iArr[1]), iArr[3] - iArr[1]), iArr[2]), iArr[3] - iArr[2]);
            graphView.getViewport().setMinX(0.0d);
            graphView.getViewport().setMaxX(6.0d);
            graphView.getViewport().setMinY(0.0d);
            graphView.getViewport().setMaxY((double) (max + 1));
            graphView.getViewport().setYAxisBoundsManual(true);
            graphView.getViewport().setXAxisBoundsManual(true);
            graphView.removeAllSeries();
            float f = ((float) max) * 0.01f;
            float[] fArr = {(float) iArr[0], (float) (iArr[3] - iArr[0]), (float) iArr[1], (float) (iArr[3] - iArr[1]), (float) iArr[2], (float) (iArr[3] - iArr[2])};
            if (fArr[0] == 0.0f) {
                fArr[0] = f;
            }
            if (fArr[1] == 0.0f) {
                fArr[1] = f;
            }
            if (fArr[2] == 0.0f) {
                fArr[2] = f;
            }
            if (fArr[3] == 0.0f) {
                fArr[3] = f;
            }
            if (fArr[4] == 0.0f) {
                fArr[4] = f;
            }
            if (fArr[5] == 0.0f) {
                fArr[5] = f;
            }
            BarGraphSeries barGraphSeries = new BarGraphSeries(new DataPoint[]{new DataPoint(0.75d, (double) fArr[0]), new DataPoint(1.25d, (double) fArr[1]), new DataPoint(2.75d, (double) fArr[2]), new DataPoint(3.25d, (double) fArr[3]), new DataPoint(4.75d, (double) fArr[4]), new DataPoint(5.25d, (double) fArr[5])});
            graphView.addSeries(barGraphSeries);
            barGraphSeries.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                public int get(DataPoint dataPoint) {
                    float x = (float) dataPoint.getX();
                    if (x == 0.75f) {
                        return LogDiaryActivity.this.getResources().getColor(R.color.colorSys);
                    }
                    if (x == 1.25f) {
                        return LogDiaryActivity.this.getResources().getColor(R.color.colorDia);
                    }
                    if (x == 2.75f) {
                        return LogDiaryActivity.this.getResources().getColor(R.color.colorSys);
                    }
                    if (x == 3.25f) {
                        return LogDiaryActivity.this.getResources().getColor(R.color.colorDia);
                    }
                    if (x == 4.75f) {
                        return LogDiaryActivity.this.getResources().getColor(R.color.colorSys);
                    }
                    if (x == 5.25f) {
                        return LogDiaryActivity.this.getResources().getColor(R.color.colorDia);
                    }
                    return LogDiaryActivity.this.getResources().getColor(R.color.colorGrra);
                }
            });
            barGraphSeries.setSpacing(50);
            barGraphSeries.setDataWidth(1.0d);
            barGraphSeries.setDrawValuesOnTop(true);
            barGraphSeries.setValuesOnTopColor(getResources().getColor(R.color.colorGrra));
            barGraphSeries.setValuesOnTopSize(25.0f);
            this.reloadStat = false;
        }
    }

    public void addTagto(View view) {
        String charSequence = ((TextView) view.findViewById(R.id.tagtext)).getText().toString();
        EditText editText = (EditText) findViewById(R.id.editags);
        String str = "";
        String trim = editText.getText().toString().trim();
        int length = trim.length();
        if (length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(trim.charAt(length - 1));
            sb.append("");
            str = sb.toString();
        }
        String str2 = "";
        if (!str.equals("") && !str.equals(",")) {
            str2 = ",";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(charSequence);
        sb2.append(",");
        editText.append(sb2.toString());
    }

    public void addTagtoo(View view) {
        ((SearchView) findViewById(R.id.searchbar)).setQuery(((TextView) view.findViewById(R.id.tagtext)).getText().toString(), true);
    }

    public void rowClicked(View view) {
        ((SearchView) findViewById(R.id.searchbar)).setQuery(((TextView) view.findViewById(R.id.searchtext)).getText().toString(), false);
        hideKeyBoardAndFocus();
    }

    public boolean datfil() {
        dadadopos((LinearLayout) findViewById(R.id.table), (String[]) this.jidqwidjqwhidw.get(this.voerfgjoerj), -1);
        this.voerfgjoerj++;
        if (this.voerfgjoerj < this.fwerfwe) {
            return true;
        }
        return false;
    }

    public void dadadopos(LinearLayout linearLayout, String[] strArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        final LinearLayout linearLayout2 = linearLayout;
        int i6 = i;
        if (Float.parseFloat(strArr[1]) >= 140.0f) {
            i2 = getResources().getColor(R.color.colorDia);
        } else if (Float.parseFloat(strArr[1]) >= 120.0f && Float.parseFloat(strArr[1]) < 140.0f) {
            i2 = getResources().getColor(R.color.colorYelloww);
        } else if (Float.parseFloat(strArr[1]) >= 90.0f && Float.parseFloat(strArr[1]) < 120.0f) {
            i2 = getResources().getColor(R.color.colorSys);
        } else if (Float.parseFloat(strArr[1]) < 90.0f) {
            i2 = getResources().getColor(R.color.colorBlueA);
        } else {
            i2 = getResources().getColor(R.color.colorBTA);
        }
        if (Float.parseFloat(strArr[2]) >= 90.0f) {
            i3 = getResources().getColor(R.color.colorDia);
        } else if (Float.parseFloat(strArr[2]) >= 80.0f && Float.parseFloat(strArr[2]) < 90.0f) {
            i3 = getResources().getColor(R.color.colorYelloww);
        } else if (Float.parseFloat(strArr[2]) >= 60.0f && Float.parseFloat(strArr[2]) < 80.0f) {
            i3 = getResources().getColor(R.color.colorSys);
        } else if (Float.parseFloat(strArr[2]) < 60.0f) {
            i3 = getResources().getColor(R.color.colorBlueA);
        } else {
            i3 = getResources().getColor(R.color.colorBTA);
        }
        if (Float.parseFloat(strArr[3]) >= 90.0f) {
            i4 = getResources().getColor(R.color.colorDia);
        } else if (Float.parseFloat(strArr[3]) >= 70.0f && Float.parseFloat(strArr[3]) < 90.0f) {
            i4 = getResources().getColor(R.color.colorYelloww);
        } else if (Float.parseFloat(strArr[3]) >= 50.0f && Float.parseFloat(strArr[3]) < 70.0f) {
            i4 = getResources().getColor(R.color.colorSys);
        } else if (Float.parseFloat(strArr[3]) >= 35.0f && Float.parseFloat(strArr[3]) < 50.0f) {
            i4 = getResources().getColor(R.color.colorBlueA);
        } else if (Float.parseFloat(strArr[3]) < 35.0f) {
            i4 = getResources().getColor(R.color.colorDia);
        } else {
            i4 = getResources().getColor(R.color.colorBTA);
        }
        String[] split = strArr[0].split(StringUtils.SPACE);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View inflate = layoutInflater.inflate(R.layout.itms, null);
        inflate.setTag(strArr[4]);
        inflate.setOnLongClickListener(new OnLongClickListener() {
            @SuppressLint("ResourceType")
            public boolean onLongClick(final View view) {
                Builder builder = new Builder(LogDiaryActivity.this);
                builder.setMessage(LogDiaryActivity.this.getString(R.string.delq));
                builder.setPositiveButton(17039379, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DManage.zdelDat(LogDiaryActivity.dqdqwfwdecs, String.valueOf(view.getTag()));
                        linearLayout2.removeView(view);
                        LogDiaryActivity.this.fwerfwe = LogDiaryActivity.this.fwerfwe - 1;
                        LogDiaryActivity.this.reloadStat = true;
                        LogDiaryActivity.this.reloadStata[0] = true;
                        LogDiaryActivity.this.reloadStata[1] = true;
                        LogDiaryActivity.this.reloadStata[2] = true;
                        LogDiaryActivity.this.reloadStata[3] = true;
                    }
                });
                builder.setNegativeButton(17039369, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
                return true;
            }
        });
        ((TextView) inflate.findViewById(R.id.time)).setText(split[0]);
        TextView textView = (TextView) inflate.findViewById(R.id.timexv);
        StringBuilder sb = new StringBuilder();
        sb.append(split[1]);
        sb.append(StringUtils.SPACE);
        sb.append(split[2]);
        textView.setText(sb.toString());
        ((TextView) inflate.findViewById(R.id.sysVal)).setText(colorString(strArr[1], i2));
        ((TextView) inflate.findViewById(R.id.diaVal)).setText(colorString(strArr[2], i3));
        ((TextView) inflate.findViewById(R.id.pulVal)).setText(colorString(strArr[3], i4));
        if (!strArr[5].equals("")) {
            String[] split2 = strArr[5].split(",");
            int length = split2.length;
            LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.tagcontentpart);
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.tagcontent);
            if (length > 0) {
                i5 = 0;
                relativeLayout.setVisibility(View.VISIBLE);
            } else {
                i5 = 0;
            }
            boolean z = false;
            while (i5 < length) {
                String trim = split2[i5].trim();
                if (!trim.equals("")) {
                    try {
                        HashSet hashSet = (HashSet) searchmap.get(trim);
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.add(strArr[4]);
                        searchmap.put(trim, hashSet);
                    } catch (Exception unused) {
                    }
                    View inflate2 = layoutInflater.inflate(R.layout.tagss, null);
                    ((TextView) inflate2.findViewById(R.id.tagtext)).setText(trim);
                    linearLayout3.addView(inflate2);
                    z = true;
                }
                i5++;
            }
            if (!z) {
                relativeLayout.setVisibility(View.GONE);
            }
        }
        entryList.add(strArr[4]);
        if (i6 == -1) {
            linearLayout2.addView(inflate);
        } else {
            linearLayout2.addView(inflate, i6);
        }
    }

    public void graini() {
        this.dhiwehfwef = (GraphView) findViewById(R.id.diag);
        this.dhiwehfwef.getGridLabelRenderer().setGridStyle(GridStyle.BOTH);
        this.dhiwehfwef.getGridLabelRenderer().setGridColor(getResources().getColor(R.color.colorDarkA));
        this.dhiwehfwef.getGridLabelRenderer().setVerticalLabelsVisible(true);
        this.dhiwehfwef.getGridLabelRenderer().setHorizontalLabelsVisible(true);
        this.dhiwehfwef.getGridLabelRenderer().setHorizontalAxisTitle(getResources().getString(R.string.dayA));
        this.dhiwehfwef.getGridLabelRenderer().setHorizontalAxisTitleTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14.0f, getResources().getDisplayMetrics()));
        this.dhiwehfwef.getGridLabelRenderer().setHighlightZeroLines(false);
        this.dhiwehfwef.getLegendRenderer().setVisible(false);
        this.dhiwehfwef.getLegendRenderer().setAlign(LegendAlign.BOTTOM);
        this.dhiwehfwef.getLegendRenderer().setTextColor(getResources().getColor(R.color.colorWhite));
        this.dhiwehfwef.getLegendRenderer().setBackgroundColor(getResources().getColor(R.color.colorTrda));
        this.dhiwehfwef.getGridLabelRenderer().reloadStyles();
        this.dhiwehfwef.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            public String formatLabel(double d, boolean z) {
                if (!z) {
                    return super.formatLabel((double) ((int) d), z);
                }
                LogDiaryActivity.this.dhiwehfwef.getGridLabelRenderer().setHorizontalAxisTitle(LogDiaryActivity.this.getResources().getString(R.string.hourA));
                LogDiaryActivity.this.dhiwehfwef.getGridLabelRenderer().setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14.0f, LogDiaryActivity.this.getResources().getDisplayMetrics()));
                LogDiaryActivity.this.dhiwehfwef.getGridLabelRenderer().setNumHorizontalLabels(5);
                LogDiaryActivity.this.dhiwehfwef.getGridLabelRenderer().setHumanRounding(false);
                return LogDiaryActivity.this.fggftrw.format(new Date((long) d));
            }
        });
        this.dhiwehfwefa = (GraphView) findViewById(R.id.diaga);
        this.dhiwehfwefa.getGridLabelRenderer().setGridStyle(GridStyle.BOTH);
        this.dhiwehfwefa.getGridLabelRenderer().setGridColor(getResources().getColor(R.color.colorDarkA));
        this.dhiwehfwefa.getGridLabelRenderer().setVerticalLabelsVisible(true);
        this.dhiwehfwefa.getGridLabelRenderer().setHorizontalLabelsVisible(true);
        this.dhiwehfwefa.getGridLabelRenderer().setHorizontalAxisTitle(getResources().getString(R.string.dayA));
        this.dhiwehfwefa.getGridLabelRenderer().setHorizontalAxisTitleTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14.0f, getResources().getDisplayMetrics()));
        this.dhiwehfwefa.getGridLabelRenderer().setHighlightZeroLines(false);
        this.dhiwehfwefa.getLegendRenderer().setVisible(false);
        this.dhiwehfwefa.getLegendRenderer().setAlign(LegendAlign.BOTTOM);
        this.dhiwehfwefa.getLegendRenderer().setTextColor(getResources().getColor(R.color.colorWhite));
        this.dhiwehfwefa.getLegendRenderer().setBackgroundColor(getResources().getColor(R.color.colorTrda));
        this.dhiwehfwefa.getGridLabelRenderer().reloadStyles();
        this.dhiwehfwefa.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            public String formatLabel(double d, boolean z) {
                if (!z) {
                    return super.formatLabel((double) ((int) d), z);
                }
                LogDiaryActivity.this.dhiwehfwefa.getGridLabelRenderer().setHorizontalAxisTitle(LogDiaryActivity.this.getResources().getString(R.string.dayA));
                LogDiaryActivity.this.dhiwehfwefa.getGridLabelRenderer().setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12.0f, LogDiaryActivity.this.getResources().getDisplayMetrics()));
                LogDiaryActivity.this.dhiwehfwefa.getGridLabelRenderer().setNumHorizontalLabels(10);
                LogDiaryActivity.this.dhiwehfwefa.getGridLabelRenderer().setHumanRounding(false);
                return LogDiaryActivity.this.dwedwedw.format(new Date((long) d));
            }
        });
        this.dhiwehfwefb = (GraphView) findViewById(R.id.diagb);
        this.dhiwehfwefb.getGridLabelRenderer().setGridStyle(GridStyle.BOTH);
        this.dhiwehfwefb.getGridLabelRenderer().setGridColor(getResources().getColor(R.color.colorDarkA));
        this.dhiwehfwefb.getGridLabelRenderer().setVerticalLabelsVisible(true);
        this.dhiwehfwefb.getGridLabelRenderer().setHorizontalLabelsVisible(true);
        this.dhiwehfwefb.getGridLabelRenderer().setHorizontalAxisTitle(getResources().getString(R.string.dayA));
        this.dhiwehfwefb.getGridLabelRenderer().setHorizontalAxisTitleTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14.0f, getResources().getDisplayMetrics()));
        this.dhiwehfwefb.getGridLabelRenderer().setHighlightZeroLines(false);
        this.dhiwehfwefb.getLegendRenderer().setVisible(false);
        this.dhiwehfwefb.getLegendRenderer().setAlign(LegendAlign.BOTTOM);
        this.dhiwehfwefb.getLegendRenderer().setTextColor(getResources().getColor(R.color.colorWhite));
        this.dhiwehfwefb.getLegendRenderer().setBackgroundColor(getResources().getColor(R.color.colorTrda));
        this.dhiwehfwefb.getGridLabelRenderer().reloadStyles();
        this.dhiwehfwefb.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            public String formatLabel(double d, boolean z) {
                if (!z) {
                    return super.formatLabel((double) ((int) d), z);
                }
                LogDiaryActivity.this.dhiwehfwefb.getGridLabelRenderer().setHorizontalAxisTitle(LogDiaryActivity.this.getResources().getString(R.string.monthA));
                LogDiaryActivity.this.dhiwehfwefb.getGridLabelRenderer().setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15.0f, LogDiaryActivity.this.getResources().getDisplayMetrics()));
                LogDiaryActivity.this.dhiwehfwefb.getGridLabelRenderer().setNumHorizontalLabels(4);
                LogDiaryActivity.this.dhiwehfwefb.getGridLabelRenderer().setHumanRounding(false);
                return LogDiaryActivity.this.fwerfew.format(new Date((long) d));
            }
        });
        this.dhiwehfwefc = (GraphView) findViewById(R.id.diagc);
        this.dhiwehfwefc.getGridLabelRenderer().setGridStyle(GridStyle.BOTH);
        this.dhiwehfwefc.getGridLabelRenderer().setGridColor(getResources().getColor(R.color.colorDarkA));
        this.dhiwehfwefc.getGridLabelRenderer().setVerticalLabelsVisible(true);
        this.dhiwehfwefc.getGridLabelRenderer().setHorizontalLabelsVisible(true);
        this.dhiwehfwefc.getGridLabelRenderer().setHorizontalAxisTitle(getResources().getString(R.string.dayA));
        this.dhiwehfwefc.getGridLabelRenderer().setHorizontalAxisTitleTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14.0f, getResources().getDisplayMetrics()));
        this.dhiwehfwefc.getGridLabelRenderer().setHighlightZeroLines(false);
        this.dhiwehfwefc.getLegendRenderer().setVisible(false);
        this.dhiwehfwefc.getLegendRenderer().setAlign(LegendAlign.BOTTOM);
        this.dhiwehfwefc.getLegendRenderer().setTextColor(getResources().getColor(R.color.colorWhite));
        this.dhiwehfwefc.getLegendRenderer().setBackgroundColor(getResources().getColor(R.color.colorTrda));
        this.dhiwehfwefc.getGridLabelRenderer().reloadStyles();
        this.dhiwehfwefc.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            public String formatLabel(double d, boolean z) {
                if (!z) {
                    return super.formatLabel((double) ((int) d), z);
                }
                LogDiaryActivity.this.dhiwehfwefc.getGridLabelRenderer().setHorizontalAxisTitle(LogDiaryActivity.this.getResources().getString(R.string.dateA));
                LogDiaryActivity.this.dhiwehfwefc.getGridLabelRenderer().setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 13.0f, LogDiaryActivity.this.getResources().getDisplayMetrics()));
                LogDiaryActivity.this.dhiwehfwefc.getGridLabelRenderer().setNumHorizontalLabels(3);
                LogDiaryActivity.this.dhiwehfwefc.getGridLabelRenderer().setHumanRounding(false);
                return LogDiaryActivity.this.dqweqdcsd.format(new Date((long) d));
            }
        });
    }

    public void stalo() {
        Viewport viewport;
        wfeifwefw = new DManage(this.fhiwehufwe);
        dqdqwfwdecs = wfeifwefw.getWritableDatabase();
        if (huifwehufwe == 0) {
            this.dhiwehfwef.removeAllSeries();
        } else if (huifwehufwe == 1) {
            this.dhiwehfwefa.removeAllSeries();
        } else if (huifwehufwe == 2) {
            this.dhiwehfwefb.removeAllSeries();
        } else if (huifwehufwe == 3) {
            this.dhiwehfwefc.removeAllSeries();
        }
        DataPoint[][] dazuge = dazuge();
        if (dazuge[0].length > 0) {
            LineGraphSeries lineGraphSeries = new LineGraphSeries(dazuge[0]);
            lineGraphSeries.setThickness(3);
            lineGraphSeries.setTitle(getResources().getString(R.string.sysAAA));
            lineGraphSeries.setColor(getResources().getColor(R.color.colorSys));
            lineGraphSeries.setDrawDataPoints(true);
            lineGraphSeries.setDataPointsRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5.0f, getResources().getDisplayMetrics()));
            lineGraphSeries.setOnDataPointTapListener(new OnDataPointTapListener() {
                public void onTap(Series series, DataPointInterface dataPointInterface) {
                    Context applicationContext = LogDiaryActivity.this.getApplicationContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(LogDiaryActivity.this.getResources().getString(R.string.systolicA));
                    sb.append(": ");
                    sb.append((int) dataPointInterface.getY());
                    Toast.makeText(applicationContext, sb.toString(), Toast.LENGTH_SHORT).show();
                }
            });
            lineGraphSeries.setBackgroundColor(getResources().getColor(R.color.colorSysAA));
            lineGraphSeries.setDrawBackground(true);
            if (huifwehufwe == 0) {
                this.dhiwehfwef.addSeries(lineGraphSeries);
            } else if (huifwehufwe == 1) {
                this.dhiwehfwefa.addSeries(lineGraphSeries);
            } else if (huifwehufwe == 2) {
                this.dhiwehfwefb.addSeries(lineGraphSeries);
            } else if (huifwehufwe == 3) {
                this.dhiwehfwefc.addSeries(lineGraphSeries);
            }
            LineGraphSeries lineGraphSeries2 = new LineGraphSeries(dazuge[1]);
            lineGraphSeries2.setThickness(3);
            lineGraphSeries2.setTitle(getResources().getString(R.string.diaAAA));
            lineGraphSeries2.setColor(getResources().getColor(R.color.colorDia));
            lineGraphSeries2.setDrawDataPoints(true);
            lineGraphSeries2.setDataPointsRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5.0f, getResources().getDisplayMetrics()));
            lineGraphSeries2.setOnDataPointTapListener(new OnDataPointTapListener() {
                public void onTap(Series series, DataPointInterface dataPointInterface) {
                    Context applicationContext = LogDiaryActivity.this.getApplicationContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(LogDiaryActivity.this.getResources().getString(R.string.diastolicA));
                    sb.append(": ");
                    sb.append((int) dataPointInterface.getY());
                    Toast.makeText(applicationContext, sb.toString(), Toast.LENGTH_SHORT).show();
                }
            });
            lineGraphSeries2.setBackgroundColor(getResources().getColor(R.color.colorDiaAA));
            lineGraphSeries2.setDrawBackground(true);
            if (huifwehufwe == 0) {
                this.dhiwehfwef.addSeries(lineGraphSeries2);
            } else if (huifwehufwe == 1) {
                this.dhiwehfwefa.addSeries(lineGraphSeries2);
            } else if (huifwehufwe == 2) {
                this.dhiwehfwefb.addSeries(lineGraphSeries2);
            } else if (huifwehufwe == 3) {
                this.dhiwehfwefc.addSeries(lineGraphSeries2);
            }
            LineGraphSeries lineGraphSeries3 = new LineGraphSeries(dazuge[2]);
            lineGraphSeries3.setThickness(3);
            lineGraphSeries3.setTitle(getResources().getString(R.string.pulAAA));
            lineGraphSeries3.setColor(getResources().getColor(R.color.colorPulse));
            lineGraphSeries3.setDrawDataPoints(true);
            lineGraphSeries3.setDataPointsRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5.0f, getResources().getDisplayMetrics()));
            lineGraphSeries3.setOnDataPointTapListener(new OnDataPointTapListener() {
                public void onTap(Series series, DataPointInterface dataPointInterface) {
                    Context applicationContext = LogDiaryActivity.this.getApplicationContext();
                    StringBuilder sb = new StringBuilder();
                    sb.append(LogDiaryActivity.this.getResources().getString(R.string.pulseAA));
                    sb.append(": ");
                    sb.append((int) dataPointInterface.getY());
                    Toast.makeText(applicationContext, sb.toString(), Toast.LENGTH_SHORT).show();
                }
            });
            lineGraphSeries3.setBackgroundColor(getResources().getColor(R.color.colorPulseAA));
            lineGraphSeries3.setDrawBackground(true);
            if (huifwehufwe == 0) {
                this.dhiwehfwef.addSeries(lineGraphSeries3);
            } else if (huifwehufwe == 1) {
                this.dhiwehfwefa.addSeries(lineGraphSeries3);
            } else if (huifwehufwe == 2) {
                this.dhiwehfwefb.addSeries(lineGraphSeries3);
            } else if (huifwehufwe == 3) {
                this.dhiwehfwefc.addSeries(lineGraphSeries3);
            }
        } else {
            this.vehuvehu = 0.0f;
            this.jifejiorferi = 0.0f;
        }
        if (this.hifowehiovjopdqp == this.hufwehufwehu) {
            this.hufwehufwehu++;
        }
        if (huifwehufwe == 0) {
            viewport = this.dhiwehfwef.getViewport();
        } else if (huifwehufwe == 1) {
            viewport = this.dhiwehfwefa.getViewport();
        } else if (huifwehufwe == 2) {
            viewport = this.dhiwehfwefb.getViewport();
        } else {
            viewport = this.dhiwehfwefc.getViewport();
        }
        viewport.setScrollable(true);
        viewport.setXAxisBoundsManual(true);
        viewport.setYAxisBoundsManual(true);
        viewport.setMinX((double) this.hifowehiovjopdqp);
        viewport.setMaxX((double) this.hufwehufwehu);
        viewport.setMinY((double) ((int) (this.vehuvehu - 5.0f)));
        viewport.setMaxY((double) ((int) (this.jifejiorferi + 5.0f)));
    }

    private DataPoint[][] dazuge() {
        ArrayList arrayList;
        long j;
        long j2;
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int i = 1;
        int i2 = instance.get(1);
        int i3 = instance.get(2);
        int i4 = instance.get(5);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
        if (huifwehufwe == 0) {
            arrayList = DManage.zreDat2(dqdqwfwdecs, i4, i3, i2);
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append("/");
                sb.append(i3 + 1);
                sb.append("/");
                sb.append(i2);
                Date parse = simpleDateFormat.parse(sb.toString());
                Calendar instance2 = Calendar.getInstance();
                instance2.setTime(parse);
                this.hifowehiovjopdqp = instance2.getTime().getTime();
                instance2.add(5, 1);
                this.hufwehufwehu = instance2.getTime().getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (huifwehufwe == 1) {
            arrayList = DManage.zreDat2M(dqdqwfwdecs, i3, i2);
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("01/");
                sb2.append(i3 + 1);
                sb2.append("/");
                sb2.append(i2);
                Date parse2 = simpleDateFormat.parse(sb2.toString());
                Calendar instance3 = Calendar.getInstance();
                instance3.setTime(parse2);
                this.hifowehiovjopdqp = instance3.getTime().getTime();
                instance3.add(2, 1);
                this.hufwehufwehu = instance3.getTime().getTime();
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        } else if (huifwehufwe == 2) {
            arrayList = DManage.zreDat2Y(dqdqwfwdecs, i2);
            try {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("01/01/");
                sb3.append(i2);
                Date parse3 = simpleDateFormat.parse(sb3.toString());
                Calendar instance4 = Calendar.getInstance();
                instance4.setTime(parse3);
                this.hifowehiovjopdqp = instance4.getTime().getTime();
                instance4.add(1, 1);
                this.hufwehufwehu = instance4.getTime().getTime();
            } catch (ParseException e3) {
                e3.printStackTrace();
            }
        } else {
            arrayList = DManage.zreDat22(dqdqwfwdecs);
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        String str = "";
        int i5 = 0;
        int i6 = 0;
        long j3 = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (it.hasNext()) {
            String[] strArr = (String[]) it.next();
            if (i5 <= 0 || str.equals(strArr[4])) {
                j = j3;
                j2 = 0;
            } else {
                String[] strArr2 = new String[4];
                strArr2[0] = String.valueOf(j3);
                float f4 = (float) i6;
                float f5 = f / f4;
                strArr2[i] = String.valueOf(f5);
                float f6 = f2 / f4;
                strArr2[2] = String.valueOf(f6);
                float f7 = f3 / f4;
                strArr2[3] = String.valueOf(f7);
                arrayList2.add(strArr2);
                this.vehuvehu = Math.min(f5, this.vehuvehu);
                this.vehuvehu = Math.min(f6, this.vehuvehu);
                this.vehuvehu = Math.min(f7, this.vehuvehu);
                this.jifejiorferi = Math.max(f5, this.jifejiorferi);
                this.jifejiorferi = Math.max(f6, this.jifejiorferi);
                this.jifejiorferi = Math.max(f7, this.jifejiorferi);
                i6 = 0;
                j2 = 0;
                f = 0.0f;
                f2 = 0.0f;
                f3 = 0.0f;
                j = 0;
            }
            if (j == j2) {
                try {
                    if (huifwehufwe == 0) {
                        Date parse4 = this.fwheufheuw.parse(strArr[0]);
                        Calendar instance5 = Calendar.getInstance();
                        instance5.setTime(parse4);
                        instance5.set(12, 0);
                        instance5.set(13, 0);
                        j = instance5.getTime().getTime();
                    } else if (huifwehufwe == i) {
                        Date parse5 = this.fwheufheuw.parse(strArr[0]);
                        Calendar instance6 = Calendar.getInstance();
                        instance6.setTime(parse5);
                        instance6.set(11, 0);
                        instance6.set(12, 0);
                        instance6.set(13, 0);
                        j = instance6.getTime().getTime();
                    } else if (huifwehufwe == 2) {
                        Date parse6 = this.fwheufheuw.parse(strArr[0]);
                        Calendar instance7 = Calendar.getInstance();
                        instance7.setTime(parse6);
                        instance7.set(5, 0);
                        instance7.set(11, 0);
                        instance7.set(12, 0);
                        instance7.set(13, 0);
                        j = instance7.getTime().getTime();
                    } else if (huifwehufwe == 3) {
                        Date parse7 = this.fwheufheuw.parse(strArr[0]);
                        Calendar instance8 = Calendar.getInstance();
                        instance8.setTime(parse7);
                        instance8.set(11, 0);
                        instance8.set(12, 0);
                        instance8.set(13, 0);
                        j = instance8.getTime().getTime();
                    }
                } catch (Exception unused) {
                    j3 = 0;
                }
            }
            j3 = j;
            if (huifwehufwe == 3) {
                if (i5 == 0) {
                    this.hifowehiovjopdqp = j3;
                }
                if (i5 + 1 == size) {
                    this.hufwehufwehu = j3;
                }
            }
            String[] strArr3 = new String[3];
            strArr3[0] = strArr[i];
            strArr3[i] = strArr[2];
            strArr3[2] = strArr[3];
            if (strArr3[0].equals("-")) {
                strArr3[0] = "0";
            }
            if (strArr3[i].equals("-")) {
                strArr3[i] = "0";
            }
            if (strArr3[2].equals("-")) {
                strArr3[2] = "0";
            }
            f += Float.parseFloat(strArr3[0]);
            f2 += Float.parseFloat(strArr3[i]);
            f3 += Float.parseFloat(strArr3[2]);
            i6 += i;
            i5++;
            if (i5 == size) {
                String[] strArr4 = new String[4];
                strArr4[0] = String.valueOf(j3);
                float f8 = (float) i6;
                float f9 = f / f8;
                strArr4[i] = String.valueOf(f9);
                float f10 = f2 / f8;
                strArr4[2] = String.valueOf(f10);
                float f11 = f3 / f8;
                strArr4[3] = String.valueOf(f11);
                arrayList2.add(strArr4);
                this.vehuvehu = Math.min(f9, this.vehuvehu);
                this.vehuvehu = Math.min(f10, this.vehuvehu);
                this.vehuvehu = Math.min(f11, this.vehuvehu);
                this.jifejiorferi = Math.max(f9, this.jifejiorferi);
                this.jifejiorferi = Math.max(f10, this.jifejiorferi);
                this.jifejiorferi = Math.max(f11, this.jifejiorferi);
            }
            str = strArr[4];
            i = 1;
        }
        DataPoint[][] dataPointArr = (DataPoint[][]) Array.newInstance(DataPoint.class, new int[]{3, arrayList2.size()});
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            String[] strArr5 = (String[]) arrayList2.get(i7);
            dataPointArr[0][i7] = new DataPoint((double) Long.parseLong(strArr5[0]), (double) Float.parseFloat(strArr5[1]));
            dataPointArr[1][i7] = new DataPoint((double) Long.parseLong(strArr5[0]), (double) Float.parseFloat(strArr5[2]));
            dataPointArr[2][i7] = new DataPoint((double) Long.parseLong(strArr5[0]), (double) Float.parseFloat(strArr5[3]));
        }
        return dataPointArr;
    }

    public void aenta(View view) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        int i4 = instance.get(11);
        String trim = ((EditText) findViewById(R.id.editags)).getText().toString().trim();
        String[] strArr = new String[10];
        strArr[0] = this.fwheufheuw.format(instance.getTime());
        strArr[1] = String.valueOf(this.np1);
        strArr[2] = String.valueOf(this.np2);
        strArr[3] = String.valueOf(this.np3);
        strArr[4] = String.valueOf(DManage.zregMI(dqdqwfwdecs) + 1);
        if (strArr[1].equals("")) {
            strArr[1] = "-";
        }
        if (strArr[2].equals("")) {
            strArr[2] = "-";
        }
        if (strArr[3].equals("")) {
            strArr[3] = "-";
        }
        strArr[5] = String.valueOf(trim);
        strArr[6] = String.valueOf(i3);
        strArr[7] = String.valueOf(i2);
        strArr[8] = String.valueOf(i);
        strArr[9] = String.valueOf(i4);
        DManage.zaddDat(dqdqwfwdecs, strArr);
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.addedA), Toast.LENGTH_LONG).show();
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), 0);
        sharedPreferences.edit().putInt("sysvabx", this.np1).apply();
        sharedPreferences.edit().putInt("diavabx", this.np2).apply();
        sharedPreferences.edit().putInt("pulvabx", this.np3).apply();
        finish();
        startActivity(getIntent());
    }

    public CharSequence colorString(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return TextUtils.concat(new CharSequence[]{spannableString});
    }

    public CharSequence colorString2(String str, String str2, int i, int i2) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        SpannableString spannableString2 = new SpannableString(str2);
        spannableString2.setSpan(new ForegroundColorSpan(i2), 0, str2.length(), 33);
        return TextUtils.concat(new CharSequence[]{spannableString, "/", spannableString2});
    }

    public void closeaddonev(View view) {
        this.dbquwdbuqw.setVisibility(View.GONE);
    }

    public void hideKeyBoardAndFocus() {
        try {
            ((SearchView) findViewById(R.id.searchbar)).clearFocus();
        } catch (Exception unused) {
        }
        ((TableLayout) findViewById(R.id.suggesttable)).setVisibility(View.GONE);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 112) {
            if (iArr.length > 0 && iArr[0] == 0) {
                csvExport();
            }
        } else if (i == 114 && iArr.length > 0 && iArr[0] == 0) {
            addCalendarEvent();
        }
    }

    public void csvexport(View view) {
        this.dbquwdbuqw.setVisibility(View.GONE);
        try {
            if (VERSION.SDK_INT < 23) {
                csvExport();
            } else if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 112);
            } else if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED) {
                csvExport();
            }
        } catch (Exception unused) {
        }
    }

    public void csvExport() {
        try {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            sb.append(File.separator);
            sb.append("BPData.csv");
            String sb2 = sb.toString();
            new File(sb2);
            CSVWriter cSVWriter = new CSVWriter(new FileWriter(sb2), ';');
            cSVWriter.writeAll((List<String[]>) DManage.csvData(dqdqwfwdecs));
            cSVWriter.close();
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.csvexporta), Toast.LENGTH_LONG).show();
        } catch (Exception unused) {
        }
    }

    @SuppressLint("ResourceType")
    public void alef() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) getString(R.string.app_info1title));
        builder.setMessage((CharSequence) getString(R.string.app_info3msg));
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).show();
    }

    public void psouof(View view) {
        Container.musiconoffor = !Container.musiconoffor;
        wqeweqw = true;
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void msta2(View view) {
        try {
            SharedPreferences sharedPreferences = this.mlvdfmvd.getSharedPreferences(Container.RATEIT, 0);
            Editor edit = sharedPreferences.edit();
            if (sharedPreferences.getInt(Container.OPENTIMES, 0) != 1) {
                edit.putInt(Container.OPENTIMES, 1).commit();
                MessageDialogBox messageDialogBox = new MessageDialogBox(this, this.mlvdfmvd);
                messageDialogBox.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                messageDialogBox.setCanceledOnTouchOutside(false);
                messageDialogBox.show();
                return;
            }
            alef();
        } catch (Exception unused) {
        }
    }

    public void addentrc(View view) {
        hideKeyBoardAndFocus();
        this.dbquwdbuqww.setVisibility(View.GONE);
        this.dbquwdbuqw.setVisibility(View.VISIBLE);
    }

    public void opencalc(View view) {
        try {
            Uri.Builder buildUpon = CalendarContract.CONTENT_URI.buildUpon();
            buildUpon.appendPath("time");
            ContentUris.appendId(buildUpon, Calendar.getInstance().getTimeInMillis());
            startActivity(new Intent("android.intent.action.VIEW").setData(buildUpon.build()));
        } catch (Exception unused) {
        }
    }

    public void closeaddonevcal(View view) {
        this.dbquwdbuqww.setVisibility(View.GONE);
    }

    public void addcalc(View view) {
        hideKeyBoardAndFocus();
        this.dbquwdbuqw.setVisibility(View.GONE);
        this.dbquwdbuqww.setVisibility(View.VISIBLE);
    }

    public void addcalcc(View view) {
        if (VERSION.SDK_INT < 23) {
            addCalendarEvent();
        } else if (checkSelfPermission("android.permission.WRITE_CALENDAR") != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{"android.permission.WRITE_CALENDAR"}, 114);
        } else if (checkSelfPermission("android.permission.WRITE_CALENDAR") == PackageManager.PERMISSION_GRANTED) {
            addCalendarEvent();
        }
    }

    public void addCalendarEvent() {
        String str;
        boolean z;
        int[] iArr = new int[3];
        int[] iArr2 = new int[2];
        String str2 = "";
        try {
            String[] split = ((TextView) findViewById(R.id.idat)).getText().toString().split("/");
            String[] split2 = ((TextView) findViewById(R.id.itim)).getText().toString().split(":");
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]) - 1;
            iArr[2] = Integer.parseInt(split[2]);
            iArr2[0] = Integer.parseInt(split2[0]);
            iArr2[1] = Integer.parseInt(split2[1]);
            if (((CheckBox) findViewById(R.id.calendareventbox)).isChecked()) {
                str2 = "FREQ=DAILY";
            }
            str = str2;
            z = true;
        } catch (Exception unused) {
            Toast.makeText(this, getResources().getString(R.string.calenahcd), Toast.LENGTH_SHORT).show();
            str = str2;
            z = false;
        }
        if (z) {
            this.dbquwdbuqww.setVisibility(View.GONE);
            String string = getResources().getString(R.string.opencalx);
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.opencal));
            sb.append(" https://appbloodpressurediary.info");
            addEventToCalendar(string, sb.toString(), iArr[2], iArr[1], iArr[0], iArr2[0], iArr2[1], str);
        }
    }

    public void addEventToCalendar(String str, String str2, int i, int i2, int i3, int i4, int i5, String str3) {
        String str4 = str3;
        try {
            Toast.makeText(this, getResources().getString(R.string.opencaly), Toast.LENGTH_SHORT).show();
            ContentValues contentValues = new ContentValues();
            Calendar instance = Calendar.getInstance();
            instance.set(i, i2, i3, i4, i5);
            contentValues.put("calendar_id", Integer.valueOf(1));
            String str5 = str;
            contentValues.put("title", str);
            String str6 = str2;
            contentValues.put("description", str2);
            contentValues.put("dtstart", Long.valueOf(instance.getTimeInMillis()));
            contentValues.put("dtend", Long.valueOf(instance.getTimeInMillis()));
            contentValues.put("hasAlarm", Boolean.valueOf(true));
            contentValues.put("eventTimezone", TimeZone.getDefault().getID());
            if (!str4.equals("")) {
                contentValues.put("rrule", str4);
            }
            contentValues.put("customAppPackage", getPackageName());
            contentValues.put("customAppUri", "myAppointment://1");
            if (ActivityCompat.checkSelfPermission(this, "android.permission.WRITE_CALENDAR") == 0) {
                long parseLong = Long.parseLong(getContentResolver().insert(Events.CONTENT_URI, contentValues).getLastPathSegment());
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(parseLong));
                contentValues2.put("minutes", Integer.valueOf(0));
                contentValues2.put("method", Integer.valueOf(1));
                getContentResolver().insert(Reminders.CONTENT_URI, contentValues2);
                Toast.makeText(this, getResources().getString(R.string.opencalyy), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception unused) {
            Toast.makeText(this, getResources().getString(R.string.opencalyyy), Toast.LENGTH_SHORT).show();
        }
    }

    public void msta(View view) {
        try {
            SharedPreferences sharedPreferences = this.mlvdfmvd.getSharedPreferences(Container.RATEIT, 0);
            sharedPreferences.edit();
            if (sharedPreferences.getInt(Container.OPENTIMES, 0) != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("market://details?id=");
                sb.append(getPackageName());
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                    return;
                }
                return;
            }
            alef();
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.nothing, R.anim.nothing);
        try {
            if (!Container.f3628hc.equals("") && !Container.lastActivity.equals(getClass().getSimpleName())) {
                Container.lastActivity = getClass().getSimpleName();
                Container.doHC(Container.lastActivity);
            }
        } catch (Exception unused) {
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onBackPressed() {
        if (this.dbquwdbuqw.getVisibility() == View.VISIBLE) {
            this.dbquwdbuqw.setVisibility(View.GONE);
        } else if (this.dbquwdbuqww.getVisibility() == View.VISIBLE) {
            this.dbquwdbuqww.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }


}
