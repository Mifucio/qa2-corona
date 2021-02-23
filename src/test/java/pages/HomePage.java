package pages;

import helpers.CommentsHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private final By ACCEPT_BTN = By.xpath(".//div[contains(@class, 'button cookie')]");
    private final By ARTICLE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'list-article__comment')]");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_BTN);
    }

    public void openArticleById(int id) {
        LOGGER.info("Get article to check");
        WebElement titleToClick = baseFunc.findElements(ARTICLE_TITLE).get(id);
        baseFunc.click(titleToClick);

        LOGGER.info("Store title to check");
        String titleToCheck = titleToClick.getText();
        System.out.println(titleToCheck);


//        LOGGER.info("Store comment count to check");
//        int commentCount = 0;
//
//        if (!titleToClick.findElements(COMMENTS_COUNT).isEmpty()) {
//            String commentsToParse = titleToClick.findElement(COMMENTS_COUNT).getText();
//            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1);
//            commentCount = Integer.parseInt(commentsToParse);
//            System.out.println(commentCount);
//            baseFunc.click(titleToClick);
//        }
    }
    public int getcommentCountById(int id) {
        CommentsHelper helper = new CommentsHelper();
        return helper.getCommentCount(baseFunc.findElement(COMMENTS_COUNT));
    }
}
