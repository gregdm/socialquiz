'use strict';

socialquizApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/question', {
                    templateUrl: 'views/questions.html',
                    controller: 'QuestionController',
                    resolve:{
                        resolvedQuestion: ['Question', function (Question) {
                            return Question.query();
                        }]
                    }
                })
        }]);
