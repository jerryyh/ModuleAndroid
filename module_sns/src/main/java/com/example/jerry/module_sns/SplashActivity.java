package com.example.jerry.module_sns;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;
import com.example.jerry.module_basic.base.mvc.BaseVcActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by jerry on 2018/7/25.
 */
public class SplashActivity extends BaseVcActivity {
    @BindView(R2.id.animation_view)
    LottieAnimationView   animationView;
    private ValueAnimator animator;

    @Override
    protected int getLayoutId() {
        return R.layout.sns_activity_splash;
    }

    @Override
    protected void initTitle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    protected void initView() {
        play("lottiefiles.com - Im Thirsty.json");
        long splashTime = 10000;
        addDisposable(Observable.timer(splashTime, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> jumpToMain()));
    }

    private void play(String name) {
        animationView.cancelAnimation();
        animationView.setAnimation(name);
        animationView.loop(false);
        animator = ValueAnimator.ofFloat(0f, 0.3f, 0.5f, 1f);
        animator.setDuration(3000);
        animator.addUpdateListener(valueAnimator -> animationView.setProgress((Float) valueAnimator.getAnimatedValue()));
        animationView.playAnimation();
    }

    public void jumpToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (animationView != null) {
            animationView.cancelAnimation();
        }
    }
}
