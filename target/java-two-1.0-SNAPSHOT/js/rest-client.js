var restServices = angular.module('restServices', ['ngResource']);

//List of days
restServices.factory('l$ConferenceDay', ['$resource',
    function($resource){
        return $resource('rest/confday', {}, {
            list: {method:'GET', isArray:true}
        });
    }]);

//PresentationResource
restServices.factory('l$Presentation', ['$resource',
    function($resource){
        return $resource('rest/presentation', {}, {
            /** Param: day - optional ConferenceDay filter
             *  Param: room - optional room number filter
             */
            list: {method:'GET', isArray:true},
            add: {method:'POST'}
        });
    }]);

//RoomResource
restServices.factory('l$Room', ['$resource',
    function($resource){
        return $resource('rest/room/:no', {}, {
            list: {method:'GET', isArray:true},
            getByNumber:  {method:'GET', params:{no:''}, isArray:false}
        });
    }]);