'use strict';

socialquizApp.controller('AnswerController', ['$scope', 'resolvedAnswer', 'Answer',
    function ($scope, resolvedAnswer, Answer) {

        $scope.answers = resolvedAnswer;

        $scope.create = function () {
            Answer.save($scope.answer,
                function () {
                    $scope.answers = Answer.query();
                    $('#saveAnswerModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.answer = Answer.get({id: id});
            $('#saveAnswerModal').modal('show');
        };

        $scope.delete = function (id) {
            Answer.delete({id: id},
                function () {
                    $scope.answers = Answer.query();
                });
        };

        $scope.clear = function () {
            $scope.answer = {id: "", sampleTextAttribute: "", sampleDateAttribute: ""};
        };
    }]);
