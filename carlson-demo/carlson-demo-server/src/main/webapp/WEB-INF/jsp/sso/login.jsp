<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html >
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
<body >
<div class="container" style="position: relative;top: 40%;" align="center">
        <div class="form-group">
            <label for="usernameinput">Username</label>
            <input type="" class="form-control" id="usernameinput" placeholder="Username" style="width: 30%" value="admin">
        </div>
        <div class="form-group">
            <label for="passwordinput">Password</label>
            <input type="" class="form-control" id="passwordinput" placeholder="Password" style="width: 30%" value="carlson">
        </div>
        <button class="btn btn-default" onclick="javascript:getUser();">Sign in</button>
</div>

<script src="${basePath}/resources/carlson-admin/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/carlson-admin/plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script>
    function getUser(){
    $.ajax({
        url:"${basePath}/demo/login.do",
        type:"POST",
        data:{
            username:$("#usernameinput").val(),
            password:$("#passwordinput").val(),
        },
        success:function (result) {
           console.log(result);
           location.href = "${basePath}/manage/index";
        },
        error: function(error){
            console.log(error);
        }
    })
    }
</script>
</body>
</html>
