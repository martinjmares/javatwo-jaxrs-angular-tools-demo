angular.module('javatwo').controller('PresentationListCtrl', ['$rootScope', '$scope', 'l$Presentation', '$log',
    function($rootScope, $scope, l$Presentation, $log) {
        $rootScope.category = "presentation";
        $scope.confDay = "ALL";
        $scope.$watch('confDay', function(newValue, oldValue) {
            if (newValue == "ALL") {
                $scope.presentations = l$Presentation.list();
            } else {
                $scope.presentations = l$Presentation.list({day: newValue});
            }
        });
    }]);