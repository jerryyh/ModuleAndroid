package com.example.jerry.module_basic.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.example.jerry.module_basic.base.BaseApplication;


/**
 * 获取一些基本信息的工具类
 * Created by 邵昱 on 2016/8/17.
 */
public class DeviceUtil {
    static String latling;
    private static boolean isNeedFresh=true;
    private static LocationManager lm;

    /**
     * 获取设备唯一标识uuid
     * @param context 上下文
     * @return 返回uuid
     */
    public static String getUUID(Context context)  {
        Context mcontext;
        String uuid ="";
        if(context==null){
            mcontext= BaseApplication.getAppContext();
        }else {
            mcontext=context;
        }
        try {
            TelephonyManager tm= (TelephonyManager) mcontext.getSystemService(Context.TELEPHONY_SERVICE);
            String serial = Build.SERIAL;//Serial Number序列号
            String deviceId = tm.getDeviceId();//设备ID
            String result=deviceId+"LPPZ"+serial+deviceId;
            uuid=MD5Util.stringToMD5(result);//唯一标识uuid
        }catch (Exception e){

        }
        return uuid;
    }



    /**
     * 生成固定的User-Agent
     * @param context 上下文
     * @return 返回userAgent
     */
    public static String getUserAgent(Context context) {
        Context mcontext;
        if(context==null){
            mcontext= BaseApplication.getAppContext();
        }else {
            mcontext=context;
        }
        String result = null;
        try {
            result = getVersionName(mcontext)+"(Android;"+ Build.VERSION.RELEASE+";"+ Build.BRAND+";"+ Build.MODEL+")";
        } catch (Exception e) {
        }
        String userAgent="BeStore/"+result;
        return userAgent;
    }

    /**
     * 获取屏幕尺寸，格式：宽x高
     * @param context
     * @return
     */
    public static String getScreen(Context context){
        Context mcontext;
        if(context==null){
            mcontext= BaseApplication.getAppContext();
        }else {
            mcontext=context;
        }
        Resources resources = mcontext.getResources();
        int widthPixels = resources.getDisplayMetrics().widthPixels;
        int heightPixels = resources.getDisplayMetrics().heightPixels;
        String screen=widthPixels+"×"+heightPixels;
        return screen;
    }

    /**
     * 获取app的版本信息
     * @param context
     * @return
     */
    public static String getVersionName(Context context) throws PackageManager.NameNotFoundException {
        Context mcontext;
        String versionName ="";
        if(context==null){
            mcontext= BaseApplication.getAppContext();
        }else {
            mcontext=context;
        }
        try {
            PackageManager packageManager = mcontext.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(mcontext.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            versionName =packageInfo.versionName;
        }catch (Exception e){

        }
        return versionName;
    }

    /**
     * 获取设备ID
     * @param context
     * @return
     */
    public static String getDeviceId(Context context){
        Context mContext;
        if(context==null){
            mContext= BaseApplication.getAppContext();
        }else {
            mContext=context;
        }
        String deviceId = null;//设备ID
        try {
            TelephonyManager tm = (TelephonyManager) mContext.getSystemService(mContext.TELEPHONY_SERVICE);
            deviceId = tm.getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceId;
    }

}
