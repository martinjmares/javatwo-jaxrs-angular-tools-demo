angular.module('javatwo').controller('RoomDetailCtrl', ['$rootScope', '$scope', 'l$Room', 'l$Presentation', '$routeParams', '$log',
    function($rootScope, $scope, l$Room, l$Presentation, $routeParams, $log) {
        $rootScope.category = "room";
        $scope.room = l$Room.getByNumber({no: $routeParams.roomNo});
        $scope.presentations = l$Presentation.list({room: $routeParams.roomNo});
    }]);