package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        UN_SAVE = "id:Saved. Activate to unsave.";
        OVERFLOW_READING_LIST = "id:Saved";
        NO_THANKS_BUTTON = "xpath://android.widget.Button[@text='NO THANKS']";
        DIALOG_CHECKBOX = "id:places auth close";
        NAVIGATE_UP_BUTTON = "id:Back";
        BOOKMARK_MENU_BUTTON = "id:Save for later";
        PATH_TO_READING_LIST_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";
        TITLE_OF_ARTICLE = "xpath://*[@resource-id='content']//android.view.View[@index='0']";
    }

    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

}
