package com.amt.rastenbergerrest.resources;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.specification.ResponseSpecification;
import java.util.HashMap;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import org.json.JSONObject;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.*;

public class FoodOfferResourceIT {

    public FoodOfferResourceIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createFoodOffer method, of class FoodOfferResource.
     */
    @org.junit.Test
    public void testCreateFoodOffer() {
        System.out.println("createFoodOffer");
        JSONObject data = new JSONObject()
                .put("owner", "towbee")
                .put("description", "test mich")
                .put("externalLink", "http://google.de");

        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(data.toString())
                .post("http://localhost:8080/RastenbergerRest/rs/foodoffers")
                .then().statusCode(HttpStatus.SC_OK)
                        .body("owner",equalTo("towbee"))
                        .body("description",equalTo("test mich"))
                        .body("externalLink",equalTo("http://google.de"));
    }

    /**
     * Test of getFoodOffers method, of class FoodOfferResource.
     */
    @org.junit.Test
    public void testGetFoodOffers() {
        System.out.println("getFoodOffers");
        get("http://localhost:8080/RastenbergerRest/rs/foodoffers")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    /**
     * Test of getFoodOffer method, of class FoodOfferResource.
     */
    @org.junit.Test
    public void testGetFoodOffer() {
        System.out.println("getFoodOffer");
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFoodOffer method, of class FoodOfferResource.
     */
    @org.junit.Test
    public void testUpdateFoodOffer() {
        System.out.println("updateFoodOffer");
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFoodOffer method, of class FoodOfferResource.
     */
    @org.junit.Test
    public void testDeleteFoodOffer() {
        System.out.println("deleteFoodOffer");
        fail("The test case is a prototype.");
    }

}
