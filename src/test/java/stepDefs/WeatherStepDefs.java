package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requestors.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private int cityId;
    private WeatherResponse response;

    @Given("city id: {int}")
    public void set_city_id(int cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.getWeather(cityId);
//call Weather Requester
    }

    @Then("lon is {double}")
    public void check_lon(double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong Long");
    }

    @Then("lat is {double}")
    public void check_lat(double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong Lat");
    }

    @Then("weather is:")
    public void check_wheather(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getWeathers().get(0).getId(), "Wrong Weather ID");
        Assertions.assertEquals(params.get("main"), response.getWeathers().get(0).getMain(), "Wrong Weather ,main");
        Assertions.assertEquals(params.get("description"), response.getWeathers().get(0).getDescription(), "Wrong Weather, description");
        Assertions.assertEquals(params.get("icon"), response.getWeathers().get(0).getIcon(), "Wrong Weather, icon");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase(), "Wrong base");
    }

    @Then("main data is:")
    public void Check_main_data(Map<String, String> params) {
        Assertions.assertEquals(params.get("temp"), response.getMain().getTemp(), "Wrong temp");

    }

    @Then("visibility is {int}")
    public void check_visibility(int visibility) {

    }

    @Then("wind data is:")
    public void check_wind_data(Map<String, String> params) {

    }

    @Then("clouds all is {int}")
    public void check_clouds_all(int all) {

    }

    @Then("dt is {int}")
    public void check_dt(int dt) {

    }

    @Then("sys is:")
    public void check_sys_data(Map<String, String> params) {

    }

    @Then("id is {int}")
    public void check_id(int id) {

    }

    @Then("name is {string}")
    public void check_name(String name) {

    }

    @Then("cod is {int}")
    public void check_cod(int cod) {

    }
}
