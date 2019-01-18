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

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class ListUsersAPITest {

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


    @Test
    public void statusCodeTest() {
        //Verify the http response status returned. Check Status Code is 200?
        HelperMethods.checkStatusIs200(res);
    }

    @Test
    public void usersCountPerPageTest() {
        //Verify 3 users entries is returned
        assertThat("Users in given page is not 3",HelperMethods.getUsersIdList(jp).size(), is(3));
    }

    @Test
    public void usersPerPageTest() {
        //Verify users - Eve Charles Tracey are available on page 2
        assertThat("Page 2 does not have Eve Charles Tracey and John",
                HelperMethods.getAllUsersFirstNameOnPage(jp),
                hasItems("Eve", "Charles", "Tracey", "John"));
    }


    @AfterMethod
    public void afterTest (){
        //Reset Values
        RestUtil.resetBaseURI();
        RestUtil.resetBasePath();
    }








}
