package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import per.matt.android.manycostomview.R;

public class StatusbarActivity extends AppCompatActivity {

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar);
        mContext=this;

        Button btn_set_color_transparency = findViewById(R.id.btn_set_color_transparency);
        btn_set_color_transparency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatusbarColorTranspActivity.class);
                startActivity(intent);
            }
        });

        Button btn_transparent = findViewById(R.id.btn_transparent);
        btn_transparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatusbarTransparentActivity.class);
                startActivity(intent);
            }
        });

        Button btn_imageview = findViewById(R.id.btn_imageview);
        btn_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatusbarImageviewActivity.class);
                startActivity(intent);
            }
        });

        Button btn_fragment = findViewById(R.id.btn_fragment);
        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatusbarUseInFragmentActivity.class);
                startActivity(intent);
            }
        });

        Button btn_swipe_back = findViewById(R.id.btn_swipe_back);
        btn_swipe_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatusbarSwipeBackActivity.class);
                startActivity(intent);
            }
        });

        Button btn_light_dark = findViewById(R.id.btn_light_dark);
        btn_light_dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatusbarLightDarkActivity.class);
                startActivity(intent);
            }
        });

        Button btn_drawerlayout = findViewById(R.id.btn_drawerlayout);
        btn_drawerlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatusbarDrawerlayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
