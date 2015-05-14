<%-- 
    Document   : admin
    Created on : 13/05/2015, 11:39:26 PM
    Author     : Fabrizzio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:set var="ListaLibros" scope="session" value="${sessionScope.ListaLibros}"/>
<!DOCTYPE html>

<html lang="en" ng-app="AppAngular">
<head>
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/0.8.3/angular-material.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=RobotoDraft:300,400,500,700,400italic">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="https://raw.github.com/daneden/animate.css/master/animate.css">
  <meta name="viewport" content="initial-scale=1" />

  <style type="text/css">


  </style>
</head>
<body layout="column" ng-controller="AppCtrl">
  <md-toolbar layout="row">
  <h1 class="md-toolbar-tools" layout-align-gt-sm="center">Biblioteca</h1>
</md-toolbar>
<div layout="column" flex id="content">
  <md-content layout="column" flex class="md-padding">


    <c:forEach var ="libro" items="${ListaLibros}">

    <md-card>
    <md-card-content>
    <div layout="column" layout-align="space-around center">
    <h2><c:out value="${libro.getTitulo()}"/></h2>
    <h2>Autor: <c:out value="${libro.getAutor()}"/></h2>
    <div layout="column" layout-align="space-around center">
        <md-button class="md-raised md-primary" href='/mostraruno.jsp?isbn=<c:out value="${libro.getIsbn()}"/>' >Ver Libro</md-button>
        <md-button class="md-raised md-primary" type="submit">Editar Estado</md-button>
    </div>
    </div>
    

    </md-card-content>
    </md-card>            

        </c:forEach>

    


</md-content>
</div>

<!-- Angular Material Dependencies -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.8.3/angular-material.min.js"></script>

<script>
angular.module('AppAngular', ['ngMaterial'])
.config(function($mdThemingProvider) {
 $mdThemingProvider.theme('default')
 .primaryPalette('red')
 .accentPalette('grey');
})
.controller('AppCtrl', function($scope,$location){


});
</script>
</body>
</html>
