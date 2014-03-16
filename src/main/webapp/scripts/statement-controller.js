'use strict';

socialquizApp.controller('StatementController', ['$scope', 'resolvedStatement', 'Statement',
    function ($scope, resolvedStatement, Statement) {

        $scope.statements = resolvedStatement;

        $scope.create = function () {
            Statement.save($scope.statement,
                function () {
                    $scope.statements = Statement.query();
                    $('#saveStatementModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.statement = Statement.get({id: id});
            $('#saveStatementModal').modal('show');
        };

        $scope.delete = function (id) {
            Statement.delete({id: id},
                function () {
                    $scope.statements = Statement.query();
                });
        };

        $scope.clear = function () {
            $scope.statement = {id: "", sampleTextAttribute: "", sampleDateAttribute: ""};
        };
    }]);
