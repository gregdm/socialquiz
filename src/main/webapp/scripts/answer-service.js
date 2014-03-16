'use strict';

socialquizApp.factory('Answer', ['$resource',
    function ($resource) {
        return $resource('app/rest/answers/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': { method: 'GET'}
        });
    }]);
