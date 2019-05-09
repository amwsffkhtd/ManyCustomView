package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.fragment.ImageFragment;
import per.matt.android.manycostomview.fragment.SimpleFragment;
import per.matt.android.manycostomview.util.StatusBarUtil;

public class StatusbarUseInFragmentActivity extends AppCompatActivity {

    private Context mContext;
    private ViewPager viewPager;
    private BottomNavigationBar bottom_navigation_bar;

    private List<Fragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_use_in_fragment);
        mContext=this;

        StatusBarUtil.setTranslucentForImageViewInFragment(StatusbarUseInFragmentActivity.this,0, null);
//        StatusBarUtil.setTranslucentForImageViewInFragment(StatusbarUseInFragmentActivity.this, null);

        viewPager = findViewById(R.id.viewPager);
        bottom_navigation_bar = findViewById(R.id.bottom_navigation_bar);

        bottom_navigation_bar
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite, "One"))
                .addItem(new BottomNavigationItem(R.drawable.ic_gavel, "Two"))
                .addItem(new BottomNavigationItem(R.drawable.ic_grade, "Three"))
                .addItem(new BottomNavigationItem(R.drawable.ic_group_work, "Four"))
                .initialise();

        bottom_navigation_bar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        mFragmentList = new ArrayList<Fragment>();
        mFragmentList.add(new ImageFragment());
        mFragmentList.add(new SimpleFragment());
        mFragmentList.add(new SimpleFragment());
        mFragmentList.add(new SimpleFragment());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottom_navigation_bar.selectTab(position);
                if(position!=0){
                    Random random = new Random();
                    int color = 0xff000000 | random.nextInt(0xffffff);
                    if (mFragmentList.get(position) instanceof SimpleFragment) {
                        ((SimpleFragment) mFragmentList.get(position)).setTvTitleBackgroundColor(color);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });

    }
}
