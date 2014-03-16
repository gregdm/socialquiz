'use strict';

socialquizApp.controller('QuestionController', ['$scope', 'resolvedQuestion', 'Question',
    function ($scope, resolvedQuestion, Question) {

        $scope.questions = resolvedQuestion;

        $scope.create = function () {
            Question.save($scope.question,
                function () {
                    $scope.questions = Question.query();
                    $('#saveQuestionModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.question = Question.get({id: id});
            $('#saveQuestionModal').modal('show');
        };

        $scope.delete = function (id) {
            Question.delete({id: id},
                function () {
                    $scope.questions = Question.query();
                });
        };

        $scope.clear = function () {
            $scope.question = {id: "", statement: "", answer: "", category: "", hint: "", vote: ""};
        };
    }]);
