package org.yh.library.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by yhlyl on 2017/5/15.
 * 网络工具类
 */

public class NetWorkUtils
{
    /**
     * 获取当前的网络状态  -1：没有网络  1：WIFI网络 2：wap网络3：net网络
     */
    public static final int CMNET = 3;
    public static final int CMWAP = 2;
    public static final int WIFI = 1;

    public static int getAPNType(Context context)
    {
        int netType = -1;
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo == null)
        {
            return netType;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE)
        {

            if (networkInfo.getExtraInfo().toLowerCase().equals("cmnet"))
            {
                netType = CMNET;
            } else
            {
                netType = CMWAP;
            }
        } else if (nType == ConnectivityManager.TYPE_WIFI)
        {
            netType = WIFI;
        }
        LogUtils.e("当前网络状态：", "当前网络状态是：" + networkInfo
                .getExtraInfo());
        return netType;
    }

    /**
     * 手机是否联网
     */
    public static boolean isNetworkConnected(Context context)
    {
        //6.0 之后得使用 getApplicationContext()..getSystemService(...)
        //否则会内存泄漏
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        return activeNetworkInfo.isConnected();
    }
}
