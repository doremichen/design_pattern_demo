/**
 * Description: This class is the start activity of composite pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/09
 */
package com.adam.app.design.pattern.demo.composite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.composite.tree.FileLeaf;
import com.adam.app.design.pattern.demo.composite.tree.FolderComposite;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoCompositeStartBinding;

public class DemoCompositeStart extends AppCompatActivity {

    // view binding
    private ActivityDemoCompositeStartBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoCompositeStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        // set build structure button click listener
        mBinding.btnBuildStructure.setOnClickListener(v -> {
            // runDemo
            runDemo();
        });

        // set back to main list button click listener
        mBinding.btnBackToMainList.setOnClickListener(v -> {
            // back to main activity
            Util.backToMainActivity(this);
        });
    }

    private void runDemo() {
        // FolderComposite: root
        FolderComposite root = new FolderComposite("root");
        root.add(new FileLeaf("readme.txt"));
        root.add(new FileLeaf("build.gradle"));

        FolderComposite srcFolder = new FolderComposite("src");
        srcFolder.add(new FileLeaf("MainActivity.java"));
        srcFolder.add(new FileLeaf("Utils.java"));

        FolderComposite resFolder = new FolderComposite("res");
        resFolder.add(new FileLeaf("layout.xml"));
        resFolder.add(new FileLeaf("strings.xml"));

        root.add(srcFolder);
        root.add(resFolder);

        // result
        mBinding.txtResult.setText(root.display(""));

    }
}