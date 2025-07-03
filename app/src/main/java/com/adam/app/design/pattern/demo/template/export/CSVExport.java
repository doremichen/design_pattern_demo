/**
 * Description: This class is the concrete class of CSVExport. The class contains these abstract methods:
 *              openFile, writeHeader, writeData, closeFile.
 *              The class extends the abstract class AbsDataExport.
 * Author: Adam Chen
 * Date: 2025/07/03
 */
package com.adam.app.design.pattern.demo.template.export;

public class CSVExport extends AbsDataExport {

    @Override
    public String openFile() {
        return "Open CSV File";
    }

    @Override
    public String writeHeader() {
        return "Write CSV Header";
    }

    @Override
    public String writeData() {
        return "Write CSV Rows";
    }

    @Override
    public String closeFile() {
        return "Close CSV File";
    }
}
