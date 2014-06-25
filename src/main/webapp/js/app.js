var app = angular.module("geektic", ['ngRoute']);

app.controller('MainCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.config(['$routeProvider',function($routeProvider) {
    $routeProvider.when('/', {
    	templateUrl : 'mainForm.html'
    }).when('/geek/:sexe/:interets', {
    	templateUrl : 'resultForm.html',
    	controller : 'SearchCtrl'
    });
}]);

app.controller('SearchCtrl', function($scope, $http, $routeParams) {
	$http({
		url: '/geek/' +$routeParams.sexe +'/'+ $routeParams.interets,
		method: 'GET'
	}).success(function(geeksRecherches) {
    	$scope.geeks = geeksRecherches;
    });	
})