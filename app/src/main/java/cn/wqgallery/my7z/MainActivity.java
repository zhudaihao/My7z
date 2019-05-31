package cn.wqgallery.my7z;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //动态获取一个写权限 兼容6.0后
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (checkSelfPermission(perms[0]) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(perms, 200);
            }
        }


    }


    /**
     * 压缩
     * 7zr a  [输出文件] [待压缩文件/目录] -mx=9
     * 7zr a /sdcard/7-Zip.7z /sdcard/7-Zip -mx=9
     *
     * 注意我们使用的7zx（在源码中还有7z  7za 看你导的库是的什么类型的库）
     * @param view
     */
    public void pack(View view) {
        //动态库 使用7Z压缩 压缩
        File src = new File(Environment.getExternalStorageDirectory(), "7-Zip");//被压缩文件
        File out = new File(Environment.getExternalStorageDirectory(), "7-Zip.7z");//压缩后的文件
        //调用C方法
        int result = ZipCode.exec("7zr a " + out.getAbsolutePath() + " " + src.getAbsolutePath() + " -mx=9");
        Log.e(TAG, "ZipCode.exec: "+result);
    }

    /**
     * 解压
     * 7zr x [压缩文件]  -o[输出目录]
     *
     * 注意我们使用的7zx（在源码中还有7z  7za 看你导的库是的什么类型的库）
     * @param view
     */
    public void unpack(View view) {
        //动态库 使用7Z压缩 压缩
        File out = new File(Environment.getExternalStorageDirectory(), "7-Zip-new");//被解压后的文件
        File src = new File(Environment.getExternalStorageDirectory(), "7-Zip.7z");//被解压的文件
        //调用C方法
        int result = ZipCode.exec("7zr x " + src.getAbsolutePath() + " -o" + out.getAbsolutePath() );
        Log.e(TAG, "ZipCode.exec: "+result);
    }


}
