package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.adapter.TitleAdapter;
import xyz.bboylin.universialtoast.UniversalToast;

//https://www.jianshu.com/p/488283f74e69
public class AppbarlayoutBehaviorActivity extends Activity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_appbarlayout_behavior);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<String> listTitle = new ArrayList<String>();
        for(int i=0;i<100;i++){
            listTitle.add("title"+i);
        }
        TitleAdapter adapter = new TitleAdapter(listTitle);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);


        TextView textView = findViewById(R.id.tv_title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.fab_add), "Show The Snackbar", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
