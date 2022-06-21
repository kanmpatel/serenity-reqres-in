package in.reqres.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.reqres.pageSteps.PageInfo;
import in.reqres.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {
    public String name = "john" + TestUtils.getRandomValue();
    public String job = "softwareTester";
    static String pageId;
    ValidatableResponse response;

    @Steps
    PageInfo pageinfo;

    @When("^I sends the Post Request for create the User Data$")
    public void iSendsThePostRequestForCreateTheUserData() {

    }

    @And("^I insert the name, job$")
    public void iInsertTheNameJob() {
        response = pageinfo.createUserPage(name,job);
    }

    @Then("^I verify the status code (\\d+) for User data$")
    public void iVerifyTheStatusCodeForUserData(int statusCode) {
        response.log().all().statusCode(statusCode);
    }

    @And("^I get the id of new created User data$")
    public void iGetTheIdOfNewCreatedUserData() {
        pageId = response.extract().path("id");
    }

    @When("^I sends a GET request for fatching User data by given ID$")
    public void iSendsAGETRequestForFatchingUserDataByGivenID() {
        response = pageinfo.getUserPageByID(pageId);
    }

    @Then("^I verify the name is for created record for User$")
    public void iVerifyTheNameIsForCreatedRecordForUser() {
    }

    @When("^I send the Put Request for updating the User data$")
    public void iSendThePutRequestForUpdatingTheUserData() {

    }

    @And("^I update the name, job$")
    public void iUpdateTheNameJob() {
        name = name + "_updated";
        job = "QA";
        response = pageinfo.updateUserPage(pageId,name,job);
    }

    @Then("^I verify the status code (\\d+) for update User data$")
    public void iVerifyTheStatusCodeForUpdateUserData(int statusCode) {
        response.log().all().statusCode(statusCode);
    }

    @And("^I verify the name for updating the User data$")
    public void iVerifyTheNameForUpdatingTheUserData() {
    }

    @When("^I sends the Delete Request for deleting the User  given ID$")
    public void iSendsTheDeleteRequestForDeletingTheUserGivenID() {
        response = pageinfo.deleteUserPageByID(pageId);
    }

    @Then("^I verify the status code (\\d+) for delete User data$")
    public void iVerifyTheStatusCodeForDeleteUserData(int statusCode) {
        response.log().all().statusCode(statusCode);
    }

    @And("^I get the data for deleted record ID for User data$")
    public void iGetTheDataForDeletedRecordIDForUserData() {
        response = pageinfo.getUserPageByID(pageId);
    }

    @And("^I verify the status code (\\d+) for verifing the delete record$")
    public void iVerifyTheStatusCodeForVerifingTheDeleteRecord(int statusCode) {
        response.log().all().statusCode(statusCode);
    }
}
