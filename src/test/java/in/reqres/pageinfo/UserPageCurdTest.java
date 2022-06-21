package in.reqres.pageinfo;

import in.reqres.pageSteps.PageInfo;
import in.reqres.testbase.TestBase;
import in.reqres.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserPageCurdTest extends TestBase {
    public String name = "john" + TestUtils.getRandomValue();
    public String job = "softwareTester";
    static String pageId;
    ValidatableResponse response;

    @Steps
    PageInfo pageinfo;

    @Test
    public void test001(){
        response = pageinfo.createUserPage(name,job);
        response.log().all().statusCode(201);
        pageId = response.extract().path("id");
        System.out.println(pageId);
    }

    @Test
    public void test002(){
        response = pageinfo.getUserPageByID(pageId);
        response.log().all().statusCode(200);
    }

    @Test
    public void test003(){
        name = name + "_updated";
        job = "QA";
        response = pageinfo.updateUserPage(pageId,name,job);
        response.log().all().statusCode(200);
    }

    @Test
    public void test004(){
        response = pageinfo.deleteUserPageByID(pageId);
        response.log().all().statusCode(204);
        response = pageinfo.getUserPageByID(pageId);
        response.log().all().statusCode(404);
    }

}
