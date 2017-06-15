<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#orderDg");
        $da = $("#orderDa");
        $dg.datagrid({
            url: '${app}/order/showAllByPage',
            //fit:true,
            striped:true,
            width:'100%',
            height:'90%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "内容", field: "content", width: 200, align: 'center'},
                {title: "类型", field: "type", width: 200, align: 'center'},
                {title: "状态", field: "status", width: 200, align: 'center'},

            ]],
            onLoadSuccess: function (data) {
                $(".showlawer").linkbutton({
                    plain: true,
                    iconCls: 'icon-man',
                });
            },
            pagination:true,
            pageNumber:2,
            pageSize:2,
            pageList:[2,4,6,8,10],
            toolbar: [{
                iconCls: 'icon-help',
                handler:myhelp,
            }]
        });
    });



    //帮助
    function myhelp(){
        $da.dialog({
            width:600,
            height:300,
            openAnimation:'slide',
            content:" 请仔细阅读使用手册！！别哔哔！！！",
            title:"使用小助手",
            iconCls:"icon-help",
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //关闭对话框
    function closeDa(){
        $da.dialog('close',true);
    }
</script>
    <div  class="easyui-layout" data-options="fit:true">

        <div data-options="region:'center',">
            <table id="orderDg" ></table>
            <div id="orderDa"></div>
        </div>
    </div>




