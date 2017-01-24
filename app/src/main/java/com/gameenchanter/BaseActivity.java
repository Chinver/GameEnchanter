package com.gameenchanter;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by admin on 2017/1/16.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    private static final String PATH= Environment.getExternalStorageDirectory().getPath() + "/ES/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        File file = new File(PATH);
        boolean isDirectoryCreated = file.exists();
        if (!isDirectoryCreated) {//文件夹不存在
            file.mkdirs();
            Log.d(TAG, "Path= " + PATH);
        } else {//文件夹存在
            writeSDFile(PATH, df.format(new Date()), "log.txt");//写入文件夹创建时间，即APP安装时间
        }
    }

    private void writeSDFile(String path, String str, String fileName) {//写入文件
        try {
            File f = new File(path + fileName);
            if (!f.exists()) {
                FileWriter fw = new FileWriter(path + fileName);
                fw.write(str);
                FileOutputStream os = new FileOutputStream(f);
                DataOutputStream out = new DataOutputStream(os);
                out.writeShort(2);
                out.writeUTF("");
                Log.d(TAG, out.toString());
                fw.flush();
                fw.close();
                Log.d(TAG, fw.toString());
            } else {
                Log.d(TAG, f.toString() + " is already exist!");
            }
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
    }
}
