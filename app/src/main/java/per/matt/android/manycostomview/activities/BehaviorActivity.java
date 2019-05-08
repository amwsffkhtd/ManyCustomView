package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.adapter.TitleAdapter;

public class BehaviorActivity extends Activity {

    private Context mContext;

    private BottomSheetBehavior bottomSheetBehavior;
    private BottomSheetDialog bottomSheetDialog;
    private ScrollView scrollview;
    private ScrollView scrollview1;

    //上一次的ScrollY值，为解决滑动冲突而定义
    private int lastScrollY=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_behavior);

        RecyclerView recyclerview1 = findViewById(R.id.recyclerview1);
        List<String> listTitle = new ArrayList<String>();
        for(int i=0;i<100;i++){
            listTitle.add("title"+i);
        }
        TitleAdapter adapter = new TitleAdapter(listTitle);
        recyclerview1.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerview1.setAdapter(adapter);

        bottomSheetBehavior=BottomSheetBehavior.from(findViewById(R.id.layout_bottom_sheet));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        Button btn_bottom_sheet_behavior = findViewById(R.id.btn_bottom_sheet_behavior);
        btn_bottom_sheet_behavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果这里把STATE_COLLAPSED替代成STATE_EXPANDED，则直接是全屏展开
                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
            }
        });
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
//                Log.d("vlog","i:"+i);
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
//                Log.d("vlog","v:"+v);
            }
        });

        /**
         * 不能用Scrollview代替NestedScrollview,否则会有冲突问题
         */
        Button btn_bottom_sheet_dialog_nestedscrollview = findViewById(R.id.btn_bottom_sheet_dialog_nestedscrollview);
        btn_bottom_sheet_dialog_nestedscrollview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PeekHeightBottomSheetDialog 自定义peekHeight
                bottomSheetDialog = new BottomSheetDialog(mContext,R.style.PeekHeightBottomSheetDialogStyle);
//                bottomSheetDialog = new BottomSheetDialog(mContext);
                bottomSheetDialog.setContentView(R.layout.dialog_bottom_sheet);

                bottomSheetDialog.show();
            }
        });



        Button btn_bottom_sheet_recyclerview = findViewById(R.id.btn_bottom_sheet_recyclerview);
        btn_bottom_sheet_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PeekHeightBottomSheetDialog 自定义peekHeight
                bottomSheetDialog = new BottomSheetDialog(mContext,R.style.PeekHeightBottomSheetDialogStyle);
//                bottomSheetDialog = new BottomSheetDialog(mContext);
                bottomSheetDialog.setContentView(R.layout.dialog_bottom_sheet_recyclerview);

                RecyclerView recyclerView = bottomSheetDialog.findViewById(R.id.recyclerview);
                List<String> listTitle = new ArrayList<String>();
                for(int i=0;i<100;i++){
                    listTitle.add("title"+i);
                }
                TitleAdapter adapter = new TitleAdapter(listTitle);
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                recyclerView.setAdapter(adapter);

                bottomSheetDialog.show();
            }
        });
        Button btn_appbarlayout_behavior = findViewById(R.id.btn_appbarlayout_behavior);
        btn_appbarlayout_behavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,AppbarlayoutBehaviorActivity.class);
                startActivity(intent);
            }
        });

        Button btn_collaps = findViewById(R.id.btn_collaps);
        btn_collaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,CollapsingActivity.class);
                startActivity(intent);
            }
        });
    }
}
