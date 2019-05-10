package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;

import java.util.ArrayList;
import java.util.List;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.SuspendItemDecoration;
import per.matt.android.manycostomview.adapter.GroupSuspendAdapter;
import per.matt.android.manycostomview.adapter.SkeletonTitleAdapter;
import per.matt.android.manycostomview.adapter.TitleAdapter;
import per.matt.android.manycostomview.bean.Group;
import per.matt.android.manycostomview.bean.User;

public class SkeletonRecyclerviewActivity extends AppCompatActivity {

    private Context mContext;
    private List<String> mList;
    private RecyclerView recyclerView;
    private SkeletonTitleAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_skeleton_recyclerview);

        initRecyclerview();
    }

    /**
     * init recyclerview
     */
    private void initRecyclerview(){
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new SkeletonTitleAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);

        final SkeletonScreen skeletonScreen = Skeleton.bind(recyclerView)
                .adapter(adapter)
                .shimmer(true)      // whether show shimmer animation.                      default is true
                .count(10)          // the recycler view item count.                        default is 10
                .color(R.color.transparent)       // the shimmer color.                     default is #a2878787
                .angle(20)          // the shimmer angle.                                   default is 20;
                .duration(1000)     // the shimmer animation duration.                      default is 1000;
                .frozen(false)      // whether frozen recyclerView during skeleton showing  default is true;

                .load(R.layout.item_skeleton_skeleton)
                .show(); //default count is 10

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                mList = getList();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        adapter.setList(mList);
                        skeletonScreen.hide();
                    }
                });
            }
        });
        thread.start();
    }

    private List<String> getList(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<String>();
        for(int i=0;i<50;i++){
            list.add("Title"+i);
        }
        return list;
    }
}
