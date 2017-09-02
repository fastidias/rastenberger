package com.amt.rastenbergerrest.resources;

import static org.junit.Assert.*;
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
            .add("externalLink", "www.google.de")
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
        get("http://localhost:8080/RastenbergerRest/rs/foodoffers")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testGetFoodOffer() {
        final Long foodOfferId = createFoodOffer(testFoodOffer);

        System.out.println(webapiPath + "/foodoffers/" + foodOfferId);
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
