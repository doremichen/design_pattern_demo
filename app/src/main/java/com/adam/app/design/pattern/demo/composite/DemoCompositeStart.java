/*
 * Copyright (c) 2026 Adam Chen
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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
        mBinding.scrollResult.setText(root.display(""));

    }
}