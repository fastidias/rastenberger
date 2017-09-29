(function () {
    var app = angular.module('rastenbergerApp', []);

    app.controller('FoodofferController', ["$http", "$log", function ($http, $log) {
            var controller = this;
            controller.foodoffers = [];

            $http({
                method: 'GET',
                url: 'http://localhost:8080/RastenbergerRest/rs/foodoffers'
            }).then(function successCallback(response) {
                $log.log("data" + response.data);
                controller.foodoffers = response.data;
            }, function errorCallback(response) {
                $log.log("an error occured" + response);
            });
        }
    ]);
    
})();
