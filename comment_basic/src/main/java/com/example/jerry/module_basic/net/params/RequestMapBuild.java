package com.example.jerry.module_basic.net.params;

import android.content.Context;

import java.util.Map;

/**
 * Created by jerry
 * Description :
 */

public interface RequestMapBuild<P> {

    P build();
    P parmsbuild(Context context);
    RequestMapBuild<P> put(String key, String value);

    RequestMapBuild<P> put(String key, Object value);

    RequestMapBuild<P> put(String key, int value);

    RequestMapBuild<P> put(Map<String, String> map);

    RequestMapBuild<P> put(String s, String[] arrayOf);

}
