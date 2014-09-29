'use strict';

var javatwo = angular.module('javatwo', [
    'ngRoute',
    'restServices'
]);

javatwo.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/addpresentation', {
                templateUrl: 'partials/presentation-add.html',
                controller: 'PresentationAddCtrl'
            }).
            when('/lpresentation', {
                templateUrl: 'partials/presentation-list.html',
                controller: 'PresentationListCtrl'
            }).
            when('/lroom', {
                templateUrl: 'partials/room-list.html',
                controller: 'RoomListCtrl'
            }).
            when('/droom/:roomNo', {
                templateUrl: 'partials/room-detail.html',
                controller: 'RoomDetailCtrl'
            }).
            otherwise({
                redirectTo: '/lpresentation'
            });
    }]);

javatwo.run(['$rootScope', 'l$ConferenceDay', '$log',
    function($rootScope, l$ConferenceDay, $log) {
        $rootScope.confDaysAndAll = ["ALL"];
        $rootScope.confDays = l$ConferenceDay.list("", function() {
            $rootScope.confDaysAndAll = $rootScope.confDaysAndAll.concat($rootScope.confDays);
        });
    }]);