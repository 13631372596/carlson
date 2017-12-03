<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <title>Demo系统_manage首页</title>

</head>
<body >
<div class="container" style="position: relative;top: 40%;" align="center">
    <shiro:hasPermission name="add"><a href="javascript:add();">add</a></shiro:hasPermission>
    <shiro:hasPermission name="edit"><a href="javascript:edit();">add</a></shiro:hasPermission>
</div>

<script src="${basePath}/resources/carlson-admin/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/carlson-admin/plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script>
    function add() {
        $.ajax({
            url:"${basePath}/manage/add",
            type:"POST",
            data:{
            },
            success:function (result) {
                console.log(result);
            },
            error: function(error){
                console.log(error);
            }
        })
    }
</script>
</body>
</html>
