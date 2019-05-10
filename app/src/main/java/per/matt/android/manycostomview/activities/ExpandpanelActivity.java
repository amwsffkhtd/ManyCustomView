package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.florent37.expansionpanel.ExpansionLayout;

import per.matt.android.manycostomview.R;

public class ExpandpanelActivity extends AppCompatActivity {
    ExpansionLayout expansionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandpanel);

        expansionLayout = findViewById(R.id.expansionLayout);
        expansionLayout.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                if(expanded){
                    Toast.makeText(ExpandpanelActivity.this,"第一个panel打开",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ExpandpanelActivity.this,"第一个panel关闭",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
