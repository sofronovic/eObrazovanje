'use strict';

angular.module('studentServiceApp').
	controller('course-ctrl', ['$scope', '$log', '_', 'CoursesResource',
		function($scope, $log, _, CoursesResource){
			CoursesResource.getCourses().then(function(item){
				$scope.courses = item;
			});

			$scope.removeCourse = function(id){
				CoursesResource.removeCourse(id);
			};

			$scope.addStudentForm = false;
			$scope.showForm = function(){
				$scope.addStudentForm = !$scope.addStudentForm;
			};

			$scope.saveCourse = function(course){
				CoursesResource.saveCourse($scope.course);
			}
		}]);