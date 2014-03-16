'use strict';

socialquizApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/vote', {
                    templateUrl: 'views/votes.html',
                    controller: 'VoteController',
                    resolve:{
                        resolvedVote: ['Vote', function (Vote) {
                            return Vote.query();
                        }]
                    }
                })
        }]);
