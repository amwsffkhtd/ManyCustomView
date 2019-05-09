package per.matt.android.manycostomview.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.r0adkll.slidr.Slidr;

import java.util.Random;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.util.StatusBarUtil;

public class StatusbarLightDarkActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_light_dark);

        toolbar = findViewById(R.id.toolbar);
        Button btn_light = findViewById(R.id.btn_light);
        btn_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.WHITE;
                toolbar.setBackgroundColor(color);
                StatusBarUtil.setColor(StatusbarLightDarkActivity.this,color,0);
                StatusBarUtil.setLightMode(StatusbarLightDarkActivity.this);
            }
        });

        Button btn_dark = findViewById(R.id.btn_dark);
        btn_dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = getResources().getColor(R.color.colorPrimaryDark);
                toolbar.setBackgroundColor(color);
                StatusBarUtil.setColor(StatusbarLightDarkActivity.this,color,0);
                StatusBarUtil.setDarkMode(StatusbarLightDarkActivity.this);
            }
        });
    }
}
