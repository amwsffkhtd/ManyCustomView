package per.matt.android.manycostomview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import per.matt.android.manycostomview.R;


/**
 * Created by matth on 2018/7/31.
 */

public class TitleDefineAdapter extends RecyclerView.Adapter<TitleDefineAdapter.ReportViewHolder> {

    private List<String> mList;

    public TitleDefineAdapter(List<String> list) {
        this.mList = list;
    }

    @Override
    public ReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_define, parent, false);
        ReportViewHolder limitViewHolder = new ReportViewHolder(view);
        return limitViewHolder;
    }

    public void setList(List<String> list){
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ReportViewHolder holder, int position) {
        holder.btn_start.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    class ReportViewHolder extends RecyclerView.ViewHolder {

        Button btn_start;
        Button left_view;
        Button right_view;

        public ReportViewHolder(View itemView) {
            super(itemView);
            btn_start = itemView.findViewById(R.id.btn_start);
            left_view = itemView.findViewById(R.id.left_view);
            right_view = itemView.findViewById(R.id.right_view);
        }
    }

}
