package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.yanzhenjie.recyclerview.OnItemMenuClickListener;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

import java.util.ArrayList;
import java.util.List;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.adapter.TitleAdapter;

public class RecyclerviewHeaderFooterActivity extends AppCompatActivity {

    private Context mContext;

    private SwipeRecyclerView recyclerview;
    private List<String> mList;
    private TitleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_swipe_list);
        mContext=this;
        mList=createDataList();
        mAdapter=new TitleAdapter(mList);
        recyclerview = findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));



        recyclerview.setAdapter(mAdapter);


        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setText("Header和Footer");

        // HeaderView。
        View headerView = getLayoutInflater().inflate(R.layout.layout_header, recyclerview, false);
        headerView.findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "HeaderView", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerview.addHeaderView(headerView);

        // FooterView。
        View footerView = getLayoutInflater().inflate(R.layout.layout_footer, recyclerview, false);
        footerView.findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "FooterView", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerview.addFooterView(footerView);
    }

    private List<String> createDataList() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataList.add("第" + i + "个Item");
        }
        return dataList;
    }

}
