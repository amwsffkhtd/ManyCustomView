package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.r0adkll.slidr.Slidr;

import java.util.Random;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.util.StatusBarUtil;

public class StatusbarSwipeBackActivity extends AppCompatActivity {

    private Toolbar toolbar;


    private int mColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_swipe_back);

        /**
         * 滑动退出Activity
         * 1. 需要activity的theme有这两个属性
         * <item name="android:windowIsTranslucent">true</item>
         * <item name="android:windowBackground">@android:color/transparent</item>
         * 2. 需要给xml文件最顶层的文件设置背景颜色
         */
        Slidr.attach(this);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Statusbar");


        Button btn_color = findViewById(R.id.btn_color);
        btn_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                mColor = 0xff000000 | random.nextInt(0xffffff);
                toolbar.setBackgroundColor(mColor);
                StatusBarUtil.setColor(StatusbarSwipeBackActivity.this, mColor,0);
            }
        });
    }
}
