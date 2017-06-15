<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>

<script>

    var $dg;
    $(function () {
        $dg = $(".userlawerDg");
        $dg.datagrid({
            url: '${app}/user/showAllByuserid?id=${param.id}',
            //fit:true,
            striped:true,
            width:'100%',
            height:'150',
            columns: [[
                {title: "律师名", field: "lawername", width: 200, align: 'center'},
                {title: "律师地址", field: "address", width: 200, align: 'center'},
                {title: "执业号", field: "number", width: 200, align: 'center'},
                {title: "工龄", field: "year", width: 200, align: 'center'},
                {title: "律师电话", field: "lawerphone", width: 200, align: 'center'},
                {title: "状态", field: "lawerstatus", width: 200, align: 'center'},
                {title: "用户名", field: "username", width: 200, align: 'center'},

            ]],
        });

    });

</script>

<div style="text-align: center;">
    <div data-options="region:'center',">
        <table class="userlawerDg" ></table>
        <div class="userlawerDa"></div>
    </div>
</div>