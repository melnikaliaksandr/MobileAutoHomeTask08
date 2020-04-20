package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyReadingListPageObject extends MainPageObject {

    protected static String
            ARTICLE,
            SEARCH_PAGE_BUTTON,
            PATH_TO_ARTICLE_TPL,
            PATH_TO_READING_LIST_TPL;

    public MyReadingListPageObject(AppiumDriver driver) {
        super(driver);
    }

    public boolean readingListIsEmpty() {
        return this.waitForElementNotPresent(
                ARTICLE,
                "Cannot get attribute text",
                5);
    }

    public String getNameOfArticle() {
        return this.waitForElementAndGetAttribute(
                ARTICLE,
                "text",
                "Cannot get attribute text",
                10);
    }

    public void openSearchPage() {
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    SEARCH_PAGE_BUTTON,
                    "Cannot find search page button",
                    10);
        } else {
            this.waitForElementAndClick(
                    SEARCH_PAGE_BUTTON,
                    "Cannot find search page button",
                    10);
        }
    }

    public void openArticleByName(String articleName) {
        String article = replaceTemplate(PATH_TO_ARTICLE_TPL, articleName);
        this.waitForElementAndClick(
                article,
                "Cannot click of article",
                10);
    }

    public void deleteArticleByName(String articleName) {
        String article = replaceTemplate(PATH_TO_ARTICLE_TPL, articleName);
        this.swipeElementToLeft(
                article,
                "Cannot swipe element to left");
        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article, "Cannot find saved article");
        }
    }

    private static String replaceTemplate(String template, String substring) {
        return template.replace("{SUBSTRING}", substring);
    }

    public int getCountOfArticles() {
        return this.waitAndReturnListOfElements(
                ARTICLE,
                "Cannot find list of articles",
                10).size();
    }

    public void openReadingList(String readingListName) {
        String readingList = replaceTemplate(PATH_TO_READING_LIST_TPL, readingListName);
        this.waitForElementAndClick(
                readingList,
                "Cannot find list for saved articles",
                10);
    }

}
