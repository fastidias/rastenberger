package com.amt.rastenbergerrest.resources;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FoodOfferResourceIT {

    private final String webapiPath = "http://localhost:8080/RastenbergerRest/rs";
    private final JsonObject testFoodOffer = Json.createObjectBuilder()
            .add("owner", "Moe Szyslak")
            .add("externalLink", "https://www.google.de")
            .add("description", "French Duff - Düff")
            .build();

    @Before
    public void setUp() {
        final Response foodOffers = get(webapiPath + "/foodoffers");
        foodOffers.then().statusCode(HttpStatus.SC_OK);
        final List<Integer> foodOfferIds = foodOffers
                .body()
                .jsonPath()
                .getList("id");

        foodOfferIds.stream().forEach(id -> {
            delete(webapiPath + "/foodoffers/" + id)
                    .then()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
        });
    }

    @Test
    public void testGetFoodOffers() {
        System.out.println("getFoodOffers");

        get(webapiPath + "/foodoffers")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testGetFoodOffer() {
        System.out.println("getFoodOffer");

        final Long foodOfferId = createFoodOffer(testFoodOffer);

        get(webapiPath + "/foodoffers/" + foodOfferId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("owner", equalTo(testFoodOffer.getString("owner")))
                .body("externalLink", equalTo(testFoodOffer.getString("externalLink")))
                .body("description", equalTo(testFoodOffer.getString("description")))
                .body("links", anything());
    }

    @Test
    public void testCreateFoodOffer() {
        System.out.println("createFoodOffer");

        final JsonObject pizzaOffer = Json.createObjectBuilder()
                .add("owner", "Homer J. Simpson")
                .add("externalLink", "https://www.hallopizza.de/")
                .add("description", "Mmmmhhh ... pizza")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(pizzaOffer.toString())
                .post(webapiPath + "/foodoffers")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("owner", equalTo(pizzaOffer.getString("owner")))
                .body("externalLink", equalTo(pizzaOffer.getString("externalLink")))
                .body("description", equalTo(pizzaOffer.getString("description")))
                .body("links", anything());
    }

    @Test
    public void testUpdateFoodOffer() {
        System.out.println("updateFoodOffer");

        final Long foodOfferId = createFoodOffer(testFoodOffer);
        final JsonObject updateFoodOffer = Json
                .createObjectBuilder(testFoodOffer)
                .add("owner", "Bart Simpson")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(updateFoodOffer.toString())
                .put(webapiPath + "/foodoffers/" + foodOfferId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("owner", equalTo(updateFoodOffer.getString("owner")))
                .body("externalLink", equalTo(updateFoodOffer.getString("externalLink")))
                .body("description", equalTo(updateFoodOffer.getString("description")))
                .body("links", anything());
    }

    private Long createFoodOffer(JsonObject foodOffer) {
        final Response createResponse = given()
                .contentType(ContentType.JSON)
                .body(foodOffer.toString())
                .post(webapiPath + "/foodoffers");

        createResponse.then().statusCode(HttpStatus.SC_CREATED);

        final Integer foodOfferId = createResponse.body().jsonPath().get("id");
        return new Long(foodOfferId);
    }

}
