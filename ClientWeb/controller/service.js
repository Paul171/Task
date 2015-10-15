'use strict';
var taskServices = angular.module('taskService', ['ngResource']);

taskServices.factory('Tasks', ['$resource',
  function($resource){
    return $resource('../App/:task', {}, {
      query: {method:'GET', params:{task:'Tasks'}, isArray:true}
    });
  }]);