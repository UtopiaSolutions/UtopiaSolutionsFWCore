package com.fakeUsers.tests;

import com.fakeUsers.util.HelperMethods;
import com.usf.rest.RestUtil;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreateUserAPITest {

    private Response res = null; //Response object
    private JsonPath jp = null; //JsonPath object


    @BeforeMethod
    public void setup (){
        //Test Setup
        RestUtil.setBaseURI("https://reqres.in"); //Setup Base URI
        RestUtil.setBasePath("api"); //Setup Base Path
        RestUtil.setContentType(ContentType.JSON); //Setup Content Type
        RestUtil.createSearchQueryPath("users",  "page", "2"); //Construct the path
        res = RestUtil.getResponse(); //Get response
        jp = RestUtil.getJsonPath(res); //Get JsonPath
    }


    @Test(groups = {"t:apiTest","a:Hemant"})
    public void statusCodeTest() {
        //Verify the http response status returned. Check Status Code is 200?
        HelperMethods.checkStatusIs200(res);
    }

    @Test
    public void createUserTest() {
        assertThat("New user id should not be null",
                HelperMethods.createAUser("Hemant", "Software Engineer"),
                notNullValue() );
    }

    @AfterMethod
    public void afterTest (){
        //Reset Values
        RestUtil.resetBaseURI();
        RestUtil.resetBasePath();
    }








}
