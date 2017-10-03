'use strict';
angular.module('studentServiceApp').
	controller('subjects-ctrl', ['$scope', '_', 'SubjectsResource', 'CoursesResource','$log',
		function($scope, _, SubjectsResource, CoursesResource,$log) {

				//$scope.subject = [];


			SubjectsResource.getSubjects().then(function(item){
				$scope.subjects = item;
			
			});

			CoursesResource.getCourses().then(function(item){
				$scope.courses = item;
			});

			$scope.removeSubject = function(id){
				SubjectsResource.removeSubject(id);
			};

			$scope.addStudentForm = false;
			$scope.showForm = function(){
				$scope.addStudentForm = !$scope.addStudentForm;
			};

			$scope.saveSubject = function(subject){
				SubjectsResource.saveSubject(subject);
				$log.info($scope.subject.studijskiProgram);
			};

		}]);