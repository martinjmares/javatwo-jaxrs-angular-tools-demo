angular.module('javatwo').controller('RoomListCtrl', ['$rootScope', '$scope', 'l$Room', '$log',
    function($rootScope, $scope, l$Room, $log) {
        $rootScope.category = "room";
        $scope.rooms = l$Room.list();
    }]);