package krishna.features.search;


import krishna.steps.BuyerSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static sun.jvm.hotspot.utilities.AddressOps.lessThan;

@RunWith(SerenityRunner.class)
public class WhenSearchingByKeyword {

    @Managed(driver="chrome", uniqueSession = true)
    WebDriver driver;

    @Steps
    BuyerSteps buyer;

    @Test
    public void should_see_a_list_of_items_related_to_the_specified_keyword() {
        // GIVEN
        buyer.opens_etsy_home_page();
        // WHEN
        buyer.searches_for_items_containing("wool");
        // THEN.
        buyer.should_see_items_related_to("wool");
    }

    @Test
    public void should_be_able_to_filter_by_item_type() {
        // GIVEN
        buyer.opens_etsy_home_page();
        // WHEN
        buyer.searches_for_items_containing("wool");
        int unfilteredItemCount = buyer.get_matching_item_count();
        // AND
        buyer.filters_results_by_type("Handmade");
        // THEN
        buyer.should_see_items_related_to("wool");
        // AND
        buyer.should_see_item_count(lessThan(unfilteredItemCount));
    }

    @Test
    public void should_be_able_to_view_details_about_a_searched_item() {
        // GIVEN
        buyer.opens_etsy_home_page();
        // WHEN
        buyer.searches_for_items_containing("wool");
        buyer.selects_item_number(5);
        // THEN
        buyer.should_see_matching_details();
    }

}