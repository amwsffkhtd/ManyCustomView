package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.cardslider.CardSliderLayoutManager;
import com.ramotion.cardslider.CardSnapHelper;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.adapter.SliderAdapter;

public class CardSliderActivity extends AppCompatActivity {

    private Context mContext;
    int currentPos = 0;
    private final int[] pics = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5};

    private final SliderAdapter sliderAdapter = new SliderAdapter(pics, 20, new OnCardClickListener());
    private CardSliderLayoutManager layoutManger;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardslider);
        mContext=this;

        initRecyclerView();
    }


    private void initRecyclerView() {
        recyclerView =findViewById(R.id.recycler_view);
        recyclerView.setAdapter(sliderAdapter);
        recyclerView.setHasFixedSize(true);
        layoutManger = (CardSliderLayoutManager) recyclerView.getLayoutManager();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    final int pos = layoutManger.getActiveCardPosition();
                    if(pos==currentPos){
                        return;
                    }
                    Log.d("vlog","SCROLL_STATE_IDLE pos:"+pos);

//                    Toast.makeText(mContext,"Position:"+pos,Toast.LENGTH_SHORT).show();
                    currentPos = pos;
                }
            }
        });
        new CardSnapHelper().attachToRecyclerView(recyclerView);

//        recyclerView.scrollToPosition(5);
    }



    private class OnCardClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

        }
    }
}
