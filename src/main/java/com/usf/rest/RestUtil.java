package com.usf.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RestUtil {
    private static final Logger log = LoggerFactory.getLogger(RestUtil.class);


    //Global Setup Variables
    public static String path; //Rest request path

    /**
     * Sets base URI
     * Before starting the test, we should set the RestAssured.baseURI
     * @param baseURI
     */
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
        log.debug("Base URI set to: " + baseURI);
    }

    /**
     * Sets base path
     * Before starting the test, we should set the RestAssured.basePath
     * @param basePathTerm
     */
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
        log.debug("Base Path set to: " + basePathTerm);
    }

    /**
     * Reset Base URI (after test)
     * After the test, we should reset the RestAssured.baseURI
     */
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
        log.debug("Base URI has been reset.");
    }

    /**
     * Reset base path (after test)
     * After the test, we should reset the RestAssured.basePath
     */
    public static void resetBasePath(){
        RestAssured.basePath = null;
        log.debug("Base Path has been reset.");
    }

    /**
     * Sets ContentType
     * We should set content type as JSON or XML before starting the test
     * @param Type
     */
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }

    /**
     * search query path of first example
     * It is  equal to "users?page=2"
     * @param searchTerm
     * @param param
     * @param paramValue
     */
    public static void  createSearchQueryPath(String searchTerm, String param, String paramValue) {
        path = searchTerm + "/" + "?" + param + "=" + paramValue;
    }

    /**
     * Returns response
     * We send "path" as a parameter to the Rest Assured'a "get" method
     * and "get" method returns response of API
     * @return
     */
    public static Response getResponse() {
        //System.out.print("path: " + path +"\n");
        return get(path);
    }


    /**
     * Returns response after posting a request
     * We send "path" as a parameter to the Rest Assured'a "get" method
     * and "get" method returns response of API
     * @return
     */
    public static Response postRequest(String json, String param) {

        RequestSpecification specification = RestAssured.given();
        specification.body(json);
        Response response = specification.post(param);
        return response;
    }

    /**
     * Returns JsonPath object
     * First convert the API's response to String type with "asString()" method.
     * Then, send this String formatted json response to the JsonPath class and return the JsonPath
     * @param res
     * @return
     */
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        //System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }



}
