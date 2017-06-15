<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>

<script>

    var $dg;
    $(function () {
        $dg = $(".redDg");
        $dg.datagrid({
            url: '${app}/redpackage/showAllBylawerid?id=${param.id}',
            //fit:true,
            striped:true,
            width:'100%',
            height:'150',
            columns: [[
                {title: "律师名", field: "lawername", width: 200, align: 'center'},
                {title: "编号", field: "redid", width: 200, align: 'center'},
                {title: "红包", field: "redpackage", width: 200, align: 'center'},
                {title: "评论", field: "redcontent", width: 200, align: 'center'},
                {title: "用户名", field: "username", width: 200, align: 'center'},

            ]],
        });

    });

</script>

<div style="text-align: center;">
    <div data-options="region:'center',">
        <table class="redDg" ></table>
        <div class="redDa"></div>
    </div>
</div>