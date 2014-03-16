'use strict';

socialquizApp.factory('Statement', ['$resource',
    function ($resource) {
        return $resource('app/rest/statements/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': { method: 'GET'}
        });
    }]);
