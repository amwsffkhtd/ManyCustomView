package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.popupwindow.CommonPopupWindow;
import per.matt.android.manycostomview.popupwindow.LayoutGravity;

public class PopupWindowActivity extends Activity {

    private Context mContext;

    private Button btn_origin;

    private int horiPos = -1;
    private int vertPos = -1;

    RadioButton rb_align_left;
    RadioButton rb_align_right;
    RadioButton rb_center_hori;
    RadioButton rb_to_left;
    RadioButton rb_to_right;

    RadioButton rb_align_above;
    RadioButton rb_align_bottom;
    RadioButton rb_center_vert;
    RadioButton rb_to_above;
    RadioButton rb_to_bottom;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mContext = this;


        btn_origin = findViewById(R.id.btn_origin);
        btn_origin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonPopupWindow cPopupWindow = new CommonPopupWindow(mContext,R.layout.popup_common,120
                        ,100) {
                    @Override
                    protected void initView() {

                    }

                    @Override
                    protected void initEvent() {

                    }
                };

                LayoutGravity layoutGravity = null;
                if(horiPos!=-1 && vertPos!=-1){
                    layoutGravity = new LayoutGravity(horiPos|vertPos);
                }else if(horiPos!=-1 && vertPos==-1){
                    layoutGravity = new LayoutGravity(horiPos);
                }else if(horiPos==-1 && vertPos!=-1){
                    layoutGravity = new LayoutGravity(vertPos);
                }
                if(layoutGravity!=null){
                    cPopupWindow.showBashOfAnchor(btn_origin,layoutGravity ,0,0);
                }else{
                    cPopupWindow.showAsDropDown(btn_origin,0,0);
                }
            }
        });

        rb_align_left = findViewById(R.id.rb_align_left);

        rb_align_left.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    horiPos = LayoutGravity.ALIGN_LEFT;
                }
            }
        });

        rb_align_right = findViewById(R.id.rb_align_right);
        rb_align_right.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    horiPos = LayoutGravity.ALIGN_RIGHT;
                }

            }
        });

        rb_center_hori = findViewById(R.id.rb_center_hori);
        rb_center_hori.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    horiPos = LayoutGravity.CENTER_HORI;
                }
            }
        });

        rb_to_left = findViewById(R.id.rb_to_left);
        rb_to_left.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    horiPos = LayoutGravity.TO_LEFT;
                }
            }
        });


        rb_to_right = findViewById(R.id.rb_to_right);
        rb_to_right.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    horiPos = LayoutGravity.TO_RIGHT;
                }
            }
        });


        rb_align_above = findViewById(R.id.rb_align_above);
        rb_align_above.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    vertPos = LayoutGravity.ALIGN_ABOVE;
                }
            }
        });

        rb_align_bottom = findViewById(R.id.rb_align_bottom);
        rb_align_bottom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    vertPos = LayoutGravity.ALIGN_BOTTOM;
                }
            }
        });

        rb_center_vert = findViewById(R.id.rb_center_vert);
        rb_center_vert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    vertPos = LayoutGravity.CENTER_VERT;
                }
            }
        });

        rb_to_above = findViewById(R.id.rb_to_above);
        rb_to_above.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    vertPos = LayoutGravity.TO_ABOVE;
                }
            }
        });


        rb_to_bottom = findViewById(R.id.rb_to_bottom);
        rb_to_bottom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    vertPos = LayoutGravity.TO_BOTTOM;
                }
            }
        });


        Button btn_reset_hori = findViewById(R.id.btn_reset_hori);
        btn_reset_hori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horiPos = -1;

                rb_align_left.setChecked(false);
                rb_align_right.setChecked(false);
                rb_center_hori.setChecked(false);
                rb_to_left.setChecked(false);
                rb_to_right.setChecked(false);
            }
        });
        Button btn_reset_vert = findViewById(R.id.btn_reset_vert);
        btn_reset_vert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vertPos = -1;

                rb_align_above.setChecked(false);
                rb_align_bottom.setChecked(false);
                rb_center_vert.setChecked(false);
                rb_to_above.setChecked(false);
                rb_to_bottom.setChecked(false);
            }
        });
    }
}
