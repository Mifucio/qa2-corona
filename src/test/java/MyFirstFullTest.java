import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstFullTest {
    private final By ARTICLE = By.tagName("article");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");

    private final Logger LOGGER = LogManager.getLogger(MyFirstFullTest.class);

    @Test
    public void titleCommentsCheck() {
        LOGGER.info("This test is checking titles and comments on tvnet page");
        System.setProperty("Webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("We are opening browser info");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tvnet.lv");

        //Find article
        LOGGER.info("Taking 3rd article");
        WebElement currentArticle = driver.findElements(ARTICLE).get(3);

        // Store title
        LOGGER.info("Find and store article");
        String titleToCheck = currentArticle.findElement(ARTICLE_TITLE).getText();

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
        Assertions.assertEquals(titleToCheck, driver.findElement(ARTICLE_PAGE_TITLE).getText(), "Incorrect Title!");

        //Check comments

       //Click on comments

        //Check title

        //Check comments count

    }
}