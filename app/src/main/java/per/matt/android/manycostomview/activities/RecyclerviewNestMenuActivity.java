package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import per.matt.android.manycostomview.R;

public class RecyclerviewNestMenuActivity extends AppCompatActivity {

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_nest_menu);
        mContext=this;

        Button btn_cardview = findViewById(R.id.btn_cardview);
        btn_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewNestCardViewActivity.class);
                startActivity(intent);
            }
        });

        Button btn_drawerlayout = findViewById(R.id.btn_drawerlayout);
        btn_drawerlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewNestDrawerlayoutActivity.class);
                startActivity(intent);
            }
        });

    }
}
