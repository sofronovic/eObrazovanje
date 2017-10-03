angular.
	module('studentServiceApp', 
	['ngRoute', 'ngResource', 'restangular', 'ui.bootstrap', 'lodash'])
	.config(['$routeProvider', function($routeProvider) {
		$routeProvider
			.when('/', {
			templateUrl: 'views/students.html'
			})
			.when('/login', {
				templateUrl : 'views/login.html',
				controller : 'login-ctrl'
			})
			.when('/students', {
				templateUrl: 'views/students.html',
				controller: 'students-ctrl'
			})
			.when('/courses', {
				templateUrl: 'views/courses.html',
				controller: 'course-ctrl'
			})
			.when('/subjects', {
				templateUrl: 'views/subjects.html',
				controller: 'subjects-ctrl'
			})			
			.otherwise({
				redirectTo: '/login'
			});
		}])

	.run(['Restangular', '$log', function(Restangular, $log){
		Restangular.setBaseUrl("api");
		Restangular.setErrorInterceptor(function(response){
			if (response.status === 500){
				$log.info("Internal server error!");
				return true;
			}
			return true;
		});
	}]);
