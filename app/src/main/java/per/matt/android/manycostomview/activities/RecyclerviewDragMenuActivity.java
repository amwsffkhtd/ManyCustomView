package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import per.matt.android.manycostomview.R;

public class RecyclerviewDragMenuActivity extends AppCompatActivity {

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_drag_menu);
        mContext=this;

        Button btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewSwipeDragActivity.class);
                startActivity(intent);
            }
        });
        Button btn_grid = findViewById(R.id.btn_grid);
        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewSwipeDragGridActivity.class);
                startActivity(intent);
            }
        });
        Button btn_vertical = findViewById(R.id.btn_vertical);
        btn_vertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RecyclerviewSwipeDragDefineActivity.class);
                startActivity(intent);
            }
        });

    }



}
