angular.module('javatwo').controller('PresentationAddCtrl', ['$rootScope', '$scope', 'l$Presentation', 'l$Room', '$location', '$log',
    function($rootScope, $scope, l$Presentation, l$Room, $location, $log) {
        $rootScope.category = "presentation";
        $scope.rooms = l$Room.list();
        $scope.presentation = {};
        $scope.selectedRoom = {};
        $scope.submit = function() {
            $scope.presentation.roomNumber = $scope.selectedRoom.number;
            l$Presentation.add({}, $scope.presentation, new function() {
                $location.path("/lpresentation");
            });
        };
    }]);