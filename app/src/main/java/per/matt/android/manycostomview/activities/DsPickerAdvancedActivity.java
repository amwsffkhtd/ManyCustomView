package per.matt.android.manycostomview.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ramotion.directselect.DSListView;

import java.util.List;

import per.matt.android.manycostomview.R;
import per.matt.android.manycostomview.adapter.AdvancedExampleCountryAdapter;
import per.matt.android.manycostomview.bean.AdvancedExampleCountryPOJO;

public class DsPickerAdvancedActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_advanced_picker);
        mContext=this;

        // Prepare dataset
        List<AdvancedExampleCountryPOJO> exampleDataSet = AdvancedExampleCountryPOJO.getExampleDataset();

        // Create adapter with our dataset
        ArrayAdapter<AdvancedExampleCountryPOJO> adapter = new AdvancedExampleCountryAdapter(
                this, R.layout.advanced_example_country_list_item, exampleDataSet);

        // Set adapter to our DSListView
        DSListView<AdvancedExampleCountryPOJO> pickerView = findViewById(R.id.ds_picker);
        pickerView.setAdapter(adapter);

    }
}
