package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import com.yanzhenjie.recyclerview.widget.DefaultItemDecoration;

import java.util.ArrayList;
import java.util.List;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.adapter.TitleAdapter;

public class RecyclerviewLoadActivity extends AppCompatActivity {

    private static final int PAGE_SIZE = 10;

    private Context mContext;
    private int pageNum=0;
    private SwipeRefreshLayout refresh_layout;
    private SwipeRecyclerView recyclerview;
    private List<String> mList;
    private TitleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_load);
        mContext=this;
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerview.addItemDecoration(new DefaultItemDecoration(Color.GRAY));
        refresh_layout = findViewById(R.id.refresh_layout);
        refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadFirstPage();
            }
        });

        /**
         * 在setAdapter之前
         */
        recyclerview.useDefaultLoadMore(); // 使用默认的加载更多的View。
        recyclerview.setLoadMoreListener(mLoadMoreListener); // 加载更多的监听。

        mAdapter=new TitleAdapter(null);
        recyclerview.setAdapter(mAdapter);

        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setText("上拉加载");

        refresh_layout.setRefreshing(true);
        loadFirstPage();
    }

    private void loadFirstPage(){
        pageNum = 0;
        recyclerview.postDelayed(new Runnable() {
            @Override
            public void run() {
                refresh_layout.setRefreshing(false);
                List<String> list = createDataList(0);
                if(mList==null){
                    mList = new ArrayList<String>();
                }else{
                    mList.clear();
                }
                mList.addAll(list);
                mAdapter.setList(mList);

                boolean dataEmpty = false;
                if (list == null || list.size() == 0) {
                    dataEmpty = true;
                }
                boolean hasMore = true;
                if (list == null || list.size() < PAGE_SIZE) {
                    hasMore = false;
                }
                /**
                 *  第一次加载数据：一定要调用这个方法，否则不会触发加载更多。
                  */
                // 第一个参数：表示此次数据是否为空，假如你请求到的list为空(== null || list.size == 0)，那么这里就要true。
                // 第二个参数：表示是否还有更多数据，根据服务器返回给你的page等信息判断是否还有更多，这样可以提供性能，如果不能判断则传true。
                recyclerview.loadMoreFinish(dataEmpty, hasMore);
            }
        },1000);
    }

    private List<String> createDataList(int pageNum) {
        if(pageNum >5){
            return new ArrayList<>();
        }
        int offSet = pageNum * PAGE_SIZE;
        List<String> dataList = new ArrayList<>();
        for (int i = offSet; i < offSet+10; i++) {
            dataList.add("第" + i + "个Item");
        }
        return dataList;
    }

    private SwipeRecyclerView.LoadMoreListener mLoadMoreListener = new SwipeRecyclerView.LoadMoreListener() {
        @Override
        public void onLoadMore() {
            Log.d("vlog","onLoadMore");
            recyclerview.postDelayed(new Runnable() {
                @Override
                public void run() {
                    pageNum +=1;
                    List<String> listAdd = createDataList(pageNum);
                    mList.addAll(listAdd);
                    mAdapter.loadMore(mList,mList.size() - listAdd.size(),listAdd.size());


                    boolean dataEmpty = false;
                    if (listAdd == null || listAdd.size() == 0) {
                        dataEmpty = true;
                    }
                    boolean hasMore = true;
                    if (listAdd == null || listAdd.size() < PAGE_SIZE) {
                        hasMore = false;
                    }
                    // 第一次加载数据：一定要调用这个方法，否则不会触发加载更多。
                    // 第一个参数：表示此次数据是否为空，假如你请求到的list为空(== null || list.size == 0)，那么这里就要true。
                    // 第二个参数：表示是否还有更多数据，根据服务器返回给你的page等信息判断是否还有更多，这样可以提供性能，如果不能判断则传true。
                    recyclerview.loadMoreFinish(dataEmpty, hasMore);
                }
            },1000);
        }
    };
}
