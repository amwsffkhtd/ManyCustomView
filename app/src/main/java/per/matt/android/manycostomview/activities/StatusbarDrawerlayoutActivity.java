package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.Random;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.util.StatusBarUtil;

public class StatusbarDrawerlayoutActivity extends AppCompatActivity {

    private Context mContext;

    private Toolbar toolbar;
    private DrawerLayout drawerlayout;
    private TextView tv_progress;
    private SeekBar sb_change_alpha;
    private CheckBox chb_translucent;
    private LinearLayout mainLayout;
    private Button btn_color;

    private int mStatusBarColor;
    private int mAlpha = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_drawerlayout);
        mContext=this;

        toolbar = findViewById(R.id.toolbar);
        drawerlayout =  findViewById(R.id.drawerlayout);
        mainLayout = findViewById(R.id.main);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerlayout,toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerlayout.setDrawerListener(toggle);
        toggle.syncState();

        mStatusBarColor = getResources().getColor(R.color.colorPrimary);
        StatusBarUtil.setColorForDrawerLayout(this, drawerlayout, mStatusBarColor, mAlpha);

        tv_progress = findViewById(R.id.tv_progress);
        tv_progress.setText("0");

        sb_change_alpha = findViewById(R.id.sb_change_alpha);
        sb_change_alpha.setMax(255);
        sb_change_alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_progress.setText(""+i);
                mAlpha= i;
                StatusBarUtil.setTranslucentForDrawerLayout(StatusbarDrawerlayoutActivity.this,drawerlayout,mAlpha);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_change_alpha.setProgress(0);

        btn_color = findViewById(R.id.btn_color);
        btn_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                mStatusBarColor = 0xff000000 | random.nextInt(0xffffff);
                toolbar.setBackgroundColor(mStatusBarColor);
                StatusBarUtil.setColorForDrawerLayout(StatusbarDrawerlayoutActivity.this,drawerlayout, mStatusBarColor,mAlpha);
            }
        });

        chb_translucent = findViewById(R.id.chb_translucent);
        chb_translucent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    mainLayout.setBackground(getResources().getDrawable(R.drawable.bg_monkey));
                    toolbar.setBackgroundColor(Color.TRANSPARENT);
                    StatusBarUtil.setTranslucentForDrawerLayout(StatusbarDrawerlayoutActivity.this,drawerlayout,mAlpha);
                    btn_color.setVisibility(View.GONE);
                }else{
                    int color = getResources().getColor(R.color.colorPrimary);
                    mainLayout.setBackground(null);
                    toolbar.setBackgroundColor(color);
                    StatusBarUtil.setColorForDrawerLayout(StatusbarDrawerlayoutActivity.this,drawerlayout,color,mAlpha);
                    btn_color.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
