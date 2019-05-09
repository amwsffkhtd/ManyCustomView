package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.r0adkll.slidr.Slidr;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.util.StatusBarUtil;

public class StatusbarImageviewActivity extends AppCompatActivity {

    private Context mContext;

    private TextView tv_progress;
    private SeekBar sb_change_alpha;
    private RelativeLayout view_need_offset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_imageview);
        mContext=this;

        /**
         * 滑动退出Activity
         * 1. 需要activity的theme有这两个属性
         * <item name="android:windowIsTranslucent">true</item>
         * <item name="android:windowBackground">@android:color/transparent</item>
         * 2. 需要给xml文件最顶层的文件设置背景颜色
         */
        Slidr.attach(this);

        view_need_offset = findViewById(R.id.view_need_offset);
        StatusBarUtil.setTranslucentForImageView(StatusbarImageviewActivity.this,0, view_need_offset);

        tv_progress = findViewById(R.id.tv_progress);
        tv_progress.setText("0");

        sb_change_alpha = findViewById(R.id.sb_change_alpha);
        sb_change_alpha.setMax(255);
        sb_change_alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_progress.setText(""+i);
                //设置状态栏透明度
                StatusBarUtil.setTranslucentForImageView(StatusbarImageviewActivity.this, i, view_need_offset);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_change_alpha.setProgress(0);

    }
}
