import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.BaseFunc;
import pages.HomePage;

public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private int articleId = 3;

    @Test
    public void tvnetPageObjectTest(){
        LOGGER.info("This test is checking atricle titles and comment counts");
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl("http://tvnet.lv");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        //Get article title on Home page

        homePage.openArticleById(3);
        //Get article title on Article Page

        //Compare article title

//        ArticlePage articlePage = new ArticlePage(baseFunc);
//        articlePage.blablabla;
    }
}
