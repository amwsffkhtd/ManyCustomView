package per.matt.android.manycostomview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import per.matt.android.manycostomview.R;


/**
 * Created by matth on 2018/7/31.
 */

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ReportViewHolder> {

    private List<String> mList;

    public TitleAdapter(List<String> list) {
        this.mList = list;
    }

    @Override
    public ReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title, parent, false);
        ReportViewHolder limitViewHolder = new ReportViewHolder(view);
        return limitViewHolder;
    }

    public void setList(List<String> list){
        this.mList = list;
        notifyDataSetChanged();
    }
    public void loadMore(List<String> list, int posStart, int size){
        this.mList=list;
        notifyItemRangeInserted(posStart,size);
    }

    @Override
    public void onBindViewHolder(final ReportViewHolder holder, int position) {
        holder.tv_title.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    class ReportViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title;

        public ReportViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

}
