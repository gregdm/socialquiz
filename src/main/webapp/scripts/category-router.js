'use strict';

socialquizApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/category', {
                    templateUrl: 'views/categorys.html',
                    controller: 'CategoryController',
                    resolve:{
                        resolvedCategory: ['Category', function (Category) {
                            return Category.query();
                        }]
                    }
                })
        }]);
