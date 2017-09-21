'use strict';

angular.module('studentServiceApp').
	controller('course-ctrl', ['$scope', '$log', '_', 'CourseResource',
		function($scope, $log, _, CourseResource){
			CourseResource.getCourses().then(function(item){
				$scope.courses = item;
			});

			$scope.removeCourse = function(id){
				CourseResource.removeCourse(id);
			};

			$scope.addStudentForm = false;
			$scope.showForm = function(){
				$scope.addStudentForm = !$scope.addStudentForm;
			};

			$scope.saveCourse = function(course){
				CourseResource.saveCourse($scope.course);
			}
		}]);