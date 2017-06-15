<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>

<script>

    var $dg;
    $(function () {
        $dg = $(".userredDg");
        $dg.datagrid({
            url: '${app}/redpackage/showAllByuserid?id=${param.id}',
            //fit:true,
            striped:true,
            width:'100%',
            height:'150',
            columns: [[
                {title: "律师名", field: "lawername", width: 200, align: 'center'},
                {title: "红包编号", field: "redid", width: 200, align: 'center'},
                {title: "金额", field: "redpackage", width: 200, align: 'center'},
                {title: "红包内容", field: "redcontent", width: 200, align: 'center'},
                {title: "用户名", field: "username", width: 200, align: 'center'},

            ]],
        });

    });

</script>

<div style="text-align: center;">
    <div data-options="region:'center',">
        <table class="userredDg" ></table>
        <div class="userredDa"></div>
    </div>
</div>