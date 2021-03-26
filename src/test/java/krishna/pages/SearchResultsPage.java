package krishna.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends PageObject {

    @FindBy(css=".listing-card")
    List<WebElement> listingCards;

    public List<String> getResultTitles() {
        return listingCards.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    public void selectItem(int itemNumber) {
        listingCards.get(itemNumber - 1)
                .findElement(By.tagName("a")).click();
    }

    public void filterByType(String type) {
        $("#filter-marketplace").find(By.partialLinkText(type)).click();
    }

    public int getItemCount() {
        String resultCount = $(".result-count").getText()
                .replace("We found ","")
                .replace(" item","")
                .replace("s","")
                .replace("!","")
                .replace(",","")
                ;
        return Integer.parseInt(resultCount);
    }

}
