package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CommentsPage {
    private final By TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'article-comments-heading__count')]");
    private final By COMMENTS_IN_FACT = By.xpath(".//span[contains(@class, 'article-comment-author__name section-font-color')]");

    private BaseFunc baseFunc;

    public CommentsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


    WebElement commentTitleToCheck = baseFunc.driver.findElement(TITLE);
    String currentArticleTitleToCheck = commentTitleToCheck.getText();


    WebElement commentNumberToCheck = baseFunc.driver.findElement(COMMENTS_COUNT);

    List<WebElement> commentsInFact = baseFunc.driver.findElements(COMMENTS_IN_FACT);


}
