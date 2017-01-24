package com.gameenchanter.es.service.serviceImpl;

import android.database.sqlite.SQLiteDatabase;

import com.gameenchanter.bd.DatabaseHelper;
import com.gameenchanter.es.model.Card;
import com.gameenchanter.es.service.CardServiceI;


public class CardServiceImpl extends BaseServiceImpl implements CardServiceI {
    private static final String TAG = "CardServiceImpl";
    private static final String TABLE_NAME = "t_es_card";

    private SQLiteDatabase db;

//    @Override
//    public int insertClothes(DatabaseHelper databaseHelper, Clothes clothes) {
//        Log.d(TAG, TABLE_NAME + " --> insert clothes");
//
//        db = databaseHelper.getReadableDatabase();
////        db.beginTransaction(); // 开始事务
//
//        int result = 0;
//        try {
//            if (isClothesExist(databaseHelper, clothes) > 0) {
//                result = -1;//添加失败，重复添加
//            } else {
//                ContentValues cValue = new ContentValues();
//                cValue.put("division", clothes.getDivision());
//                cValue.put("img_url", clothes.getImgUrl());
//                cValue.put("time", clothes.getTime());
//                cValue.put("name", clothes.getName());
//                cValue.put("date", clothes.getDate());
//                db.insert(TABLE_NAME, null, cValue);
//                result = 1;//添加成功
////            db.setTransactionSuccessful(); // 设置事务成功完成
//            }
//        } catch (Exception e) {
//            Log.e(TAG, e.toString());
//        } finally {
////            db.endTransaction(); // 结束事务
//            db.close();
//        }
//        return result;//添加失败，重复添加
//    }
//
//    @Override
//    public int isClothesExist(DatabaseHelper databaseHelper, Clothes clothes) {
//        Log.d(TAG, TABLE_NAME + " --> select product");
//
//        db = databaseHelper.getReadableDatabase();
//        db.beginTransaction(); // 开始事务
//        try {
//            Cursor cursor = db.query(TABLE_NAME, new String[]{"id,division,img_url,time,name,date"},
//                    "name=? and date=?", new String[]{clothes.getName(), clothes.getDate()}, null, null, null, null);
//            while (cursor.moveToNext()) {
//                String name = cursor.getString(4);
//                if (StringUtils.equals(clothes.getName(), name)) {
//                    return 1;//照片已存在
//                }
//                cursor.close();
//            }
//
//            db.setTransactionSuccessful(); // 设置事务成功完成
//        } catch (Exception e) {
//            Log.e(TAG, e.toString());
//        } finally {
//            db.endTransaction(); // 结束事务
//        }
//        return 0;
//    }
//
//    @Override
//    public List<Clothes> showClothesByDivision(DatabaseHelper databaseHelper, String division) {
//        Log.d(TAG, TABLE_NAME + " --> select clothes for show");
//
//        db = databaseHelper.getReadableDatabase();
//        db.beginTransaction(); // 开始事务
//
//        List<Clothes> clothesList = new ArrayList<>();
//        Clothes index;
//        try {
//            Cursor cursor = db.query(TABLE_NAME, new String[]{"id,img_url,division,time,name,date"},
//                    "division=?", new String[]{division}, null, null, "time DESC", null);
//            while (cursor.moveToNext()) {
//                index = new Clothes();
//                index.setId(cursor.getInt(0));
//                index.setImgUrl(cursor.getString(1));
//                index.setDivision(cursor.getString(2));
//                index.setTime(cursor.getString(3));
//                index.setName(cursor.getString(4));
//                index.setDate(cursor.getString(5));
//                Log.d(TAG, " name=" + index.getName() + " time=" + index.getTime() + " date=" + index.getDate());
//                clothesList.add(index);
//            }
//            cursor.close();
//
//            db.setTransactionSuccessful(); // 设置事务成功完成
//        } catch (Exception e) {
//            Log.e(TAG, e.toString());
//        } finally {
//            db.endTransaction(); // 结束事务
//        }
//        return clothesList;
//    }

//    @Override
//    public int deleteClothesByName(DatabaseHelper databaseHelper, String name) {
//        Log.d(TAG, TABLE_NAME + " --> delete clothes by name");
//
//        db = databaseHelper.getWritableDatabase();
//
//        try {
//            db.delete(TABLE_NAME, "name=?", new String[]{name});//物理删除
//
//            //逻辑删除
////                ContentValues cValue = new ContentValues();
////                cValue.put("status", 0);
////                db.update(TABLE_NAME, cValue, "role_code=? and status=1", new String[]{role.getCode()});
//            return 1;
//        } catch (Exception e) {
//            Log.e(TAG, e.toString());
//        } finally {
//            db.close();
//        }
//        return 0;
//    }

//    @Override
//    public int insertOrUpdateCard(DatabaseHelper databaseHelper, Card card) {
//        return 0;
//    }

    @Override
    public int insertCard(DatabaseHelper databaseHelper, Card card) {
        return 0;
    }

    @Override
    public int updateCard(DatabaseHelper databaseHelper, Card card) {
        return 0;
    }
}
