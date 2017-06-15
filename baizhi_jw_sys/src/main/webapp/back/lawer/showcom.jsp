<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>
<div style="text-align: center;">
    <form id="showcomForm" method="post">
        <div data-options="region:'center',">
            <table class="comDg" ></table>
            <div class="comDa"></div>
        </div>

    </form>
</div>
<script>

    var $dg,$da;
    $(function () {
        $dg = $(".comDg");
        $da = $(".comDa");
        $dg.datagrid({
            url: '${app}/comment/showAllBylawerid?id=${param.id}',
            //fit:true,
            striped:true,
            width:'100%',
            height:'150',
            columns: [[
                {title: "编号", field: "comid", width: 200, align: 'center'},
                {title: "星级", field: "score", width: 200, align: 'center'},
                {title: "内容", field: "comcontent", width: 200, align: 'center'},
                {title: "创建时间", field: "createtime", width: 200, align: 'center'},
                {title: "评价人", field: "username", width: 200, align: 'center'},
                {title: "评价人电话", field: "userphone", width: 200, align: 'center'},

            ]],
        });
    });

</script>
