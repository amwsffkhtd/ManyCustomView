package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

import per.matt.android.manycostomview.R;

public class DotsIndicatorActivity extends Activity {

    private Context mContext;
    ViewPager viewPager;
    private List<View> mList;
    private ViewPagerAdapter mAdapter;

    SpringDotsIndicator spring_dots_indicator;
    DotsIndicator dots_indicator;
    WormDotsIndicator worm_dots_indicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_dots_indicator);
        spring_dots_indicator = findViewById(R.id.spring_dots_indicator);
        dots_indicator = findViewById(R.id.dots_indicator);
        worm_dots_indicator = findViewById(R.id.worm_dots_indicator);

        initViewPager();
    }
    private void initViewPager(){
        mList = new ArrayList<View>();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.view_pager1,null);
        mList.add(view);
        view = inflater.inflate(R.layout.view_pager2,null);
        mList.add(view);
        view = inflater.inflate(R.layout.view_pager3,null);
        mList.add(view);
        view = inflater.inflate(R.layout.view_pager4,null);
        mList.add(view);

        mAdapter = new ViewPagerAdapter(mList);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(mAdapter);
        spring_dots_indicator.setViewPager(viewPager);
        dots_indicator.setViewPager(viewPager);
        worm_dots_indicator.setViewPager(viewPager);
    }
}
