<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#dealDg");
        $da = $("#dealDa");
        $dg.datagrid({
            url: '${app}/deal/showAllByPage',
            //fit:true,
            striped:true,
            width:'100%',
            height:'90%',
            columns: [[
                {title: "编号", field: "dealid", width: 200, align: 'center'},
                {title: "标题", field: "title", width: 200, align: 'center'},
                {title: "创建时间", field: "createtime", width: 200, align: 'center'},
                {title: "内容", field: "content", width: 200, align: 'center'},
                {title: "分类", field: "dealtypename", width: 200, align: 'center'},

            ]],

            pagination:true,
            pageNumber:1,
            pageSize:4,
            pageList:[2,4,6,8,10],
            toolbar: [{
                iconCls: 'icon-help',
                handler:myhelp,
            },{
                iconCls:'icon-add',
                handler:myadd,
            }]
        });
    });
    //添加
    function myadd(){
        $da.dialog({
            width:600,
            height:300,
            title:"添加律师",
            iconCls:"icon-man",
            href:'${app}/back/deal/adddeal.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:savedeal,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }



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
    //更新的保存用户
    function savedeal(){
        $("#insertdealForm").form('submit',{
            url:'${app}/deal/add',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //关闭对话框
    function closeDa(){
        $da.dialog('close',true);
    }
</script>
    <div  class="easyui-layout" data-options="fit:true">

        <div data-options="region:'center',">
            <table id="dealDg" ></table>
            <div id="dealDa"></div>
        </div>
    </div>




