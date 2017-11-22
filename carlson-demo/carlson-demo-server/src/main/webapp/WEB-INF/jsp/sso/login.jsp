<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <style type="text/css">
        html,body{
            height:100%
        }
    </style>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="${basePath}/resources/carlson-admin/plugins/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet"/>
    <link href="${basePath}/resources/carlson-admin/plugins/bootstrap-3.3.7/css/bootstrap-theme.css" rel="stylesheet"/>
    <title>Demo系统</title>

</head>
<body ng-controller="LoginController">
<div class="container" style="position: relative;top: 40%;" align="center">
    <form role="form">
        <div class="form-group">
            <label for="usernameinput">Username</label>
            <input type="" class="form-control" id="usernameinput" placeholder="Username" style="width: 30%" ng-model="saveUser.name">
        </div>
        <div class="form-group">
            <label for="passwordinput">Password</label>
            <input type="password" class="form-control" id="passwordinput" placeholder="Password" style="width: 30%" ng-model="saveUser.pswd">
        </div>
     <button class="btn btn-default" ng-click="getUser()">Sign in</button>
     </form>
</div>

<script src="${basePath}/resources/carlson-admin/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/carlson-admin/plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="${basePath}/resources/carlson-admin/plugins/angular/angular-1.5.8/angular.min.js"></script>
<script>
    var BASE_PATH = '${basePath}';
    function LoginController($scope, $http){
        $scope.saveUser = {
            name:"admin",
            pswd:"admin"
        };

        $scope.getUser = function(){
            $http({
                method: "POST",
                url: "http://localhost:8080/demo/test",
                data: $scope.saveUser
            }).success(function (data, status){
                console.log(data);
            })
        };
    }
</script>
</body>
</html>
