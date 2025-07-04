/**
 * Description: This class is the model class of builder demo.
 * Author: Adam Chen
 * Date: 2025/07/04
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
