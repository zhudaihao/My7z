package cn.wqgallery.my7z;

/**
 * 调用C方法的管理类
 */
public class ZipCode {
    static {
        System.loadLibrary("native-lib");
    }


    /**
     * 这就定义一个native方法
     * 参数 7z的命令行
     */
    public native static int exec(String cmd);



}
