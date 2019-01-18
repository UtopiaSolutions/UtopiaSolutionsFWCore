package com.fakeUsers.util;

import com.google.common.collect.ImmutableList;
import com.usf.rest.RestUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HelperMethods {

    /**
     * Verify the http response status returned. Check Status Code is 200?
     * @param res
     */
    public static void checkStatusIs200 (Response res) {

        assertThat("Status Check Failed!", res.getStatusCode(), is(200));
    }


    /**
     *
     * Get Users Ids in the page
     * We can use get method of Rest Assured library's JsonPath Class's get method
     * Part of a response is shown below:
     * "data": [
     *     {
     *         "id": 4,
     *      ....
     *  We can get all id's with this code --> "jp.get("data.id");" this will return
     *  all id's under "data" tag/ array.
     *
     * @param jp
     * @return ArrayList
     */
    public static ArrayList getUsersIdList(JsonPath jp) {
        ArrayList usersIdList = jp.get("data.id");
        return usersIdList;
    }

    /**
     * Get all users first name
     * Structure of response is shown below:
     * "data": [
     *         {
     *             "id": 4,
     *             "first_name": "Eve",
     *          ....
     *
     *  In order to get all first_name's under data tag,
     *  We can use JsonPath's get method like "jp.get("data.first_name");"
     *  It will give us all first_name's under data tag.
     *
     * @param jp
     * @return
     */
    public static ArrayList<String> getAllUsersFirstNameOnPage(JsonPath jp) {
        //jp.get method returns all ids
        ArrayList<String> usersFirstNameList = jp.get("data.first_name");
        return usersFirstNameList;
    }


    public static String createAUser(String name, String job){

        //{ name: 'Hemant', job: 'Software Engineer' }
        String requestBody = "{name:"+ name + "," + "job:" + job + "}";
        return RestUtil.postRequest(requestBody, "user").jsonPath().get("id");
    }
}