var myApp = angular.module("myApp", []);
myApp.controller("myController", function ($scope, $http) {
  $scope.data = "";
  $scope.celsius = "";
  $scope.kelvin = "";
  $scope.kilo = "";
  $scope.miles = "";
  $scope.conversions = [];

  $scope.ktoc = function (kelvin) {
    $http({
      url: "http://localhost:8765/convertor-service/conversions/ktoc",
      method: "POST",
      data: { amount: kelvin },
    }).then(
      function (result) {
        if (result.status == 200) {
          $scope.celsius = result.data;
          console.log(result);
          $scope.conversions();
        }
      },
      function (response) {
        console.log(error);
      }
    );
  };

  $scope.ctok = function (celsius) {
    $http({
      url: "http://localhost:8765/convertor-service/conversions/ctok",
      method: "POST",
      data: { amount: celsius },
    }).then(
      function (result) {
        if (result.status == 200) {
          $scope.kelvin = result.data;
          console.log(result);
          $scope.conversions();
        }
      },
      function (response) {
        console.log(error);
      }
    );
  };

  $scope.mtok = function (miles) {
    $http({
      url: "http://localhost:8765/convertor-service/conversions/mtok",
      method: "POST",
      data: { amount: miles },
    }).then(
      function (result) {
        if (result.status == 200) {
          $scope.kilo = result.data;
          console.log(result);
          $scope.conversions();
        }
      },
      function (response) {
        console.log(error);
      }
    );
  };

  $scope.ktom = function (kilo) {
    $http({
      url: "http://localhost:8765/convertor-service/conversions/ktom",
      method: "POST",
      data: { amount: kilo },
    }).then(
      function (result) {
        if (result.status == 200) {
          $scope.miles = result.data;
          console.log(result);
          $scope.conversions();
        }
      },
      function (response) {
        console.log(error);
      }
    );
  };

  $scope.conversions = function () {
    $http.get("http://localhost:8765/convertor-service/conversions/all").then(
      function (result) {
        if (result.status == 200) {
          $scope.conversions = result.data;
          console.log(result);
        }
      },
      function (error) {
        console.log(error);
      }
    );
  };
});
