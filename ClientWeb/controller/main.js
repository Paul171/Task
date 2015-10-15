'use strict';
var taskApp = angular.module('taskApp',['ngRoute','ui.bootstrap','taskService']);
taskApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/tasks', {
        templateUrl: 'partials/taskList.html',
        controller: 'taskList'
      }).
      when('/tasks/:taskId', {
        templateUrl: 'partials/phone-detail.html',
        controller: 'PhoneDetailCtrl'
      }).
      otherwise({
        redirectTo: '/tasks'
      });
  }]);
taskApp.controller('taskList',['$scope','Tasks',
  function($scope,Tasks){
    $scope.tasks= Tasks.query();
    $scope.name = "Tasks";
  }]);
taskApp.controller('taskDetail',['$scope','$routeParam',
  function($scope, $routeParam){
    $scope.taskId = $routeParam.taskId;
  }]); 