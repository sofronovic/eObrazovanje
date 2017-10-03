angular.module('studentServiceApp')
	.factory('SubjectsResource', ['Restangular', '_', '$log',
		function(Restangular, _, log){

			var subjects = [];
			var returnValue = {};

			returnValue.getSubjects = function(){
				return Restangular.all("predmeti").getList().then(function(entries){
					subjects = entries;
					return subjects;
				});

			};
			
			returnValue.saveSubject = function(subject){
				return Restangular.all("predmeti").post(subject)
					.then(function (data){
						subjects.push(data);
					});
			}

			returnValue.removeSubject = function(id){
				return Restangular.one("predmeti", id).remove().then(function(){
					_.remove(subjects, {
						id: id
					});
				});
			};	

			return returnValue;

		}]);