package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        OVERFLOW_READING_LIST = "id:org.wikipedia:id/page_action_overflow_reading_lists";
        OVERFLOW_MENU_BUTTON = "id:org.wikipedia:id/page_toolbar_button_show_overflow_menu";
        NO_THANKS_BUTTON = "xpath://android.widget.Button[@text='NO THANKS']";
        DIALOG_CHECKBOX = "id:org.wikipedia:id/dialog_checkbox";
        NAVIGATE_UP_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        BOOKMARK_MENU_BUTTON = "id:org.wikipedia:id/article_menu_bookmark";
        ONBOARDING_BUTTON = "id:org.wikipedia:id/onboarding_button";
        PATH_TO_READING_LIST_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{SUBSTRING}']";
        TITLE_OF_ARTICLE = "xpath://*[@resource-id='content']//android.view.View[@index='0']";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

}
