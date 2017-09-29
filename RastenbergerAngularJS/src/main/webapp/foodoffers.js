var app = angular.module("foodoffer-directives", []);

app.directive("foodofferList", function () {
    return {
        restrict: "E",
        templateUrl: "foodoffer-list.html",
        controller: ["$http", "$log", function ($http, $log) {
                var controller = this;
                controller.foodoffers = [];

                $log.log("This is how we can log data.");

                $http({
                    method: 'GET',
                    url: 'http://localhost:8080/RastenbergerRest/rs/foodoffers'
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
