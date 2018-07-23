package com.example.jerry.module_outsale.activity.mvp.mall;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.jerry.comment_data.d_arouter.RouterURLS;
import com.example.jerry.module_basic.base.mvp.BaseMvpActivity;
import com.example.jerry.module_outsale.R;
import com.example.jerry.module_outsale.R2;
import com.example.jerry.module_outsale.activity.mvp.book.BookFragment;
import com.example.jerry.module_outsale.activity.mvp.home.HomeFragment;
import com.example.jerry.module_outsale.activity.mvp.user.UserFragment;

import butterknife.BindView;


/**
 * Created by jerry on 2018/7/20.
 */
@Route(path = RouterURLS.MALL_MAIN)
public class HomeMainActivity extends BaseMvpActivity<HomeContract.View, HomeContract.Presenter> implements HomeContract.View, BottomNavigationBar.OnTabSelectedListener {
    @BindView(R2.id.fragment_group)
    FrameLayout fragmentGroup;
    @BindView(R2.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    private HomeFragment mHomeFragment;
    private BookFragment mBookFragment;
    private UserFragment mUserFragment;
    private Fragment mCurrentFragment;

    @Override
    protected void initTitle() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mall_activity_main;
    }

    @Override
    protected void initView() {
        InitNavigationBar();
        mBottomNavigationBar.selectTab(0);
    }

    @Override
    public HomeContract.Presenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public HomeContract.View createView() {
        return this;
    }

    private void InitNavigationBar() {
        mBottomNavigationBar.setTabSelectedListener(this);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.mall_main_home_select, "首页").setInactiveIconResource(R.drawable.mall_main_home_unselect).setActiveColorResource(R.color.mall_red_e))
                .addItem(new BottomNavigationItem(R.drawable.mall_main_discovery_select, "收藏").setInactiveIconResource(R.drawable.mall_main_discovery_unselect).setActiveColorResource(R.color.mall_red_e))
                .addItem(new BottomNavigationItem(R.drawable.mall_main_user_select, "设置").setInactiveIconResource(R.drawable.mall_main_user_unselect).setActiveColorResource(R.color.mall_red_e))
                .setFirstSelectedPosition(0)
                .initialise();
    }

    @Override
    public void onTabSelected(int position) {
        Log.d("onTabSelected", "onTabSelected: " + position);
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance("");
                }
                addFragment(R.id.fragment_group, mHomeFragment);
                break;
            case 1:
                if (mBookFragment == null) {
                    mBookFragment = BookFragment.newInstance("");
                }
                addFragment(R.id.fragment_group, mBookFragment);
                break;
            case 2:
                if (mUserFragment == null) {
                    mUserFragment = UserFragment.newInstance("");
                }
                addFragment(R.id.fragment_group, mUserFragment);
                break;
            default:
                break;
        }
    }

    /**
     * 显示fragment
     *
     * @param frameLayoutId
     * @param fragment
     */
    private void addFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment).show(fragment);
                } else {
                    transaction.show(fragment);
                }
            } else {
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment).add(frameLayoutId, fragment);
                } else {
                    transaction.add(frameLayoutId, fragment);
                }
            }
            mCurrentFragment = fragment;
            transaction.commit();
        }
    }

    @Override
    public void onTabUnselected(int position) {
        Log.d("onTabUnselected", "onTabUnselected: " + position);
    }

    @Override
    public void onTabReselected(int position) {
        Log.d("onTabReselected", "onTabReselected: " + position);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}
