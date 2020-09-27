package pl.xayan.wearos.unitconverter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import pl.xayan.wearos.unitconverter.converter.Converter;
import pl.xayan.wearos.unitconverter.converter.WeightConverter;

public class MainActivity extends WearableActivity {
    private final Map<String, String> preferences = new HashMap<>();

    private Converter converter;

    public MainActivity() {
        super();

        this.loadPreferences();
        this.converter = new WeightConverter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextView = (TextView) findViewBy?Id(R.id.text);
    }

    protected void loadPreferences() {
        SharedPreferences prefs = getSharedPreferences("converter_settings", MODE_PRIVATE);


    }

    public void changeConversionType(View view) {


        updateResult();
    }

    public void swapUnits() {

    }

    protected void updateResult() {
        converter.convert(null, null, null);
    }
}
