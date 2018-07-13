package com.example.jerry.module_basic.net.params;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;

import com.example.jerry.module_basic.util.DeviceUtil;
import com.example.jerry.module_basic.util.JsonUtil;
import com.example.jerry.module_basic.util.MD5Util;
import com.example.jerry.module_basic.util.RSAUtil;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jerry
 * Description : 通用参数工厂
 */

public class RequestMapParams implements RequestMapBuild<Map<String, String>> {
    private Map<String, String> map;
    private Gson mGson;

    public RequestMapParams() {
        map = new TreeMap<>();
    }

    @Override
    public RequestMapParams put(String key, String value) {
        if (value != null) {
            map.put(key, value);
        }
        return this;
    }

    @Override
    public RequestMapBuild<Map<String, String>> put(String key, Object value) {
        if (value != null) {
            map.put(key, getGson().toJson(value));
        }
        return this;
    }

    @Override
    public RequestMapBuild<Map<String, String>> put(String key, int value) {
        map.put(key, String.valueOf(value));
        return this;
    }

    @Override
    public RequestMapBuild<Map<String, String>> put(Map<String, String> map) {
        this.map.putAll(map);
        return this;
    }

    @Override
    public RequestMapBuild<Map<String, String>> put(@NonNull String s, @NonNull String[] arrayOf) {
        map.put(s, getGson().toJson(arrayOf));
        return this;
    }

    private Gson getGson() {
        if (mGson == null) {
            mGson = new Gson();
        }
        return mGson;
    }

    @Override
    public Map<String, String> build() {
        map.put("appId", "");
        map.put("token", "");
        map.put("imei", "");
        map.put("version", "");
        map.put("timeStamp", String.valueOf(System.currentTimeMillis()));
        try {
            Logger.json(JsonUtil.mapToJsonObj(map).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<String, String> parmsbuild(Context context) {
        String uuid = DeviceUtil.getUUID(context);
        String versionName = null;//app版本号
        try {
            versionName = DeviceUtil.getVersionName(context);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String area = "";
        //屏幕尺寸
        String screen = DeviceUtil.getScreen(context);
        //设备型号
        String deviceType = Build.MODEL;
        long timeMillis = System.currentTimeMillis();//当前时间
        String deviceVersion = Build.VERSION.RELEASE;//系统版本号
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        //设备ID
        String deviceId = tm.getDeviceId();
        String sign = MD5Util.stringToMD5(uuid + screen + deviceVersion + deviceId);
        String clientVersion = null;
        //URL编码之后的字符串
        try {
            clientVersion = URLEncoder.encode(versionName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            screen = URLEncoder.encode(screen, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            deviceType = URLEncoder.encode(deviceType, "utf-8");//设备型号，通过URLEncoder编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String st = null;
        try {
            //当前时间，通过URLEncoder编码
            st = URLEncoder.encode("" + timeMillis, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            deviceId = URLEncoder.encode(deviceId, "utf-8");//设备id，通过URLEncoder编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String osVersion = null;
        try {
            //系统版本号，通过URLEncoder编码
            osVersion = URLEncoder.encode(deviceVersion, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String body = new Gson().toJson(new HashMap<String, String>());
        String longtitude = "";
        String latitude = "";
        try {
            area = URLEncoder.encode(area, "utf-8");//位置信息，通过URLEncoder编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        uuid = RSAUtil.encrypt(context, uuid);//uuid通过rsa加密
        try {
            uuid = URLEncoder.encode(uuid, "utf-8");//uuid通过URLEncoder编码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        map.put("uuid", uuid);
        map.put("sign", sign);
        map.put("deviceType", deviceType);
        map.put("st", st);
        map.put("body", body);
        map.put("clientVersion", clientVersion);
        map.put("screen", screen);
        map.put("osVersion", osVersion);
        map.put("longtitude", "0");
        map.put("latitude", "0");
        map.put("deviceId", deviceId);
        map.put("ulongtitude", "0");
        map.put("ulatitude", "0");
        map.put("channel", "lppz");
        map.put("deviceToken", "");
        return map;
    }
}
