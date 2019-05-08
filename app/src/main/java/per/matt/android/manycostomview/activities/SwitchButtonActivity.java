package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;

import com.github.zagum.switchicon.SwitchIconView;

import per.matt.android.manycostomview.R;

public class SwitchButtonActivity extends Activity {

    private Context mContext;

    SwitchIconView switch_icon1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_switch_button);

        switch_icon1 = findViewById(R.id.switch_icon1);
        switch_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_icon1.switchState();
            }
        });

    }
}
