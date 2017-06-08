angular.module('app',[])
.controller("TaskController", function($scope, TaskService){
	$scope.save=save;
	$scope.update=update;
	$scope.del=del;
	$scope.list=list;
	$scope.edit=edit;
	$scope.add=add;
	$scope.cancel=cancel;

	$scope.task=null;
	$scope.tasks=[];

	//get all tasks
	function list(){
		TaskService.GetAll()
			.then(function(data){
			if(data){
				$scope.tasks=data;
			}
		})
			
	}
	function save(task){

		TaskService.Create(task)
			.then(function (data) {
	            if (data) {
	                $scope.tasks.push(data);
	                $scope.task=null;
	            }
	        })
	}

	
	function update(task){
		TaskService.Update(task)
			.then(function(data){
				if(data){
					list();
					$scope.task=null;
				
			}})
	}

	function del(task){
		TaskService.Delete(task)
			.then(function(data){
					
			$scope.tasks.splice($scope.tasks.indexOf(task),1);
				
			})
	}

	function edit(task){
		$scope.task=task;

	}
	function add(){
		$scope.task=null;
	}
	function cancel(){
		$scope.task=null;
	}

	//get all list Task
	$scope.list();

	})

  .factory("TaskService", function($http, $rootScope) {
        var service = {};
        var urlApi="http://localhost:8000";
        service.GetAll = GetAll;
        service.GetById = GetById;

        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
            return $http.get(urlApi+'/api/task').then(handleSuccess, handleError('Error getting all task'));
        }
        
        function GetById(id) {
            return $http.get(urlApi+'/api/task/id/' + id).then(handleSuccess, handleError('Error getting task by id'));
        }

        function Create(task) {
            return $http.post(urlApi+'/api/task', task).then(handleSuccess, handleError('Error creating task'));
        }

        function Update(task) {
            return $http.put(urlApi+'/api/task/edit/' + task.id, task).then(handleSuccess, handleError('Error updating task'));
        }

        function Delete(task) {
            return $http.delete(urlApi+'/api/task/del/' + task.id).then(handleSuccess, handleError('Error deleting task'));
        }

        // private functions

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }


    })