package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.listener.OnHighlightDrewListener;
import com.app.hubert.guide.listener.OnLayoutInflatedListener;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import com.app.hubert.guide.model.HighlightOptions;
import com.app.hubert.guide.model.RelativeGuide;

import per.matt.android.manycostomview.R;

public class NewbieGuideActivity extends AppCompatActivity {

    private Context mContext;

    private Button btn_member;
    private Button btn_member1;
    private Button btn_member2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbie_guide);
        mContext=this;

        btn_member = findViewById(R.id.btn_member);
        btn_member1 = findViewById(R.id.btn_member1);
        btn_member2 = findViewById(R.id.btn_member2);

        //自定义高亮布局
        HighlightOptions options = new HighlightOptions.Builder()
                .setOnHighlightDrewListener(new OnHighlightDrewListener() {
                    @Override
                    public void onHighlightDrew(Canvas canvas, RectF rectF) {
                        Paint paint = new Paint();
                        paint.setColor(Color.WHITE);
                        paint.setStyle(Paint.Style.STROKE);
                        paint.setStrokeWidth(5);
                        paint.setPathEffect(new DashPathEffect(new float[]{20, 20}, 0));
                        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2 + 30, paint);
                    }
                })
                //高亮区域点击事件
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext,"点你妹！",Toast.LENGTH_SHORT).show();
                    }
                })
                /*
                指定引导布局及其相对目标控件的位置
                这种方式是确定引导布局位置最方便的方法，不用微调，也不用考虑屏幕适配的问题
                 */
                .setRelativeGuide(new RelativeGuide(R.layout.view_guide_simple2,Gravity.RIGHT,0))
                .build();

        GuidePage page = GuidePage.newInstance().addHighLightWithOptions(btn_member2, options);


        NewbieGuide.with(NewbieGuideActivity.this)
                .setLabel("Guide1")
                .addGuidePage(GuidePage.newInstance()
                .addHighLight(btn_member)
                .setLayoutRes(R.layout.view_guide_simple))

                //可设置多个实例，针对就不同的目标控件
                .addGuidePage(GuidePage.newInstance()
                        .addHighLight(btn_member1, HighLight.Shape.CIRCLE,20)
                        //是否点击任意位置消失引导页，默认true
                        .setEverywhereCancelable(false)
                        //只有点击iv_guide才能取消Guide层
                        .setLayoutRes(R.layout.view_guide_simple1,R.id.iv_guide)
                        //通过代码确定引导布局的位置
                        .setOnLayoutInflatedListener(new OnLayoutInflatedListener() {
                            @Override
                            public void onLayoutInflated(View view, Controller controller) {
                                ImageView imageView = view.findViewById(R.id.iv_guide);

                                imageView.setTranslationX(btn_member1.getX()+btn_member1.getWidth()-20);
                                imageView.setTranslationY(btn_member1.getY()+btn_member1.getHeight()/2-20);
                            }
                        })
                )


                .addGuidePage(page
                        /*
                        在HighlightOptions里已经确定了引导布局的layout与位置，
                        所以这里但不再需要setLayoutRes(...)
                         */
//                .setLayoutRes(R.layout.view_guide_simple2)
                        //设置背景色，默认是0xb2000000
                        .setBackgroundColor(Color.parseColor("#6400FFFF"))
                )

                //次数是针对所有实例的，不能分开对每个实例设置次数，也没有这个必要
                .setShowCounts(100)//控制次数

                .show();

    }
}
