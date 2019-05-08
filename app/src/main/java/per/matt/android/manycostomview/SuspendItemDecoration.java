package per.matt.android.manycostomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import per.matt.android.manycostomview.adapter.GroupSuspendAdapter;

public class SuspendItemDecoration extends RecyclerView.ItemDecoration {
    private Paint mTextPaint;
    private Paint mPaint;
    private Paint mNavPaint;
    private Paint.FontMetrics mFontMetrics;
    private int headHeight;
    private int contentHeight;
    private int headPos;
    private View headView;

    private final static int LEFT_DOCRATION=0;
    private final static int NAV_PADDING=10;
    private final static int NAV_TEXT_HEIGHT=80;


    public SuspendItemDecoration(Context context) {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.head_text_size));
        mFontMetrics = mTextPaint.getFontMetrics();

        mPaint = new Paint();
        mPaint.setColor(context.getResources().getColor(R.color.colorPrimary));

        mNavPaint = new Paint();
        mNavPaint.setColor(context.getResources().getColor(R.color.lightGray));

        headHeight = context.getResources().getDimensionPixelSize(R.dimen.head_height);
        contentHeight = context.getResources().getDimensionPixelSize(R.dimen.content_height);
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        GroupSuspendAdapter adapter = (GroupSuspendAdapter) parent.getAdapter();
        if (adapter != null) {
             /*
            左边的导航
             */
             if(LEFT_DOCRATION>0){
                 c.drawRect(NAV_PADDING,NAV_PADDING,LEFT_DOCRATION-NAV_PADDING,parent.getHeight()-NAV_PADDING,mNavPaint);
                 List<String> headTitles = adapter.getHeadTitles();
                 if(headTitles!=null && headTitles.size()>0){
                     for(int i = 0;i<headTitles.size();i++){
                         c.drawText(headTitles.get(i),10,NAV_TEXT_HEIGHT*i+NAV_TEXT_HEIGHT/2,mTextPaint);
                     }
                 }
             }

            /*
            悬浮的头部
             */
            //recyclerview第一个子控件，随着滚动recyclerview时不断改变。
            View firstChild = parent.getChildAt(0);
            LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();

            //recyclerview第一个子控件的position，随着滚动recyclerview时不断改变。
            int firstChildPostion = parent.getChildAdapterPosition(firstChild);
            String headTitle = adapter.getHeadTitle(firstChildPostion);

            //头部的宽度
            int headWidth = parent.getWidth();
            //头部字体相关
            float textWidth = mTextPaint.measureText(headTitle);
            float textHeight = mFontMetrics.bottom - mFontMetrics.top;
            float textOriginY = headHeight / 2 + (Math.abs(mFontMetrics.top) - textHeight / 2);


            if (adapter.isHead(firstChildPostion + headHeight / contentHeight + 1)) {
                //确定头部的position与view.
                headPos = firstChildPostion + headHeight / contentHeight + 1;
                headView = parent.getChildAt(headHeight / contentHeight + 1);
            }
            if(firstChildPostion>=headPos-(headHeight / contentHeight + 1) && firstChildPostion<headPos){
                int headViewTop = layoutManager.getDecoratedTop(headView);
                if(headViewTop<=headHeight){
                    //向上移动的头部。
                    c.drawRect(LEFT_DOCRATION, 0, headWidth, headViewTop, mPaint);
                    c.drawText(headTitle, headWidth / 2 - textWidth / 2+LEFT_DOCRATION/2, textOriginY - (headHeight - headViewTop), mTextPaint);
                    return;
                }
            }

            //固定的头部
            c.drawRect(LEFT_DOCRATION, 0, headWidth, headHeight, mPaint);
            c.drawText(headTitle, headWidth / 2 - textWidth / 2+LEFT_DOCRATION/2, textOriginY, mTextPaint);
        }

        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(LEFT_DOCRATION,0,0,0);
    }

    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
