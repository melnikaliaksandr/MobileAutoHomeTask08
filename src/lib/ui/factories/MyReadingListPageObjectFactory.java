package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.MyReadingListPageObject;
import lib.ui.android.AndroidMyReadingListPageObject;
import lib.ui.ios.IOSMyReadingListPageObject;

public class MyReadingListPageObjectFactory {

    public static MyReadingListPageObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyReadingListPageObject(driver);
        } else {
            return new IOSMyReadingListPageObject(driver);
        }
    }

}
