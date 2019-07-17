package com.usf.utils.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    private static  ExtentReports extent;
    private static final String FILE_NAME = "test-results.html";
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String FILE_PATH = System.getProperty("user.dir") + FILE_SEPARATOR + "reports";
    private static final String FILE_LOCATION =  FILE_PATH + FILE_SEPARATOR + FILE_NAME;


    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(FILE_PATH);

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(FILE_NAME);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(FILE_NAME);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // Set environment details
//        extent.setSystemInfo("OS", "Windows");
//        extent.setSystemInfo("AUT", "QA");

        return extent;
    }

    //Create the report path
    private static String getReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return FILE_LOCATION;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
        return FILE_LOCATION;
    }

}