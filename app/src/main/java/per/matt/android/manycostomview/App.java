package per.matt.android.manycostomview;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.MoveType;
import com.yhao.floatwindow.PermissionListener;
import com.yhao.floatwindow.Screen;
import com.yhao.floatwindow.ViewStateListener;

import per.matt.android.manycostomview.activities.FloatWindowAActivity;
import per.matt.android.manycostomview.activities.FloatWindowCActivity;

public class App extends Application {

    private static final String TAG = "FloatWindow";

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());

        initFloatWindow();



    }

    private void initFloatWindow(){
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(R.drawable.ic_float_window);

        FloatWindow
                .with(getApplicationContext())
                .setView(imageView)
                .setWidth(Screen.width, 0.2f) //设置悬浮控件宽高
                .setHeight(Screen.width, 0.2f)
                .setX(Screen.width, 0.8f)  //设置控件初始位置
                .setY(Screen.height, 0.3f)
                /**
                 * MoveType.slide : 可拖动，释放后自动贴边 （默认）
                 * MoveType.back : 可拖动，释放后自动回到原位置
                 * MoveType.active : 可拖动
                 * MoveType.inactive : 不可拖动
                 */
//                .setMoveType(MoveType.slide,100,-100)
                .setMoveType(MoveType.active)
                .setMoveStyle(500, new BounceInterpolator())
                .setFilter(true, FloatWindowAActivity.class, FloatWindowCActivity.class)
                .setViewStateListener(mViewStateListener)  //监听悬浮控件状态改变
                .setPermissionListener(mPermissionListener)  //监听权限申请结果
                .setDesktopShow(true)
                .build();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "onClick", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private PermissionListener mPermissionListener = new PermissionListener() {
        @Override
        public void onSuccess() {
            Log.d(TAG, "onSuccess");
        }

        @Override
        public void onFail() {
            Log.d(TAG, "onFail");
        }
    };

    private ViewStateListener mViewStateListener = new ViewStateListener() {
        @Override
        public void onPositionUpdate(int x, int y) {
            Log.d(TAG, "onPositionUpdate: x=" + x + " y=" + y);
        }

        @Override
        public void onShow() {
            Log.d(TAG, "onShow");
        }

        @Override
        public void onHide() {
            Log.d(TAG, "onHide");
        }

        @Override
        public void onDismiss() {
            Log.d(TAG, "onDismiss");
        }

        @Override
        public void onMoveAnimStart() {
            Log.d(TAG, "onMoveAnimStart");
        }

        @Override
        public void onMoveAnimEnd() {
            Log.d(TAG, "onMoveAnimEnd");
        }

        @Override
        public void onBackToDesktop() {
            Log.d(TAG, "onBackToDesktop");
        }
    };
}
