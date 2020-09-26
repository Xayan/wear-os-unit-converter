package pl.xayan.wearos.unitconverter;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;

public class MainActivity extends WearableActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextView = (TextView) findViewBy?Id(R.id.text);
    }

    public void changeConversionType(View view) {

    }
}
