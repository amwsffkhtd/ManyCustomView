package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import per.matt.android.manycostomview.R;

public class DsPickerActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_picker);
        mContext=this;


        Button ds_advanced_usage = findViewById(R.id.ds_advanced_usage);
        ds_advanced_usage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DsPickerAdvancedActivity.class);
                startActivity(intent);
            }
        });

    }
}
