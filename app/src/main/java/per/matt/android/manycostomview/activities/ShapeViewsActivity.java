package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import per.matt.android.manycostomview.R;
import xyz.bboylin.universialtoast.UniversalToast;

public class ShapeViewsActivity extends Activity {

    private Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_shape_views);

    }
}
