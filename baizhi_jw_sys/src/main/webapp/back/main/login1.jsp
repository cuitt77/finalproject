<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/util.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/themes/ui-sunny/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/easyui-lang-zh_CN.js"></script>
    <script>

       $(function () {
           $("#btn").linkbutton({
               onClick:test1,
           })
       })
       function test1() {
           $('#loginForm').form('submit', {
               url:"${pageContext.request.contextPath}/admin/login",

           });
       }
        console.log(name);




    </script>
</head>
<form id="loginForm" method="post">
    <div style="margin-top: 70px;">
        用户名:<input id="name" name="adminname" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
    </div>
    <div style="margin-top: 10px;">
        密码:<input id="password" name="password" class="easyui-passwordbox" data-options="required:true"/><br/>
    </div>
    <div style="margin-top: 10px;">
        <input id="btn" class="easyui-linkbutton" value="确定"/><br/>
    </div>
</form>
</div>
</html>

