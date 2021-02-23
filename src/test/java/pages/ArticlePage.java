package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {
    private final By TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENTS = By.xpath(".//a[contains(@class, '--comments')]");
    private BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

//    public void openCommentsArticle(){
//        WebElement commentsToClick = baseFunc.findElement(COMMENTS);
//    }

    public String getTitle() {
        LOGGER.info("Getting article title");
        return baseFunc
//        WebElement titleToCheck = baseFunc.driver.findElement(TITLE);
//        String articleTitleToCheck = titleToCheck.getText();
//        return articleTitleToCheck;

    }

//    public int getCommentCount = baseFunc.driver.findElement(COMMENTS);


//        int commentCount = 0;
//
//
//        if (!articleToClick.findElements(COMMENTS_COUNT).isEmpty()) {
//        String commentsToParse = articleToClick.findElement(COMMENTS_COUNT).getText();
//        commentCount = Integer.parseInt(commentsToParse);


}
