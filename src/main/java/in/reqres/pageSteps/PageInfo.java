package in.reqres.pageSteps;

import in.reqres.constants.EndPoints;
import in.reqres.model.UserPagePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PageInfo {

    @Step
    public ValidatableResponse createUserPage(String name, String job){
        UserPagePojo userPagePojo = new UserPagePojo();
        userPagePojo.setName(name);
        userPagePojo.setJob(job);

        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(userPagePojo)
                .when()
                .post(EndPoints.CREATE_PAGE)
                .then();
    }

    @Step
    public ValidatableResponse getUserPageByID(String pageId){
        return SerenityRest.given()
                .pathParam("usersID",pageId)
                .when()
                .get(EndPoints.GET_SINGLE_PAGE)
                .then();
    }

    @Step
    public ValidatableResponse updateUserPage(String pageId,String name, String job){
        UserPagePojo userPagePojo = new UserPagePojo();
        userPagePojo.setName(name);
        userPagePojo.setJob(job);

        return SerenityRest.given()
                .pathParam("usersID",pageId)
                .contentType(ContentType.JSON)
                .body(userPagePojo)
                .when()
                .put(EndPoints.UPDATE_PAGE_BY_ID)
                .then();
    }

    @Step
    public ValidatableResponse deleteUserPageByID(String pageId){
        return SerenityRest.given()
                .pathParam("usersID",pageId)
                .when()
                .delete(EndPoints.DELETE_PAGE_BY_ID)
                .then();
    }
}
