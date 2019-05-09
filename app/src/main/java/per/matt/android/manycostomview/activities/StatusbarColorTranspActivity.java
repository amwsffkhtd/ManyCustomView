package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Random;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.util.StatusBarUtil;

public class StatusbarColorTranspActivity extends AppCompatActivity {

    private Context mContext;
    private Toolbar toolbar;
    private TextView tv_progress;
    private SeekBar sb_change_alpha;


    private int mColor;
    private int mAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_color_transp);
        mContext=this;

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Statusbar");
        tv_progress = findViewById(R.id.tv_progress);

        mColor = getResources().getColor(R.color.colorPrimaryDark);
        sb_change_alpha = findViewById(R.id.sb_change_alpha);
        sb_change_alpha.setMax(255);
        sb_change_alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_progress.setText(""+i);
                StatusBarUtil.setColor(StatusbarColorTranspActivity.this, mColor,i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_change_alpha.setProgress(StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);


        Button btn_color = findViewById(R.id.btn_color);
        btn_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                mColor = 0xff000000 | random.nextInt(0xffffff);
                toolbar.setBackgroundColor(mColor);
                StatusBarUtil.setColor(StatusbarColorTranspActivity.this, mColor);
            }
        });
    }
}
