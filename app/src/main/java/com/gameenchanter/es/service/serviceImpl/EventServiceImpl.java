package com.gameenchanter.es.service.serviceImpl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.gameenchanter.bd.DatabaseHelper;
import com.gameenchanter.es.model.Event;
import com.gameenchanter.es.service.EventServiceI;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EventServiceImpl extends BaseServiceImpl implements EventServiceI {
    private static final String TAG = "EventServiceImpl";
    private static final String TABLE_NAME = "t_es_event";

    private SQLiteDatabase db;

    @Override
    public int insertEvent(DatabaseHelper databaseHelper, Event event) {

        db = databaseHelper.getReadableDatabase();
        db.beginTransaction(); // 开始事务

        int result = 0;
        try {
            Cursor cursor = db.query(TABLE_NAME, new String[]{"id,idol,mini1,answer1,mini2,answer2,mini3,answer3," +
                            "mini4,answer4,close1,part1,close2,part2,close3,part3"},
                    "idol=?", new String[]{event.getIdol()}, null, null, null, null);
            ContentValues cValue = new ContentValues();
            cValue.put("idol", event.getIdol());
            cValue.put("mini1", event.getMini1());
            cValue.put("answer1", event.getAnswer1());
            cValue.put("mini2", event.getMini2());
            cValue.put("answer2", event.getAnswer2());
            cValue.put("mini3", event.getMini3());
            cValue.put("answer3", event.getAnswer3());
            cValue.put("mini4", event.getMini4());
            cValue.put("answer4", event.getAnswer4());
            cValue.put("close1", event.getClose1());
            cValue.put("part1", event.getPart1());
            cValue.put("close2", event.getClose2());
            cValue.put("part2", event.getPart2());
            cValue.put("close3", event.getClose3());
            cValue.put("part3", event.getPart3());
            db.insert(TABLE_NAME, null, cValue);
            result = 10;
            Log.d(TAG, TABLE_NAME + " --> insert event ");

            cursor.close();
            db.setTransactionSuccessful(); // 设置事务成功完成
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        } finally {
            db.endTransaction(); // 结束事务
        }

        return result;
    }

    @Override
    public int UpdateEvent(DatabaseHelper databaseHelper, Event event) {

        db = databaseHelper.getReadableDatabase();
        db.beginTransaction(); // 开始事务

        int count = 0;
        int result = 0;
        try {
            Cursor cursor = db.query(TABLE_NAME, new String[]{"id,idol,mini1,answer1,mini2,answer2,mini3,answer3," +
                            "mini4,answer4,close1,part1,close2,part2,close3,part3"},
                    "idol=?", new String[]{event.getIdol()}, null, null, null, null);

            while (cursor.moveToNext()) {
                String idol = cursor.getString(1);
                if (StringUtils.equals(event.getIdol(), idol)) {
                    ContentValues cValue = new ContentValues();
                    cValue.put("idol", event.getIdol());
                    cValue.put("mini1", event.getMini1());
                    cValue.put("answer1", event.getAnswer1());
                    cValue.put("mini2", event.getMini2());
                    cValue.put("answer2", event.getAnswer2());
                    cValue.put("mini3", event.getMini3());
                    cValue.put("answer3", event.getAnswer3());
                    cValue.put("mini4", event.getMini4());
                    cValue.put("answer4", event.getAnswer4());
                    cValue.put("close1", event.getClose1());
                    cValue.put("part1", event.getPart1());
                    cValue.put("close2", event.getClose2());
                    cValue.put("part2", event.getPart2());
                    cValue.put("close3", event.getClose3());
                    cValue.put("part3", event.getPart3());
                    db.update(TABLE_NAME, cValue, null, null);
                    result = 1;
                    Log.d(TAG, TABLE_NAME + " -->update event ");
                }
            }
            cursor.close();
            db.setTransactionSuccessful(); // 设置事务成功完成
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        } finally {
            db.endTransaction(); // 结束事务
        }
        return result;
    }

    @Override
    public Event selectEventByIdol(DatabaseHelper databaseHelper, String idol) {
        Log.d(TAG, TABLE_NAME + " --> select event by idol " + idol);

        db = databaseHelper.getReadableDatabase();
        db.beginTransaction(); // 开始事务

        Event index = new Event();
        try {
            Cursor cursor = db.query(TABLE_NAME, new String[]{"id,idol,mini1,answer1,mini2,answer2,mini3,answer3," +
                            "mini4,answer4,close1,part1,close2,part2,close3,part3"},
                    "idol=?", new String[]{idol}, null, null, null, null);
            while (cursor.moveToNext()) {
                index = new Event();
                index.setIdol(cursor.getString(1));
                index.setMini1(cursor.getString(2));
                index.setAnswer1(cursor.getString(3));
                index.setMini2(cursor.getString(4));
                index.setAnswer2(cursor.getString(5));
                index.setMini3(cursor.getString(6));
                index.setAnswer3(cursor.getString(7));
                index.setMini4(cursor.getString(8));
                index.setAnswer4(cursor.getString(9));
                index.setClose1(cursor.getString(10));
                index.setPart1(cursor.getString(11));
                index.setClose2(cursor.getString(12));
                index.setPart2(cursor.getString(13));
                index.setClose3(cursor.getString(14));
                index.setPart3(cursor.getString(15));
            }
            cursor.close();

            db.setTransactionSuccessful(); // 设置事务成功完成
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        } finally {
            db.endTransaction(); // 结束事务
        }
        return index;
    }

    @Override
    public List<Event> selectEvent(DatabaseHelper databaseHelper) {
        Log.d(TAG, TABLE_NAME + " --> select event");

        db = databaseHelper.getReadableDatabase();
        db.beginTransaction(); // 开始事务

        List<Event> list = new ArrayList<>();
        Event index;
        try {
            Cursor cursor = db.query(TABLE_NAME, new String[]{"id,idol,mini1,answer1,mini2,answer2,mini3,answer3," +
                            "mini4,answer4,close1,part1,close2,part2,close3,part3"},
                    null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                index = new Event();
                index.setIdol(cursor.getString(1));
                index.setMini1(cursor.getString(2));
                index.setAnswer1(cursor.getString(3));
                index.setMini2(cursor.getString(4));
                index.setAnswer2(cursor.getString(5));
                index.setMini3(cursor.getString(6));
                index.setAnswer3(cursor.getString(7));
                index.setMini4(cursor.getString(8));
                index.setAnswer4(cursor.getString(9));
                index.setClose1(cursor.getString(10));
                index.setPart1(cursor.getString(11));
                index.setClose2(cursor.getString(12));
                index.setPart2(cursor.getString(13));
                index.setClose3(cursor.getString(14));
                index.setPart3(cursor.getString(15));
                list.add(index);
            }
            cursor.close();

            db.setTransactionSuccessful(); // 设置事务成功完成
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        } finally {
            db.endTransaction(); // 结束事务
        }
        return list;
    }
}
