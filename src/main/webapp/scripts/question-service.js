'use strict';

socialquizApp.factory('Question', ['$resource',
    function ($resource) {
        return $resource('app/rest/questions/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': { method: 'GET'}
        });
    }]);
