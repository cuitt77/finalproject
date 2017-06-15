<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#ltDg");
        $da = $("#ltDa");
        $dg.datagrid({
            url: '${app}/lawertype/showAllByPage',
            //fit:true,
            striped:true,
            width:'100%',
            height:'90%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "律师分类名", field: "name", width: 200, align: 'center'},
                {
                    title: "操作", field: "options", width: 300, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"del('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改</a>"+
                                "<a class='showlawer' onClick=\"showlawer('" + row.id + "')\"  href='javascript:;'>查看分类下律师</a>";
                    }
                }
            ]],
            onLoadSuccess: function (data) {
                $(".del").linkbutton({
                    plain: true,
                    iconCls: 'icon-remove',
                });
                $(".edit").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
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
                iconCls: 'icon-edit',
                handler: function(){alert('编辑按钮')}
            },'-',{
                iconCls: 'icon-help',
                handler:myhelp,
            },'-',{
                width:80,
                iconCls:'icon-add',
                text:"添加",
                handler:myadd,
            }]
        });
    });
    //删除
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.post("${app}/lawertype/delete",{id:id});
                $dg.datagrid('reload');
            }
        });
    }
    //修改
    function editRow(id){
        $da.dialog({
            width:600,
            height:300,
            title:"员工的详细信息",
            iconCls:"icon-man",
            href:'${app}/back/lawertype/lawertypeEdit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveStu,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //查看分类下律师
    function showlawer(id){
        $da.dialog({
            width:600,
            height:300,
            title:"所有律师",
            iconCls:"icon-man",
            href:'${app}/back/lawertype/showlawer.jsp?id='+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }

//添加
    function myadd(){
        $da.dialog({
            width:600,
            height:300,
            title:"添加律师",
            iconCls:"icon-man",
            href:'${app}/back/lawertype/addLawertype.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveStu1,
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
    //保存用户
    function saveStu(){
        $("#lawertypeupdateForm").form('submit',{
            url:'${app}/lawertype/update',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //保存用户1
    function saveStu1(){
        $("#insertForm").form('submit',{
            url:'${app}/lawertype/add',
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
    //搜索的处理程序
    function search(value,name){
        console.log(value);
        console.log(name);
        $.post("/myeasyui/emp/selectByWhat",{name:value,flag:name});
        $dg.datagrid('load',{
           name:value
        });
    }
</script>
    <div  class="easyui-layout" data-options="fit:true">
        <div data-options="region:'north'," style="height:50px;">
            <div style="text-align: center;margin: 10px 0px 10px 0px;">
                <input id="ss" class="easyui-searchbox" style="width:300px"
                       data-options="searcher:search,prompt:'Please Input Value',menu:'#mm'"/>
                <div id="mm" style="width:120px">
                    <div data-options="name:'name'">名称</div>
                    <div data-options="name:'age'">年龄</div>
                </div>
            </div>
        </div>
        <div data-options="region:'center',">
            <table id="ltDg" ></table>
            <div id="ltDa"></div>
        </div>
    </div>




