angular.module('studentServiceApp')
	.factory('CourseResource', ['Restangular', '_', 
		function(Restangular, _){

			var courses = [];
			var returnValue = {};

			returnValue.getCourses = function(){
				return Restangular.all("studijskiProgrami").getList()
				.then(function(entries){
					courses = entries;
					return courses;
				});
			};

			returnValue.saveCourse = function(course){
				return Restangular.all("studijskiProgrami").post(course)
					.then(function(data){
						courses.push(data);
					});
			}

			returnValue.removeCourse = function(id){
				return Restangular.one("studijskiProgrami", id).remove()
					.then(function(){
						_.remove(courses, {
							id: id
						});
					});
			};
			return returnValue;
		}]);