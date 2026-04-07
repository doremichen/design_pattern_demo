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

package com.adam.app.design.pattern.demo.builder.model;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

public class Computer {
    private String mCpu;
    private String mRam;
    private String mHdd;
    private String mGpu;

    private Computer(String cpu, String ram, String hdd, String gpu) {
        mCpu = cpu;
        mRam = ram;
        mHdd = hdd;
        mGpu = gpu;

    }

    // getComputer information
    public String getInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(R.string.cp_info_cpu))
                .append(mCpu).append("\n")
                .append(context.getString(R.string.cp_info_ram))
                .append(mRam).append("\n")
                .append(context.getString(R.string.cp_info_hdd))
                .append(mHdd).append("\n")
                .append(context.getString(R.string.cp_info_gpu))
                .append(mGpu);
        return sb.toString();

    }

    /**
     * Builder class
     */
    public static class Builder {
        private String mCpu;
        private String mRam;
        private String mHdd;
        private String mGpu;


        public Builder() {
        }

        public Builder setCpu(String cpu) {
            mCpu = cpu;
            return this;
        }

        public Builder setRam(String ram) {
            mRam = ram;
            return this;
        }

        public Builder setHdd(String hdd) {
            mHdd = hdd;
            return this;
        }

        public Builder setGpu(String gpu) {
            mGpu = gpu;
            return this;
        }

        public Computer build() {
            return new Computer(mCpu, mRam, mHdd, mGpu);
        }

    }
}
