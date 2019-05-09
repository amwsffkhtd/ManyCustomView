package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.r0adkll.slidr.Slidr;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.util.StatusBarUtil;

public class StatusbarTransparentActivity extends AppCompatActivity {

    private Context mContext;
    private TextView tv_progress;
    private SeekBar sb_change_alpha;
    private ConstraintLayout constraintlayout;
    private boolean isMonkey = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_transparent);
        mContext=this;
        //状态栏透明,实际是状态栏不见了。
        StatusBarUtil.setTransparent(StatusbarTransparentActivity.this);

        tv_progress = findViewById(R.id.tv_progress);
        tv_progress.setText("0");
        constraintlayout = findViewById(R.id.constraintlayout);
        sb_change_alpha = findViewById(R.id.sb_change_alpha);
        sb_change_alpha.setMax(255);
        sb_change_alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_progress.setText(""+i);
                //设置状态栏透明度
                StatusBarUtil.setTranslucent(StatusbarTransparentActivity.this,i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_change_alpha.setProgress(0);

        Button btn_background = findViewById(R.id.btn_background);
        btn_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isMonkey){
                    constraintlayout.setBackground(getResources().getDrawable(R.drawable.bg_girl));
                    isMonkey=false;
                }else{
                    constraintlayout.setBackground(getResources().getDrawable(R.drawable.bg_monkey));
                    isMonkey=true;
                }
            }
        });

    }
}
