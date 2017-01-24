package com.gameenchanter.bd;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {// 继承SQLiteOpenHelper类
    private static final String TAG = "DatabaseHelper";

    private static final int DATABASE_VERSION = 1;// 数据库版本号
    private static final String DATABASE_NAME = "game_enchanter.db";// 数据库名

    // 数据表名，一个数据库中可以有多个表
    private static final String TABLE_NAME_ES_CARD = "t_es_card";
    private static final String CREATE_TABLE_ES_CARD = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_ES_CARD + " (" +
            "id INTEGER PRIMARY KEY, " +
            "name VARCHAR(255) NOT NULL, " +
            "star INTEGER, " +
            "idol VARCHAR(80), " +
            "red INTEGER, " +
            "yellow INTEGER, " +
            "blue INTEGER " +
            ");";
    private static final String CREATE_TEMP_CARD = "ALTER TABLE " + TABLE_NAME_ES_CARD + " rename to _temp_" + TABLE_NAME_ES_CARD;
    private static final String DROP_TEMP_CARD = "drop table _temp_" + TABLE_NAME_ES_CARD;

    private static final String TABLE_NAME_ES_EVENT = "t_es_event";
    private static final String CREATE_TABLE_ES_EVENT = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_ES_EVENT + " (" +
            "id INTEGER PRIMARY KEY, " +
            "idol VARCHAR(80), " +
            "mini1 VARCHAR(255), " +
            "answer1 VARCHAR(255), " +
            "mini2 VARCHAR(255), " +
            "answer2 VARCHAR(255), " +
            "mini3 VARCHAR(255), " +
            "answer3 VARCHAR(255), " +
            "mini4 VARCHAR(255), " +
            "answer4 VARCHAR(255), " +
            "close1 VARCHAR(255), " +
            "part1 VARCHAR(255), " +
            "close2 VARCHAR(255), " +
            "part2 VARCHAR(255), " +
            "close3 VARCHAR(255), " +
            "part3 VARCHAR(255) " +
            ");";
    private static final String CREATE_TEMP_EVENT = "ALTER TABLE " + TABLE_NAME_ES_EVENT + " rename to _temp_" + TABLE_NAME_ES_EVENT;
    private static final String DROP_TEMP_EVENT = "drop table _temp_" + TABLE_NAME_ES_EVENT;


    // 构造函数，调用父类SQLiteOpenHelper的构造函数
    public DatabaseHelper(Context context, String name, CursorFactory factory,
                          int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);

    }

    public DatabaseHelper(Context context, String name, CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
        // SQLiteOpenHelper的构造函数参数：
        // context：上下文环境
        // name：数据库名字
        // factory：游标工厂（可选）
        // version：数据库模型版本号
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // 数据库实际被创建是在getWritableDatabase()或getReadableDatabase()方法调用时
        Log.d(TAG, "DatabaseHelper Constructor");
        // CursorFactory设置为null,使用系统默认的工厂类
    }

    // 继承SQLiteOpenHelper类,必须要覆写的三个方法：onCreate(),onUpgrade(),onOpen()
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 调用时间：数据库第一次创建时onCreate()方法会被调用


        // onCreate方法有一个 SQLiteDatabase对象作为参数，根据需要对这个对象填充表和初始化数据
        // 这个方法中主要完成创建数据库后对数据库的操作

        Log.d(TAG, "DatabaseHelper onCreate");

        db.execSQL(CREATE_TABLE_ES_CARD);
        db.execSQL(CREATE_TABLE_ES_EVENT);

        // 即便程序修改重新运行，只要数据库已经创建过，就不会再进入这个onCreate方法

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 调用时间：如果DATABASE_VERSION值被改为别的数,系统发现现有数据库版本不同,即会调用onUpgrade

        // onUpgrade方法的三个参数，一个 SQLiteDatabase对象，一个旧的版本号和一个新的版本号
        // 这样就可以把一个数据库从旧的模型转变到新的模型
        // 这个方法中主要完成更改数据库版本的操作

        Log.d(TAG, "DatabaseHelper onUpgrade");

//        switch (oldVersion) {
//            case 1:
//               // Version2(db);
//                break;
//            case 2:
//               // Version3(db);
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            default:
//                db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_CLOTHES);
//                onCreate(db);
//                break;
//        }

        if (oldVersion < 4) {
//            Version2(db);
        } else {
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ES_CARD);
            db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_ES_EVENT);
            onCreate(db);
        }
        // 上述做法简单来说就是，通过检查常量值来决定如何，升级时删除旧表，然后调用onCreate来创建新表
        // 一般在实际项目中是不能这么做的，正确的做法是在更新数据表结构时，还要考虑用户存放于数据库中的数据不丢失

    }

//    private void Version2(SQLiteDatabase db) {
//        //t_clothes表新增字段time
//        String INSERT_DATA = "insert into " + TABLE_NAME_CARD + " select *,'','' from _temp_" + TABLE_NAME_CARD;
//        db.execSQL(CREATE_TEMP_CLOTHES);
//        db.execSQL(CREATE_TABLE_CLOTHES);
//        db.execSQL(INSERT_DATA);
//        db.execSQL(DROP_TEMP_CLOTHES);
//    }
//

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        // 每次打开数据库之后首先被执行

        Log.d(TAG, "DatabaseHelper onOpen");
    }

}