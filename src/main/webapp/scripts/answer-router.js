'use strict';

socialquizApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/answer', {
                    templateUrl: 'views/answers.html',
                    controller: 'AnswerController',
                    resolve:{
                        resolvedAnswer: ['Answer', function (Answer) {
                            return Answer.query();
                        }]
                    }
                })
        }]);
