package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyReadingListPageObject;

public class AndroidMyReadingListPageObject extends MyReadingListPageObject {

    static {
        SEARCH_PAGE_BUTTON = "xpath://android.widget.TextView[contains(@text,'Explore')]";
        ARTICLE = "id:org.wikipedia:id/page_list_item_title";
        PATH_TO_ARTICLE_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{SUBSTRING}']";
        PATH_TO_READING_LIST_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";
    }

    public AndroidMyReadingListPageObject(AppiumDriver driver) {
        super(driver);
    }

}
