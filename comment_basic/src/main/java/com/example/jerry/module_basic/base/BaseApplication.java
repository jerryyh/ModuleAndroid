package com.example.jerry.module_basic.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.jerry.module_basic.BuildConfig;
import com.example.jerry.module_basic.R;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.header.FlyRefreshHeader;
import com.scwang.smartrefresh.header.PhoenixHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.footer.FalsifyFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;


/**
 * @Created by TOME .
 * @时间 2018/5/14 17:20
 * @描述 ${保存全局变量设计的基本类application}
 */

public class BaseApplication extends Application{

    public static boolean IS_DEBUG = BuildConfig.DEBUG ;
    private static BaseApplication mBaseApplication ;
    //Activity管理
//    private ActivityControl mActivityControl;
//    private String BUGLY_ID = "a29fb52485" ;

    //SmartRefreshLayout 有三种方式,请参考:https://github.com/scwang90/SmartRefreshLayout
    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new PhoenixHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new BallPulseFooter(context);
            }
        });
    }

//    public ActivityControl getActivityControl() {
//        return mActivityControl;
//    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mBaseApplication = this ;
        //MultiDex分包方法 必须最先初始化
        MultiDex.install(this);
    }

    public static BaseApplication getAppContext(){
        return mBaseApplication;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Locale _UserLocale = LocaleHelper.getLanguage(this);
        //系统语言改变了应用保持之前设置的语言
//        if (_UserLocale != null) {
//            LocaleHelper.setLocale(this, _UserLocale);
//        }
//        L.i("当前语言："+_UserLocale );
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (IS_DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);      // 尽可能早，推荐在Application中初始化
//        mActivityControl = new ActivityControl();
//        //arouter路由初始化
//        RouterConfig.init(this, com.example.tome.component_base.BuildConfig.DEBUG);
//        //bugly初始化
//        initBugly();
//        //AutoLayout适配初始化
//        AutoLayoutConifg.getInstance().useDeviceSize();
//        //Stetho调试工具初始化
//        Stetho.initializeWithDefaults(this);
//
//        // 初始化Logger工具
//        Logger.addLogAdapter(new AndroidLogAdapter(){
//            @Override
//            public boolean isLoggable(int priority, String tag) {
//                return com.example.tome.component_base.BuildConfig.DEBUG;
//            }
//        });
//        L.i("当前是否为debug模式："+IS_DEBUG );
    }

//    private void initBugly() {
//        // 获取当前包名
//        String packageName = getApplicationContext().getPackageName();
//        // 获取当前进程名
//        String processName = AppUtils.getProcessName(android.os.Process.myPid());
//        // 设置是否为上报进程
//        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
//        strategy.setUploadProcess(processName == null || processName.equals(packageName));
//        CrashReport.initCrashReport(getApplicationContext(), BUGLY_ID, false, strategy);
//    }


    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        exitApp();
    }
    /**
     * 退出应用
     */
    public void exitApp() {
//        mActivityControl.finishiAll();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


    /**
     * 低内存的时候执行
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    // 程序在内存清理的时候执行
    /**
     * 程序在内存清理的时候执行
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

    }
}
