package pl.xayan.wearos.unitconverter.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import lombok.val;
import pl.xayan.wearos.unitconverter.R;
import pl.xayan.wearos.unitconverter.converter.Converter;
import pl.xayan.wearos.unitconverter.converter.WeightConverter;
import pl.xayan.wearos.unitconverter.unit.Unit;

public class MainActivity extends WearableActivity {
    private final Map<String, String> preferences = new HashMap<>();

    private Converter converter = new WeightConverter();

    private Unit fromUnit, toUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpListeners();
        loadPreferences();
        updateResult();
        updateUI();
    }

    protected void loadPreferences() {
        SharedPreferences sharedPref =
                getApplicationContext().getSharedPreferences(
                        getString(R.string.preference_file_key),
                        Context.MODE_PRIVATE);

        if(sharedPref.contains("converter")) {

            if(sharedPref.contains("fromUnit")) {
                fromUnit = converter.getUnitByName(sharedPref.getString("fromUnit", ""));
            } else {
                fromUnit = converter.getDefaultFromUnit();
            }

            if(sharedPref.contains("toUnit")) {
                toUnit = converter.getUnitByName(sharedPref.getString("toUnit", ""));
            } else {
                toUnit = converter.getDefaultToUnit();
            }
        } else {
            converter = new WeightConverter();
            fromUnit = converter.getDefaultFromUnit();
            toUnit = converter.getDefaultToUnit();
        }
    }

    protected void savePreferences() {

    }

    protected void updateUI() {
        val converterButton = (Button) findViewById(R.id.conversion_type);
        val unitFromButton = (Button) findViewById(R.id.convert_from_unit);
        val unitToButton = (Button) findViewById(R.id.convert_to_unit);

        converterButton.setText(converter.getConfiguration().name());
        unitFromButton.setText(fromUnit.getAbbreviation());
        unitToButton.setText(toUnit.getAbbreviation());
    }

    protected void setUpListeners() {
        val convertFromInput = (EditText) findViewById(R.id.convert_from_input);

        convertFromInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateResult();
            }
        });
    }

    public void changeConversionType(View view) {
        updateResult();
    }

    public void swapUnits(View view) {
        val tmp = fromUnit;

        fromUnit = toUnit;
        toUnit = tmp;

        updateResult();
        updateUI();
    }

    protected String formatNumber(String number) {
        return formatNumber(Double.valueOf(number));
    }

    protected String formatNumber(Number number) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(12);

        return numberFormat.format(number);
    }

    protected void updateResult() {
        val convertFromInput = (EditText) findViewById(R.id.convert_from_input);
        val convertToInput = (TextView) findViewById(R.id.convert_to_input);

        try {
            val inputNumber = Double.valueOf(convertFromInput.getText().toString());
            val result = converter.convert(fromUnit, inputNumber, toUnit);

            convertToInput.setText(formatNumber(result));
        } catch (NumberFormatException ignored) {
            convertToInput.setText("ERR");
        }
    }

    public void changeFromUnit(View view) {


        updateResult();
    }

    public void changeToUnit(View view) {

        updateResult();
    }
}
