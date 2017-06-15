<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>
<div style="text-align: center;">
    <form id="updateForm" method="post">
        <div style="margin-top: 10px;">
            用户名:<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            地 址:<input name="address" class="easyui-textbox" data-options="required:true,iconCls:'icon-money_dollar'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            工 龄:<input  name="year" class="easyui-textbox" data-options="required:true,iconCls:'icon-cake'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            执业证号:<input name="number" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            律所:<input name="workspace" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            简 介:<input name="description" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            文字咨询价格:<input name="wordprice" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            电话咨询价格:<input name="phoneprice" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            头 像:<input name="photo" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            状 态:<input name="status" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            电 话:<input name="phone" class="easyui-textbox" data-options="required:true"/><br/>
        </div>

    </form>
</div>
<script>
    $(function(){
        console.log("${param.id}");
        $("#updateForm").form('load','${app}/lawer/showOne?id=${param.id}');
    });



</script>

