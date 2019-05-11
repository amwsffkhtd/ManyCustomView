package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import per.matt.android.manycostomview.R;

public class CaptchaSlipActivity extends AppCompatActivity {

    private Context mContext;

    private Button btn_jump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captcha_slip);
        mContext=this;

        btn_jump = findViewById(R.id.btn_jump);
        btn_jump.setText("Jump to B Activity");
        btn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,FloatWindowBActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
