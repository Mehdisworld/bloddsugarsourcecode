package com.androtoolz.bloodsugardiary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class DManage extends SQLiteOpenHelper {
    public static final String NDB = "diarylogdb.db";
    private static final String SQL_CREATE_DD = "CREATE TABLE map_info( 'ID' INTEGER PRIMARY KEY NOT NULL, 'DATE' VARCHAR, 'SYS' VARCHAR, 'DIA' VARCHAR, 'PUL' VARCHAR, 'DAY' INTEGER, 'MONTH' INTEGER, 'YEAR' INTEGER, 'HOUR' INTEGER, 'TAGS' VARCHAR );";
    public static final String TMI = "map_info";
    public static final int VDB = 1;

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public DManage(Context context) {
        super(context, NDB, null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(SQL_CREATE_DD);
        } catch (Exception unused) {
        }
    }

    public static void zdelDat(SQLiteDatabase sQLiteDatabase, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM map_info WHERE ID = ");
        sb.append(str);
        sb.append(";");
        sQLiteDatabase.execSQL(sb.toString());
    }

    public static void zaddDat(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO map_info (ID, DATE, SYS, DIA, PUL, DAY, MONTH, YEAR, HOUR, TAGS) VALUES(\"");
        sb.append(strArr[4]);
        sb.append("\", \"");
        sb.append(strArr[0]);
        sb.append("\", \"");
        sb.append(strArr[1]);
        sb.append("\", \"");
        sb.append(strArr[2]);
        sb.append("\", \"");
        sb.append(strArr[3]);
        sb.append("\",");
        sb.append(strArr[6]);
        sb.append(",");
        sb.append(strArr[7]);
        sb.append(",");
        sb.append(strArr[8]);
        sb.append(", \"");
        sb.append(strArr[9]);
        sb.append("\", \"");
        sb.append(strArr[5]);
        sb.append("\");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    public static ArrayList<String[]> zreDat(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT ID, DATE, SYS, DIA, PUL, TAGS FROM map_info ORDER BY id DESC;", null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(new String[]{rawQuery.getString(1), rawQuery.getString(2), rawQuery.getString(3), rawQuery.getString(4), rawQuery.getString(0), rawQuery.getString(5)});
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public static ArrayList<String[]> zreDat2(SQLiteDatabase sQLiteDatabase, int i, int i2, int i3) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM map_info WHERE DAY = ");
        sb.append(i);
        sb.append(" AND MONTH = ");
        sb.append(i2);
        sb.append(" AND YEAR = ");
        sb.append(i3);
        sb.append(" ORDER BY id ASC;");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(new String[]{rawQuery.getString(1), rawQuery.getString(2), rawQuery.getString(3), rawQuery.getString(4), rawQuery.getString(8)});
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public static ArrayList<String[]> zreDat2M(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM map_info WHERE MONTH = ");
        sb.append(i);
        sb.append(" AND YEAR = ");
        sb.append(i2);
        sb.append(" ORDER BY id ASC;");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(new String[]{rawQuery.getString(1), rawQuery.getString(2), rawQuery.getString(3), rawQuery.getString(4), rawQuery.getString(5)});
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public static ArrayList<String[]> zreDat2Y(SQLiteDatabase sQLiteDatabase, int i) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM map_info WHERE YEAR = ");
        sb.append(i);
        sb.append(" ORDER BY id ASC;");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(new String[]{rawQuery.getString(1), rawQuery.getString(2), rawQuery.getString(3), rawQuery.getString(4), rawQuery.getString(6)});
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public static int zregMI(SQLiteDatabase sQLiteDatabase) {
        int i;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT id FROM map_info ORDER BY id DESC;", null);
        try {
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
        } catch (Exception unused) {
            i = -1;
        }
        rawQuery.close();
        return i;
    }

    public static ArrayList<String[]> zreDat22(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM map_info ORDER BY id ASC;", null);
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(new String[]{rawQuery.getString(1), rawQuery.getString(2), rawQuery.getString(3), rawQuery.getString(4), rawQuery.getString(5)});
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }

    public static int[] avgsdp(SQLiteDatabase sQLiteDatabase) {
        int[] iArr = new int[3];
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT SUM(sys), SUM(dia), SUM(pul), COUNT(sys), COUNT(dia), COUNT(pul) FROM map_info;", null);
        try {
            rawQuery.moveToFirst();
            iArr[0] = rawQuery.getInt(0) / rawQuery.getInt(3);
            iArr[1] = rawQuery.getInt(1) / rawQuery.getInt(4);
            iArr[2] = rawQuery.getInt(2) / rawQuery.getInt(5);
        } catch (Exception unused) {
        }
        rawQuery.close();
        return iArr;
    }

    public static ArrayList<String> tagslist(SQLiteDatabase sQLiteDatabase) {
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT tags FROM map_info;", null);
            HashMap hashMap = new HashMap();
            rawQuery.moveToFirst();
            while (!rawQuery.isAfterLast()) {
                String[] split = rawQuery.getString(0).split(",");
                for (String trim : split) {
                    String trim2 = trim.trim();
                    int i = 1;
                    if (hashMap.get(trim2) != null) {
                        i = 1 + ((Integer) hashMap.get(trim2)).intValue();
                    }
                    if (!trim2.equals("")) {
                        hashMap.put(trim2, Integer.valueOf(i));
                    }
                }
                rawQuery.moveToNext();
            }
            rawQuery.close();
            return hmSort(hashMap);
//            return null;
        } catch (Exception unused) {
            return new ArrayList<>();
        }
    }


    public static ArrayList<String> hmSort(HashMap<String, Integer> hashMap) {
        LinkedList<Entry> linkedList = new LinkedList<Entry>(hashMap.entrySet());
       /* Collections.sort(linkedList, (Comparator<? super Entry>) new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> entry, Entry<String, Integer> entry2) {
                return ((Integer) entry2.getValue()).compareTo((Integer) entry.getValue());
            }
        });*/
        ArrayList<String> arrayList = new ArrayList<>();
        for (Entry key : linkedList) {
            arrayList.add(String.valueOf(key.getKey()));
        }
        return arrayList;
    }




    public static ArrayList<String[]> csvData(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT sys, dia, pul, day, month, year, date FROM map_info;", null);
        arrayList.add(new String[]{"Systolic", "Diastolic", "Pulse", "Day", "Month", "Year", "Date"});
        rawQuery.moveToFirst();
        while (!rawQuery.isAfterLast()) {
            arrayList.add(new String[]{rawQuery.getString(0), rawQuery.getString(1), rawQuery.getString(2), rawQuery.getString(3), rawQuery.getString(4), rawQuery.getString(5), rawQuery.getString(6)});
            rawQuery.moveToNext();
        }
        rawQuery.close();
        return arrayList;
    }
}
