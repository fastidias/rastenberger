var app = angular.module("foodoffer-directives", []);

app.directive("foodofferList", function () {
    return {
        restrict: "E",
        templateUrl: "foodoffer-list.html",
        controller: ["$http", "$log", function ($http, $log) {
                $log.log("Getting all foodoffers from REST resource.");

                var controller = this;
                controller.foodoffers = [];

                $http({
                    method: "GET",
                    url: "http://localhost:8080/RastenbergerRest/rs/foodoffers"
                }).then(function successCallback(response) {
                    controller.foodoffers = response.data;
                }, function errorCallback(response) {
                    controller.foodoffers = [];
                });
            }
        ],
        controllerAs: "foodofferCtrl"
    };
});

app.directive("foodofferForm", function () {
    return {
        restrict: "E",
        templateUrl: "foodoffer-form.html",
        controller: ["$http", "$log", function ($http, $log) {
                var controller = this;
                controller.foodoffer = {};

                controller.submitFoodoffer = function () {
                    $log.log("Creating foodoffer using REST call.");
                    $http({
                        method: "POST",
                        url: "http://localhost:8080/RastenbergerRest/rs/foodoffers",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        data: controller.foodoffer
                    }).then(function successCallback() {
                        controller.foodoffer = {};
                    }, function errorCallback() {
                        $log.log("Invalid response when creating foodoffer.");
                    });
                };
            }
        ],
        controllerAs: "foodofferFormCtrl"
    };
});
