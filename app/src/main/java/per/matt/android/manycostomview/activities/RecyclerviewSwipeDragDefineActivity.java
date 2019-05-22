package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanzhenjie.recyclerview.OnItemMenuClickListener;
import com.yanzhenjie.recyclerview.SwipeMenu;
import com.yanzhenjie.recyclerview.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.SwipeMenuItem;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import com.yanzhenjie.recyclerview.touch.OnItemMoveListener;
import com.yanzhenjie.recyclerview.touch.OnItemMovementListener;
import com.yanzhenjie.recyclerview.touch.OnItemStateChangedListener;
import com.yanzhenjie.recyclerview.widget.DefaultItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.adapter.TitleNoLineAdapter;

public class RecyclerviewSwipeDragDefineActivity extends AppCompatActivity {

    private static final String TITLE = "Item拖拽";
    View mHeaderView;
    private Context mContext;

    private SwipeRecyclerView recyclerview;
    private List<String> mList;
    private TitleNoLineAdapter mAdapter;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_swipe_list);
        mContext=this;
        tv_title = findViewById(R.id.tv_title);
        tv_title.setText(TITLE);

        mList=createDataList();
        mAdapter=new TitleNoLineAdapter(mList);
        recyclerview = findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerview.addItemDecoration(new DefaultItemDecoration(Color.GRAY));

        /**
         * 侧滑事件绑定必须在setAdapter之前
         */
        recyclerview.setSwipeMenuCreator(swipeMenuCreator);
        recyclerview.setOnItemMenuClickListener(mMenuItemClickListener);


        recyclerview.setAdapter(mAdapter);

        /**
         * 添加HeadView
         */
        mHeaderView = getLayoutInflater().inflate(R.layout.layout_header_switch, recyclerview, false);
        recyclerview.addHeaderView(mHeaderView);
        SwitchCompat switchCompat = mHeaderView.findViewById(R.id.switch_compat);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 控制是否可以侧滑删除。
                recyclerview.setItemViewSwipeEnabled(isChecked);
            }
        });

        /**
         * 拖拽事件
         */
        recyclerview.setOnItemMoveListener(onItemMoveListener);// 监听拖拽和侧滑删除，更新UI和数据源。
        recyclerview.setOnItemStateChangedListener(mOnItemStateChangedListener); // 监听Item的手指状态，拖拽、侧滑、松开。
        recyclerview.setLongPressDragEnabled(true); // 长按拖拽，默认关闭。
        recyclerview.setItemViewSwipeEnabled(false); // 滑动删除，默认关闭。
        // 自定义拖拽控制参数。
        recyclerview.setOnItemMovementListener(mItemMovementListener);

    }

    private List<String> createDataList() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataList.add("第" + i + "个Item");
        }
        return dataList;
    }


    /**
     * Item移动参数回调监听，这里自定义Item怎样移动。
     */
    private OnItemMovementListener mItemMovementListener = new OnItemMovementListener() {
        @Override
        public int onDragFlags(RecyclerView recyclerView, RecyclerView.ViewHolder targetViewHolder) {
            int adapterPosition = targetViewHolder.getAdapterPosition();
            if (adapterPosition == 0) { // 这里让HeaderView不能拖拽。
                return OnItemMovementListener.INVALID;// 返回无效的方向。
            }

            // 真实的Position：通过ViewHolder拿到的position都需要减掉HeadView的数量。
            int position = adapterPosition - recyclerview.getHeaderCount();

            // 假如让普通Item的第一个不能拖拽。
            if (position == 0) {
                return OnItemMovementListener.INVALID;// 返回无效的方向。
            }

            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                // Grid可以上下左右拖拽。
                return OnItemMovementListener.LEFT | OnItemMovementListener.UP | OnItemMovementListener.RIGHT |
                        OnItemMovementListener.DOWN;
            } else if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager)layoutManager;

                // 横向List只能左右拖拽。
                if (linearLayoutManager.getOrientation() == LinearLayoutManager.HORIZONTAL) {
                    return (OnItemMovementListener.LEFT | OnItemMovementListener.RIGHT);
                }
                // 竖向List只能上下拖拽。
                else {
                    return OnItemMovementListener.UP | OnItemMovementListener.DOWN;
                }
            }
            return OnItemMovementListener.INVALID;// 返回无效的方向。
        }

        @Override
        public int onSwipeFlags(RecyclerView recyclerView, RecyclerView.ViewHolder targetViewHolder) {
            int adapterPosition = targetViewHolder.getAdapterPosition();
            if (adapterPosition == 0) { // 这里让HeaderView不能侧滑删除。
                return OnItemMovementListener.INVALID;// 返回无效的方向。
            }

            // 真实的Position：通过ViewHolder拿到的position都需要减掉HeadView的数量。
            int position = adapterPosition - recyclerview.getHeaderCount();

            // 假如让普通Item的第一个不能侧滑删除。
            if (position == 0) {
                return OnItemMovementListener.INVALID;// 返回无效的方向。
            }

            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                LinearLayoutManager manager = (LinearLayoutManager)layoutManager;
                // 横向Grid上下侧滑。
                if (manager.getOrientation() == LinearLayoutManager.HORIZONTAL) {
                    return ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                }
                // 竖向Grid左右侧滑。
                else {
                    return ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                }
            } else if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager manager = (LinearLayoutManager)layoutManager;
                // 横向List上下侧滑。
                if (manager.getOrientation() == LinearLayoutManager.HORIZONTAL) {
                    return OnItemMovementListener.UP | OnItemMovementListener.DOWN;
                }
                // 竖向List左右侧滑。
                else {
                    return OnItemMovementListener.LEFT | OnItemMovementListener.RIGHT;
                }
            }
            return OnItemMovementListener.INVALID;// 其它均返回无效的方向。
        }
    };

    private OnItemMoveListener onItemMoveListener = new OnItemMoveListener() {
        @Override
        public boolean onItemMove(RecyclerView.ViewHolder srcHolder, RecyclerView.ViewHolder targetHolder) {
            // 想让不同的ViewType之间可以拖拽，就是去掉这个判断。
            if (srcHolder.getItemViewType() != targetHolder.getItemViewType()) return false;

            // 添加了HeadView时，通过ViewHolder拿到的position都需要减掉HeadView的数量。
            int fromPosition = srcHolder.getAdapterPosition() - recyclerview.getHeaderCount();
            int toPosition = targetHolder.getAdapterPosition() - recyclerview.getHeaderCount();

            if (toPosition == 0) {// 保证第一个不被挤走。
                return false;
            }
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++)
                    Collections.swap(mList, i, i + 1);
            } else {
                for (int i = fromPosition; i > toPosition; i--)
                    Collections.swap(mList, i, i - 1);
            }

            mAdapter.notifyItemMoved(fromPosition, toPosition);

            return true;// 返回true表示处理了并可以换位置，返回false表示你没有处理并不能换位置。
        }

        @Override
        public void onItemDismiss(RecyclerView.ViewHolder srcHolder) {
            int position = srcHolder.getAdapterPosition() - recyclerview.getHeaderCount();
            mList.remove(position);
            mAdapter.notifyItemRemoved(position);
            Toast.makeText(RecyclerviewSwipeDragDefineActivity.this, "现在的第" + position + "条被删除。", Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * Item的拖拽/侧滑删除时，手指状态发生变化监听。
     */
    private OnItemStateChangedListener mOnItemStateChangedListener = new OnItemStateChangedListener() {
        @Override
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            if (actionState == OnItemStateChangedListener.ACTION_STATE_DRAG) {
                tv_title.setText(TITLE+"状态：拖拽");

                // 拖拽的时候背景就透明了，这里我们可以添加一个特殊背景。
                viewHolder.itemView.setBackgroundColor(
                        ContextCompat.getColor(RecyclerviewSwipeDragDefineActivity.this, R.color.white_pressed));
            } else if (actionState == OnItemStateChangedListener.ACTION_STATE_SWIPE) {
                tv_title.setText(TITLE+"状态：滑动删除");
            } else if (actionState == OnItemStateChangedListener.ACTION_STATE_IDLE) {
                tv_title.setText(TITLE+"状态：手指松开");

                // 在手松开的时候还原背景。
                ViewCompat.setBackground(viewHolder.itemView,
                        ContextCompat.getDrawable(RecyclerviewSwipeDragDefineActivity.this, R.drawable.select_white));
            }
        }
    };

    /**
     * 菜单创建器，在Item要创建菜单的时候调用。
     */
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int position) {
            int width = getResources().getDimensionPixelSize(R.dimen.dp_70);

            // 1. MATCH_PARENT 自适应高度，保持和Item一样高;
            // 2. 指定具体的高，比如80;
            // 3. WRAP_CONTENT，自身高度，不推荐;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;

            // 添加左侧的，如果不添加，则左侧不会出现菜单。
            {
                SwipeMenuItem addItem = new SwipeMenuItem(mContext).setBackground(R.drawable.selector_green)
                        .setImage(R.drawable.ic_action_add)
                        .setWidth(width)
                        .setHeight(height);
                swipeLeftMenu.addMenuItem(addItem); // 添加菜单到左侧。

                SwipeMenuItem closeItem = new SwipeMenuItem(mContext).setBackground(R.drawable.selector_red)
                        .setImage(R.drawable.ic_action_close)
                        .setWidth(width)
                        .setHeight(height);
                swipeLeftMenu.addMenuItem(closeItem); // 添加菜单到左侧。
            }

            // 添加右侧的，如果不添加，则右侧不会出现菜单。
            {
                SwipeMenuItem deleteItem = new SwipeMenuItem(mContext).setBackground(R.drawable.selector_red)
                        .setImage(R.drawable.ic_action_delete)
                        .setText("删除")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(deleteItem);// 添加菜单到右侧。

                SwipeMenuItem addItem = new SwipeMenuItem(mContext).setBackground(R.drawable.selector_green)
                        .setText("添加")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(addItem); // 添加菜单到右侧。
            }
        }
    };

    /**
     * RecyclerView的Item的Menu点击监听。
     */
    private OnItemMenuClickListener mMenuItemClickListener = new OnItemMenuClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge, int position) {
            menuBridge.closeMenu();

            int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
            int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。

            if (direction == SwipeRecyclerView.RIGHT_DIRECTION) {
                Toast.makeText(mContext, "list第" + position + "; 右侧菜单第" + menuPosition, Toast.LENGTH_SHORT)
                        .show();
            } else if (direction == SwipeRecyclerView.LEFT_DIRECTION) {
                Toast.makeText(mContext, "list第" + position + "; 左侧菜单第" + menuPosition, Toast.LENGTH_SHORT)
                        .show();
            }
        }
    };
}
