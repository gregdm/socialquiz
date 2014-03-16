'use strict';

socialquizApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/statement', {
                    templateUrl: 'views/statements.html',
                    controller: 'StatementController',
                    resolve:{
                        resolvedStatement: ['Statement', function (Statement) {
                            return Statement.query();
                        }]
                    }
                })
        }]);
