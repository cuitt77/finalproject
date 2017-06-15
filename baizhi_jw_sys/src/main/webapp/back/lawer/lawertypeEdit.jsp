<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>
<div style="text-align: center;">
    <div data-options="region:'center',">
        <table class="updatelawertypeDg" ></table>
        <div class="updatelawertypeDa"></div>
    </div>
    <form id="updatelawertypeForm" method="post">

        <div style="margin-top: 10px;">
            选择分类：<input class="cc" name="lawertypeid"/><br/>
        </div>
    </form>
</div>
<script>

    var $dg,$da;
    $(function () {
        $dg = $(".updatelawertypeDg");
        $da = $(".updatelawertypeDa");
        $dg.datagrid({
            url: '${app}/lawertype/showAllBylawerid?id=${param.id}',
            //fit:true,
            striped:true,
            width:'100%',
            height:'150',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "名", field: "name", width: 200, align: 'center'},

            ]],
        });
    });


    $('.cc').combobox({
        required:true,
        multiple:true,
        url:'${app}/lawertype/showAll',
        valueField:'id',
        textField:'name',
    });
</script>
