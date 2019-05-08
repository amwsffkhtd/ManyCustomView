package per.matt.android.manycostomview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.bean.Group;
import per.matt.android.manycostomview.bean.GroupSuspend;
import per.matt.android.manycostomview.bean.User;


/**
 * Created by matth on 2018/7/31.
 */

public class GroupSuspendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<GroupSuspend> mList;


    public GroupSuspendAdapter(List<Group> list) {
        this.mList = convertGroupSuspend(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder limitViewHolder = null;
        if(viewType==GroupSuspend.HEAD_TYPE){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_head, parent, false);
            limitViewHolder = new HeadViewHolder(view);
        }else if(viewType==GroupSuspend.CONTENT_TYPE){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title, parent, false);
            limitViewHolder = new ContentViewHolder(view);
        }
        return limitViewHolder;
    }

    public boolean isHead(int pos){
        if(mList!=null && mList.size()>=pos){
            return mList.get(pos).getType()==GroupSuspend.HEAD_TYPE;
        }else{
            return false;
        }
    }

    public String getHeadTitle(int pos){
        if(mList!=null && mList.size()>=pos){
            return mList.get(pos).getHeadTitle();
        }else{
            return "";
        }
    }
    public List<String> getHeadTitles(){
        List<String> headTitles=new ArrayList<String>();
        if(mList!=null && mList.size()>=0){
            for(GroupSuspend groupSuspend:mList){
                if(groupSuspend.getType()==GroupSuspend.HEAD_TYPE){
                    headTitles.add(groupSuspend.getTitle());
                }
            }
        }
        return headTitles;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==GroupSuspend.HEAD_TYPE){
            ((HeadViewHolder)holder).tv_title.setText(mList.get(position).getTitle());
        }else if(getItemViewType(position)==GroupSuspend.CONTENT_TYPE){
            ((ContentViewHolder)holder).tv_title.setText(mList.get(position).getTitle());
        }
    }


    @Override
    public int getItemViewType(int position) {
        if(mList!=null && mList.size()>0){
            return mList.get(position).getType();
        }else{
            return super.getItemViewType(position);
        }
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    private List<GroupSuspend> convertGroupSuspend(List<Group> groups){
        List<GroupSuspend> list = new ArrayList<GroupSuspend>();

        if(groups!=null){
            for(int i=0;i<groups.size();i++){
                list.add(new GroupSuspend(GroupSuspend.HEAD_TYPE,groups.get(i).getTitle(),groups.get(i).getTitle()));
                List<User> listUser = groups.get(i).getUsers();
                if(listUser!=null){
                    for(int j=0;j<listUser.size();j++){
                        list.add(new GroupSuspend(GroupSuspend.CONTENT_TYPE,listUser.get(j).getName(),groups.get(i).getTitle()));
                    }
                }
            }
        }
        return list;
    }

    static class HeadViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        public HeadViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        public ContentViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

}
