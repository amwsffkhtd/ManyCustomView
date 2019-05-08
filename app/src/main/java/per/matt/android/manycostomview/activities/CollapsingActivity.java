package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.adapter.TitleAdapter;
import xyz.bboylin.universialtoast.UniversalToast;

public class CollapsingActivity extends Activity {

    private Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        //statuebar 透明
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_collapsingtoolbarlayout);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        List<String> listTitle = new ArrayList<String>();
        for(int i=0;i<100;i++){
            listTitle.add("title"+i);
        }
        TitleAdapter adapter = new TitleAdapter(listTitle);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);
    }
}
