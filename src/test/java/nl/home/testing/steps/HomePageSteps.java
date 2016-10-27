package nl.home.testing.steps;


import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.home.testing.pages.HomePage;
import nl.home.testing.util.DriverFactory;

public class HomePageSteps extends DriverFactory{
    private HomePage page;
    @Before("@OpenHomePage")
    public void homePage() {
        this.page = new HomePage(driver);
        this.page.open();

    }



    @Then("^I see text message saying\"([^\"]*)\" located at \"([^\"]*)\"$")
    public void I_see_text_message_saying_located_at(String expmessage, String locator) {

        System.out.println(expmessage+ locator);
    }

    @When("^fill input parameters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void fill_input_parameters_(String place, String distance, String min,String max)  {


        System.out.print("##############test"+ place);
        page.enterPlace(place);
        page.selectDistance(distance);
        page.selectMaxPrice(max);
        page.selectMinPrice(min);

    }
}
