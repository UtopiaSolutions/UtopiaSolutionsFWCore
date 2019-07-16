package com.usf.utils.reporting;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * A class used to access the Extent Reporter
 * and set the output location of the Extent Reports
 */
public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "\\reports\\test-results.html", true);
        }
        return extent;
    }
}
