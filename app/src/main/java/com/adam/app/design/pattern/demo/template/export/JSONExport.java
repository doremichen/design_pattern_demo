/**
 * Description: This class is the concrete class of JSONExport. The class contains these abstract methods:
 *              openFile, writeHeader, writeData, closeFile.
 *              The class extends the abstract class AbsDataExport.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.template.export;

public class JSONExport extends AbsDataExport {

    @Override
    public String openFile() {
        return "Open JSON File";
    }

    @Override
    public String writeHeader() {
        return "Write JSON Header";
    }

    @Override
    public String writeData() {
        return "Write JSON Rows";
    }

    @Override
    public String closeFile() {
        return "Close JSON File";
    }
}
