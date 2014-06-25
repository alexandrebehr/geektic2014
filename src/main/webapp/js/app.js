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
    }).when('/geek/:id', {
    	templateUrl : 'detailGeek.html',
    	controller : 'ShowDetailCtrl'
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

app.controller('ShowDetailCtrl', function($scope, $http, $routeParams) {
	$http({
		url: '/geek/' +$routeParams.id,
		method: 'GET'
	}).success(function(geekToShow) {
    	$scope.geek = geekToShow;
    });	
})