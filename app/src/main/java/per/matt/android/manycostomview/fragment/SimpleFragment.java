package per.matt.android.manycostomview.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import per.matt.android.manycostomview.R;

public class SimpleFragment extends Fragment {
    private TextView tv_title;
    private View fake_status_bar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragement_simple,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_title = view.findViewById(R.id.tv_title);
        fake_status_bar = view.findViewById(R.id.fake_status_bar);
    }

    public void setTvTitleBackgroundColor(@ColorInt int color) {
        tv_title.setBackgroundColor(color);
        fake_status_bar.setBackgroundColor(color);
    }
}
