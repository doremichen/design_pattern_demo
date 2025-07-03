package com.adam.app.design.pattern.demo.template;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.adam.app.design.pattern.demo.MainActivity;
import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoTemplateStartBinding;
import com.adam.app.design.pattern.demo.template.export.AbsDataExport;
import com.adam.app.design.pattern.demo.template.export.CSVExport;
import com.adam.app.design.pattern.demo.template.export.JSONExport;

public class DemoTemplateStart extends AppCompatActivity {

    // view binding
    private ActivityDemoTemplateStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoTemplateStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // build spinner array adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exporter_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBinding.spinnerExporter.setAdapter(adapter);
        // set adapter to spinner
        mBinding.spinnerExporter.setAdapter(adapter);

        // set start button listener
        mBinding.btnRunTemplate.setOnClickListener(v -> {
            runTemplate();
        });



        // set back button listener
        mBinding.btnBackToMain.setOnClickListener(v -> {
            // back to main activity
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

    }

    private void runTemplate() {
        // declare abs export data
        AbsDataExport absDataExport = null;
        // get selected exporter type
        String exporterType = mBinding.spinnerExporter.getSelectedItem().toString();
        // check exporter type
        switch (exporterType) {
            case "CSV":
                absDataExport = new CSVExport();
                break;
            case "JSON":
                absDataExport = new JSONExport();
                break;
        }

        // show result
        mBinding.txtResult.setText(absDataExport.exportData());

    }
}