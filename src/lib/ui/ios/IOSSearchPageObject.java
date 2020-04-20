package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SKIP_ONBOARDING_BUTTON = "id:Skip";
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "xpath://XCUIElementTypeStaticText[@name='Wikipedia, scroll to top of Explore']";
        LIST_OF_ELEMENTS = "xpath://XCUIElementTypeLink";
        SEARCH_CLOSE_BUTTON = "id:Close";
        SEARCH_RESULT_TITLE_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_DESCRIPTION_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{SUBSTRING}']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        CLEAR_SEARCH_LINE_BUTTON = "id:clear mini";
    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }


}
