'use strict';

socialquizApp.factory('Foo', ['$resource',
    function ($resource) {
        return $resource('app/rest/foos/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': { method: 'GET'}
        });
    }]);
