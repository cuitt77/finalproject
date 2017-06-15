<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>
<div style="text-align: center;">
    <form id="updateForm" method="post">
        <div style="margin-top: 10px;">
            编 号:<input name="id"  class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            案例分类名:<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-client'"/><br/>
        </div>
    </form>
</div>
<script>
    $(function(){
        console.log("${param.id}");
        $("#updateForm").form('load','${app}/dealtype/showOne?id=${param.id}');
    });
</script>

