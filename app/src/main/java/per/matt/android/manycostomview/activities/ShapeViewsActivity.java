package per.matt.android.manycostomview.activities;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.github.florent37.shapeofview.manager.ClipPathManager;
import com.github.florent37.shapeofview.shapes.RoundRectView;

import per.matt.android.manycostomview.R;

public class ShapeViewsActivity extends Activity {

    private Context mContext;
    RoundRectView roundRectView;
    Button btn_roundRectView;
    Button btn_roundRectView1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_shape_views);

        roundRectView = findViewById(R.id.roundRectView);

        btn_roundRectView1 = findViewById(R.id.btn_roundRectView1);
        btn_roundRectView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathAnim();
            }
        });

        btn_roundRectView = findViewById(R.id.btn_roundRectView);
        btn_roundRectView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roundRectViewAnim();
            }
        });
    }

    private void pathAnim(){
        roundRectView.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
            @Override
            public Path createClipPath(int width, int height) {
                final Path path = new Path();
                //通过path来对view的内容进行裁剪。
                //eg: triangle
                path.moveTo(0, 0);
                path.lineTo(0.5f * width, height);
                path.lineTo(width, 0);
                path.close();
                return path;
            }

            @Override
            public boolean requiresBitmap() {
                return false;
            }
        });


    }

    private void roundRectViewAnim(){
        float cornerFloat =dip2px(mContext,10);
        ValueAnimator animator = ValueAnimator.ofFloat(cornerFloat,200f,cornerFloat);
        animator.setDuration(500);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float)valueAnimator.getAnimatedValue();
                roundRectView.setBottomLeftRadius(value);
            }
        });
        animator.start();
    }
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
