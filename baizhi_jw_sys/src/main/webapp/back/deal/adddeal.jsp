<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>
<div style="text-align: center;">
	<form id="insertdealForm" method="post">

		<div style="margin-top: 10px;">
			标 题:<input name="title" class="easyui-textbox" data-options="required:true,iconCls:'icon-money_dollar'"/><br/>
		</div>

		<div style="margin-top: 10px;">
			内容:<input name="content" class="easyui-textbox" data-options="required:true"/><br/>
		</div>
		<%--<div style="margin-top: 10px;">--%>
			<%--一级分类：<input class="oo" name="oneid"/><br/>--%>
		<%--</div>--%>
		<%--<div style="margin-top: 10px;">--%>
			<%--二级分类：<input class="tt" name="twoid"/><br/>--%>
		<%--</div>--%>
		<input  id="cc1" class="easyui-combobox" data-options="
        valueField: 'id',
        textField: 'name',
        url: '${app}/dealtype/showAll',
        onSelect: function(rec){
            var url = '${app}/dealtype/showAlltwobyone?id='+rec.id;
            $('#cc2').combobox('reload', url);
        }" />
		<input name="tt" id="cc2" class="easyui-combobox" data-options="valueField:'id',textField:'name'" />
	</form>
</div>
<script>
	<%--$('.oo').combobox({--%>
		<%--required:true,--%>
		<%--multiple:true,--%>
		<%--url:'${app}/dealtype/showAll',--%>
		<%--valueField:'id',--%>
		<%--textField:'name',--%>

	<%--});--%>
	<%--$('.tt').combobox({--%>
		<%--required:true,--%>
		<%--multiple:true,--%>
		<%--url:'${app}/dealtype/showtwpbyone?id='+,--%>
		<%--valueField:'id',--%>
		<%--textField:'name',--%>

	<%--});--%>
</script>