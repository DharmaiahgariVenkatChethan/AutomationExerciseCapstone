package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class ScreenshotUtility extends BaseClass {

    public static void captureScreenshot(String fileName) {

        File src = ((TakesScreenshot)driver)
                .getScreenshotAs(OutputType.FILE);

        File dest = new File("./screenshots/" + fileName + ".png");

        try {

            FileUtils.copyFile(src, dest);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}