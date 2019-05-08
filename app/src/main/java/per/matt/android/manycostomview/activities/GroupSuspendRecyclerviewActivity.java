package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.SuspendItemDecoration;
import per.matt.android.manycostomview.adapter.GroupSuspendAdapter;
import per.matt.android.manycostomview.adapter.TitleAdapter;
import per.matt.android.manycostomview.bean.Group;
import per.matt.android.manycostomview.bean.User;

public class GroupSuspendRecyclerviewActivity extends Activity {

    private Context mContext;
    private List<Group> groups;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_group_suspend_recyclerview);

        initRecyclerview();
    }

    /**
     * make fake data list;
     */
    private void initList(){
        groups = new ArrayList<Group>();

        List<User> users = new ArrayList<User>();
        User user = null;

        for(int i=0;i<12;i++){
            user = new User("A组"+i);
            users.add(user);
        }
        Group group = new Group("A组",users);
        groups.add(group);

        users = new ArrayList<User>();
        for(int i=0;i<10;i++){
            user = new User("B组"+i);
            users.add(user);
        }
        group = new Group("B组",users);
        groups.add(group);

        users = new ArrayList<User>();
        for(int i=0;i<10;i++){
            user = new User("C组"+i);
            users.add(user);
        }

        group = new Group("C组",users);
        groups.add(group);
    }

    /**
     * init recyclerview
     */
    private void initRecyclerview(){
        initList();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        GroupSuspendAdapter adapter = new GroupSuspendAdapter(groups);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.addItemDecoration(new SuspendItemDecoration(mContext));


        recyclerView.setAdapter(adapter);
    }
}
