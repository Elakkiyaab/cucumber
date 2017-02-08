package nl.home.testing.steps;


import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.home.testing.pages.HomePage;
import nl.home.testing.util.DriverFactory;

import java.util.List;

public class HomePageSteps extends DriverFactory{
    private HomePage page;
    @Before
    public void homePage() {
        this.page = new HomePage(driver);
        this.page.open();

    }

  /**  @Given("^I am in Funda website home page$")
            public void openPage()
    {
        this.page.open();
    }
*/
  /**  @When("^When I enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void fill_input_parameters_(String place, String distance, String min,String max)  {


        System.out.print("##############test"+ place);
        page.enterPlace(place);
        page.selectDistance(distance);
        page.selectMaxPrice(max);
        page.selectMinPrice(min);
        page.clickSearch();
    }
   */

  @When("^I enter data in search fields$")
  public void enterData(DataTable table) {

      List<List<String>> data = table.raw();
      page.enterPlace(data.get(1).get(1));
      page.selectDistance(data.get(2).get(1));
      page.selectMaxPrice(data.get(3).get(1));
      page.selectMinPrice(data.get(4).get(1));
      page.clickSearch();


  }

      @Then("^I see the search results of the search$")
    public void gerSearchResults() {

        System.out.println("Search successful");
    }
    @After
    public void destroyDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }

}
