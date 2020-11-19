var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {

  $scope.manutencoes = new Object();


$scope.salvar = function() {
  $http.post("http://localhost:8080/jogos", {
    'id':$scope.id,
    'titulo':$scope.nome,
    'produto':$scope.data,
    'categoria':$scope.categoria
 
        
  })
  };   
  
  $scope.buscarTodos = function() {
	  $http.get("http://localhost:8080/jogos").then(function(resposta)
		{$scope.jogos = resposta.data;
		  
		} );
  }
  $scope.buscarTodos();

});