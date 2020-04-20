package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTest extends CoreTestCase {

    @Test
    public void testAssertElementPresent() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);

        searchPageObject.skipOnboarding();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Appium");
        searchPageObject.openArticleWithTitle("Appium");
        assertTrue("Title of article is missing", articlePageObject.getTitleElement().isDisplayed());
    }

    @Test
    public void testCheckSearchResultAfterClickCancelButton() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.skipOnboarding();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        int countOfArticles = searchPageObject.getListOfElements().size();
        assertTrue("Count of articles less than 2", countOfArticles >= 2);
        searchPageObject.resetSearch();
        boolean resultAfterClickCancelButton = searchPageObject.listOfElementsIsEmpty();
        assertTrue("Count of articles less than 2", resultAfterClickCancelButton);
    }

    @Test
    public void testThreeArticlesVerification() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.skipOnboarding();
        searchPageObject.initSearchInput();
        String title = "Android";
        searchPageObject.typeSearchLine(title);
        List<WebElement> listOfArticles = searchPageObject.getListOfElements();
        assertTrue("Error in article of title",
                searchPageObject.checkTitleInArticle(title, 3, listOfArticles));
    }

}
