package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import per.matt.android.manycostomview.R;
import xyz.bboylin.universialtoast.UniversalToast;

public class ToastActivity extends Activity {

    private Context mContext;

    private Button btn_universal;
    private Button btn_success;
    private Button btn_warning;
    private Button btn_error;
    private Button btn_emphasize_success;
    private Button btn_emphasize_warning;
    private Button btn_emphasize_error;
    private Button  btn_clickable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_toast);

        btn_universal = findViewById(R.id.btn_universal);
        btn_universal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversalToast.makeText(mContext,"Universal", UniversalToast.LENGTH_SHORT).show();
            }
        });

        btn_success = findViewById(R.id.btn_success);
        btn_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversalToast.makeText(mContext,"关注成功", UniversalToast.LENGTH_SHORT).showSuccess();
            }
        });
        btn_warning = findViewById(R.id.btn_warning);
        btn_warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversalToast.makeText(mContext,"请先登录", UniversalToast.LENGTH_SHORT).showWarning();
            }
        });
        btn_error = findViewById(R.id.btn_error);
        btn_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversalToast.makeText(mContext,"密码错误", UniversalToast.LENGTH_SHORT).showError();
            }
        });

        btn_emphasize_success = findViewById(R.id.btn_emphasize_success);
        btn_emphasize_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversalToast.makeText(mContext,"关注成功", UniversalToast.LENGTH_SHORT,UniversalToast.EMPHASIZE).showSuccess();
            }
        });
        btn_emphasize_warning = findViewById(R.id.btn_emphasize_warning);
        btn_emphasize_warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversalToast.makeText(mContext,"请先登录", UniversalToast.LENGTH_SHORT,UniversalToast.EMPHASIZE).showWarning();
            }
        });
        btn_emphasize_error = findViewById(R.id.btn_emphasize_error);
        btn_emphasize_error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversalToast.makeText(mContext,"密码错误", UniversalToast.LENGTH_SHORT,UniversalToast.EMPHASIZE).showError();
            }
        });

        btn_clickable = findViewById(R.id.btn_clickable);
        btn_clickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UniversalToast.makeText(mContext,"密码错误", UniversalToast.LENGTH_SHORT,UniversalToast.CLICKABLE)
//                        .setClickCallback("查看",R.drawable.ic_x, new View.OnClickListener()
//                        R.drawable.ic_x还是会被向右的三角形覆盖
                        .setClickCallback("查看", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                UniversalToast.makeText(mContext,"你密码都错了还看个毛线", UniversalToast.LENGTH_SHORT).show();
                            }
                        })
                        .setLeftIconRes(R.drawable.ic_x_1)
                        .setBackground(getDrawable(R.drawable.border_solid_color))
                        .show();
            }
        });
    }
}
