package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.cy.dialog.BaseDialog;

import per.matt.android.manycostomview.R;

public class DialogActivity extends Activity {

    private Context mContext;

    private Button btn_center;
    private Button btn_bottom;
    private Button btn_top;
    private Button btn_left;
    private Button btn_right;


    private BaseDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_dialog);


        btn_center = findViewById(R.id.btn_center);
        btn_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new BaseDialog(mContext);
                dialog.contentView(R.layout.dialog_confirm)
                        .canceledOnTouchOutside(true)
                        .show();
                dialog.findViewById(R.id.tv_confirm).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext,"确定",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        btn_bottom = findViewById(R.id.btn_bottom);
        btn_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new BaseDialog(mContext);

                dialog.contentView(R.layout.dialog_camera)
                        .layoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                        .gravity(Gravity.BOTTOM)
                        .animType(BaseDialog.AnimInType.BOTTOM)
                        .canceledOnTouchOutside(true).show();
                dialog.findViewById(R.id.tv_photo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext,"拍个照呗",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });

        btn_top = findViewById(R.id.btn_top);
        btn_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new BaseDialog(mContext);

                dialog.contentView(R.layout.dialog_camera)
                        .layoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                        //背景的暗淡程度，设置成0.9就可以看到很明显的效果
                        .dimAmount(0.5f)
                        .offset(0,50)
                        .gravity(Gravity.TOP)
                        .animType(BaseDialog.AnimInType.TOP)
                        .canceledOnTouchOutside(true).show();
                dialog.findViewById(R.id.tv_photo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext,"拍个照呗",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });

        btn_left = findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new BaseDialog(mContext);

                dialog.contentView(R.layout.dialog_left_right)
                        .layoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                        //背景的暗淡程度，设置成0.9就可以看到很明显的效果
                        .dimAmount(0.5f)
                        .offset(50,0)
                        .gravity(Gravity.LEFT)
                        .animType(BaseDialog.AnimInType.LEFT)
                        .canceledOnTouchOutside(true).show();
            }
        });
        btn_right = findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new BaseDialog(mContext);

                dialog.contentView(R.layout.dialog_left_right)
                        .layoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT))
                        //背景的暗淡程度，设置成0.9就可以看到很明显的效果
                        .dimAmount(0.5f)
//                        .offset(50,0)
                        .gravity(Gravity.RIGHT)
                        .animType(BaseDialog.AnimInType.RIGHT)
                        .canceledOnTouchOutside(true).show();
            }

        });

    }
}
