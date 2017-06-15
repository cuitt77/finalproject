<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>
<div style="text-align: center;">
    <form id="showlawerForm" method="post">
        <div data-options="region:'center',">
            <table class="slDg" ></table>
            <div class="slDa"></div>
        </div>

    </form>
</div>
<script>

    var $dg,$da;
    $(function () {
        $dg = $(".slDg");
        $da = $(".slDa");
        $dg.datagrid({
            url: '${app}/lawer/showAllBylawertypeid?id=${param.id}',
            //fit:true,
            striped:true,
            width:'100%',
            height:'150',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "姓名", field: "name", width: 200, align: 'center'},
                {title: "地址", field: "address", width: 200, align: 'center'},
                {title: "工龄", field: "year", width: 200, align: 'center'},
                {title: "执业号", field: "number", width: 200, align: 'center'},
                {title: "公司", field: "workspace", width: 200, align: 'center'},
                {title: "电话价钱", field: "phoneprice", width: 200, align: 'center'},
                {title: "文字价钱", field: "Wordprice", width: 200, align: 'center'},
                {title: "电话", field: "phone", width: 200, align: 'center'},
                {title: "状态", field: "status", width: 200, align: 'center'},
            ]],
        });
    });

</script>
