package per.matt.android.manycostomview.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.SparseArray;
import android.widget.Toast;

import com.xw.repo.BubbleSeekBar;

import per.matt.android.manycostomview.R;

public class BubbleSeekbarActivity extends Activity {

    private Context mContext;

    private BubbleSeekBar bubbleSeekBar1;
    private BubbleSeekBar bubbleSeekBar2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_seekbar);
        mContext = this;

        bubbleSeekBar1=findViewById(R.id.bubbleSeekBar1);
        bubbleSeekBar2=findViewById(R.id.bubbleSeekBar2);

        bubbleSeekBar1.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
//                Log.d("vlog","onProgressChanged-progress:"+progress);
//                Log.d("vlog","onProgressChanged-fromUser:"+fromUser);
            }

            @Override
            public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
                Toast.makeText(mContext,"onProgressChanged-progress:"+progress,Toast.LENGTH_SHORT).show();
//                Log.d("vlog","getProgressOnActionUp-progress:"+progress);
            }

            @Override
            public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {
                /*
                getProgressOnFinally只有在bsb_auto_adjust_section_mark为true时才被触发。
                 */
//                Log.d("vlog","getProgressOnFinally-progress:"+progress);
//                Log.d("vlog","getProgressOnFinally-fromUser:"+fromUser);
            }
        });


        /**
         * 重写section text
         * bsb_section_text_position 必须设置为 below_section_mark
         * bsb_show_thumb_text 会默认为设置成false,以免干扰section text
         */
        bubbleSeekBar2.setCustomSectionTextArray(new BubbleSeekBar.CustomSectionTextArray() {
            @NonNull
            @Override
            public SparseArray<String> onCustomize(int sectionCount, @NonNull SparseArray<String> array) {
                array.clear();
                array.put(0,"a");
                array.put(1,"b");
                array.put(2,"c");
                array.put(3,"d");
                array.put(4,"e");
                array.put(5,"f");

                return array;
            }
        });

    }
}
