package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import per.matt.android.manycostomview.R;

public class RecyclerviewMultiActivity extends AppCompatActivity {

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_multi);
        mContext=this;

        Button btn_multi_recyclerview = findViewById(R.id.btn_swipe_menu);
        btn_multi_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewSwipeMenuActivity.class);
                startActivity(intent);
            }
        });
        Button btn_drag = findViewById(R.id.btn_drag);
        btn_drag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewDragMenuActivity.class);
                startActivity(intent);
            }
        });
        Button btn_head_footer = findViewById(R.id.btn_head_footer);
        btn_head_footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewHeaderFooterActivity.class);
                startActivity(intent);
            }
        });
        Button btn_load = findViewById(R.id.btn_load);
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewLoadMenuActivity.class);
                startActivity(intent);
            }
        });

        Button btn_nest = findViewById(R.id.btn_nest);
        btn_nest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewNestMenuActivity.class);
                startActivity(intent);
            }
        });

    }
}
