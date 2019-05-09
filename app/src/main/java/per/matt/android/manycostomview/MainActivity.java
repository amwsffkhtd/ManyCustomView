package per.matt.android.manycostomview;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import per.matt.android.manycostomview.activities.BackGroundActivity;
import per.matt.android.manycostomview.activities.BehaviorActivity;
import per.matt.android.manycostomview.activities.BubbleSeekbarActivity;
import per.matt.android.manycostomview.activities.DialogActivity;
import per.matt.android.manycostomview.activities.DotsIndicatorActivity;
import per.matt.android.manycostomview.activities.LoadingViewsActivity;
import per.matt.android.manycostomview.activities.PopupWindowActivity;
import per.matt.android.manycostomview.activities.RecyclerviewActivity;
import per.matt.android.manycostomview.activities.ShapeViewsActivity;
import per.matt.android.manycostomview.activities.StatusbarActivity;
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
    private Button  btn_dots_indicator;
    private Button  btn_behavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;


        Button btn_test = findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button btn_statusbar = findViewById(R.id.btn_statusbar);
        btn_statusbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, StatusbarActivity.class);
                startActivity(intent);
            }
        });

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

        btn_dots_indicator= findViewById(R.id.btn_dots_indicator);
        btn_dots_indicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DotsIndicatorActivity.class);
                startActivity(intent);
            }
        });

        btn_behavior= findViewById(R.id.btn_behavior);
        btn_behavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BehaviorActivity.class);
                startActivity(intent);
            }
        });

        Button btn_recyclerview= findViewById(R.id.btn_recyclerview);
        btn_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewActivity.class);
                startActivity(intent);
            }
        });

        Button btn_popupwindow= findViewById(R.id.btn_popupwindow);
        btn_popupwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PopupWindowActivity.class);
                startActivity(intent);
            }
        });

    }
}
