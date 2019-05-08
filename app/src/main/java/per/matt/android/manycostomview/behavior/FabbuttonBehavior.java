package per.matt.android.manycostomview.behavior;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class FabbuttonBehavior extends FloatingActionButton.Behavior {

    public FabbuttonBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child
            , @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        /**
         * 默认返回false,是不会调用onNestedScroll方法的
         */
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL ||
                super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target,
                        axes, type);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull FloatingActionButton child, @NonNull View dependency) {
        boolean flag = dependency instanceof RecyclerView;
        boolean flag1 = dependency instanceof Snackbar.SnackbarLayout;
        Log.d("vlog","flag:"+flag);
        Log.d("vlog","flag1:"+flag1);

        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        if(dyConsumed>0){
            hide(child);
        }else if(dyConsumed<0){
            show(child);
        }
    }

    private void hide(View view){
        view.setVisibility(View.INVISIBLE);
    }

    private void show(View view){
        view.setVisibility(View.VISIBLE);
    }
}
