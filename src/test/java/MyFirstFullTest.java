import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MyFirstFullTest {
    private final By ACCEPT_COOKIES_BTN  = By.xpath(".//div[contains(@class, 'button cookie')]");
    private final By ARTICLE = By.tagName("article");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");
    private final By COMMENTS_IN_FACT = By.className(".comments-block__comments .article-comments");

    //private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");



    private final Logger LOGGER = LogManager.getLogger(MyFirstFullTest.class);


    @Test
    public void titleCommentsCheck() {
        LOGGER.info("This test is checking titles and comments on tvnet page");
        System.setProperty("Webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("We are opening browser window");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");
        WebElement acceptBtn = driver.findElement(ACCEPT_COOKIES_BTN);
        acceptBtn.click();

        //Find article
        LOGGER.info("Taking 3rd article");
        WebElement currentArticle = driver.findElements(ARTICLE).get(3);

        // Store title
        LOGGER.info("Find and store article title");
        String titleToCheck = currentArticle.findElement(ARTICLE_TITLE).getText();
        System.out.println(titleToCheck);

        //Store comments count
        int commentCount = 0;

        if (!currentArticle.findElements(COMMENTS_COUNT).isEmpty()) {
            String commentsToParse = currentArticle.findElement(COMMENTS_COUNT).getText();
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() -1);
            commentCount = Integer.parseInt(commentsToParse);
        }

        //Open article
        currentArticle.findElement(ARTICLE_TITLE).click();


        //Check title

        //Assertions.assertEquals(titleToCheck, driver.findElement(ARTICLE_PAGE_TITLE).getText(), "Incorrect Title!");
        //Assertions.assertTrue(titleToCheck.contains(ARTICLE_TITLE), "Incorrect Title");

        //Check comments
        Assertions.assertEquals(commentCount, driver.findElement(COMMENTS_COUNT));

       //Click on comments
        currentArticle.findElement(COMMENTS_COUNT).click();

        //Check title

        //Check comments count
        List<WebElement> commentsInFact = driver.findElements(COMMENTS_IN_FACT);
        System.out.println(commentsInFact);

    }
}