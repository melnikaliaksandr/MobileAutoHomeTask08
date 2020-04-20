package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyReadingListPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyReadingListPageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTest extends CoreTestCase {

    @Test
    public void testSaveTwoArticles() {

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        MyReadingListPageObject myReadingListPageObject = MyReadingListPageObjectFactory.get(driver);

        searchPageObject.skipOnboarding();
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Java");
        String firstArticle = "Java (programming language)";
        searchPageObject.openArticleWithTitle(firstArticle);
        articlePageObject.saveArticleToReadingList("Saved");
        articlePageObject.closeArticle();
        articlePageObject.doNotSyncReadingList();
        searchPageObject.initSearchInputAndClearSearchLine();
        searchPageObject.typeSearchLine("Android");
        searchPageObject.waitForSearchResult("Android");
        String secondArticle = "Android (operating system)";
        searchPageObject.openArticleWithTitle(secondArticle);
        articlePageObject.saveArticleToReadingList("Saved");

        articlePageObject.openMyReadingList();
        if (Platform.getInstance().isAndroid()) {
            myReadingListPageObject.openReadingList("Saved");
        }
        int countOfArticles = myReadingListPageObject.getCountOfArticles();
        myReadingListPageObject.deleteArticleByName("Java");
        int countOfArticlesAfterDelete = myReadingListPageObject.getCountOfArticles();
        assertEquals("Error in count of articles", countOfArticles - 1, countOfArticlesAfterDelete);

        myReadingListPageObject.openSearchPage();
        searchPageObject.initSearchInputAndClearSearchLine();
        searchPageObject.typeSearchLine("Android");
        searchPageObject.waitForSearchResult("Android");
        searchPageObject.openArticleWithTitle(secondArticle);
        articlePageObject.unSaveArticle();
        articlePageObject.openMyReadingList();
        if (Platform.getInstance().isAndroid()) {
            myReadingListPageObject.openReadingList("Saved");
        }
        assertTrue("Reading list is not empty", myReadingListPageObject.readingListIsEmpty());
    }

}
