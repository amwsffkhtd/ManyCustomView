package per.matt.android.manycostomview;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import per.matt.android.manycostomview.activities.BackGroundActivity;
import per.matt.android.manycostomview.activities.BubbleSeekbarActivity;
import per.matt.android.manycostomview.activities.DialogActivity;
import per.matt.android.manycostomview.activities.LoadingViewsActivity;
import per.matt.android.manycostomview.activities.ShapeViewsActivity;
import per.matt.android.manycostomview.activities.SwitchButtonActivity;
import per.matt.android.manycostomview.activities.ToastActivity;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private Button btn_common_background;
    private Button btn_loadingviews;
    private Button btn_bubble_seekbar;
    private Button  btn_toast;
    private Button  btn_dialog;
    private Button  btn_switch_button;
    private Button  btn_shape_views;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;

        btn_common_background = findViewById(R.id.btn_common_background);
        btn_common_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BackGroundActivity.class);
                startActivity(intent);
            }
        });

        btn_loadingviews = findViewById(R.id.btn_loadingviews);
        btn_loadingviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LoadingViewsActivity.class);
                startActivity(intent);
            }
        });

        btn_bubble_seekbar = findViewById(R.id.btn_bubble_seekbar);
        btn_bubble_seekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BubbleSeekbarActivity.class);
                startActivity(intent);
            }
        });

        btn_toast = findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ToastActivity.class);
                startActivity(intent);
            }
        });
        btn_dialog = findViewById(R.id.btn_dialog);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DialogActivity.class);
                startActivity(intent);
            }
        });
        btn_switch_button= findViewById(R.id.btn_switch_button);
        btn_switch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SwitchButtonActivity.class);
                startActivity(intent);
            }
        });

        btn_shape_views= findViewById(R.id.btn_shape_views);
        btn_shape_views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ShapeViewsActivity.class);
                startActivity(intent);
            }
        });

    }
}
