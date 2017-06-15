<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>

<script>

    var $dg;
    $(function () {
        $dg = $(".orDg");
        $dg.datagrid({
            url: '${app}/order/showAllByuserid?id=${param.id}',
            //fit:true,
            striped:true,
            width:'100%',
            height:'150',
            columns: [[
                {title: "订单号", field: "orderid", width: 200, align: 'center'},
                {title: "内容", field: "ordercontent", width: 200, align: 'center'},
                {title: "类型", field: "type", width: 200, align: 'center'},
                {title: "状态", field: "status", width: 200, align: 'center'},
                {title: "评价星数", field: "score", width: 200, align: 'center'},
                {title: "评价内容", field: "comcontent", width: 200, align: 'center'},

            ]],
        });

    });

</script>

<div style="text-align: center;">
    <div data-options="region:'center',">
        <table class="orDg" ></table>
        <div class="orDa"></div>
    </div>
</div>