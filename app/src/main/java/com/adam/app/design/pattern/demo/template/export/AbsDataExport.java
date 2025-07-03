/**
 * Description: This class is the abstract class of AbsDataExport. The class contains these abstract methods:
 *              openFile, writeHeader, writeData, closeFile.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.template.export;

public abstract class AbsDataExport {

    // exportData method
    public String exportData() {
        // resultBuf: stringBuilder
        StringBuilder resultBuf = new StringBuilder();
        resultBuf.append(openFile()).append("\n")
                .append(writeHeader()).append("\n")
                .append(writeData()).append("\n")
                .append(closeFile());;

        return resultBuf.toString();
    }


    public abstract String openFile();
    public abstract String writeHeader();
    public abstract String writeData();
    public abstract String closeFile();
}
