var app = angular.module("geektic", ['ngRoute']);

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.config(['$routeProvider',function($routeProvider) {
    $routeProvider.when('/', {
    	templateUrl : 'mainForm.html',
    });
}]);