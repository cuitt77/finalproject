<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $(".laDg");
        $da = $(".laDa");
        $dg.datagrid({
            url: '${app}/lawer/showAll',
            //fit:true,
            striped:true,
            width:'100%',
            height:'90%',
            columns: [[
                {title: "头像", field: "myphoto", width: 200, align: 'center',
                formatter:function (value, row, index) {
                    return "<img src=${app}/lawerphoto/"+row.photo+"></img>"
                }
                },
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "姓名", field: "name", width: 200, align: 'center'},
                {title: "地址", field: "address", width: 200, align: 'center'},
                {title: "电话", field: "phone", width: 200, align: 'center'},
                {
                    title: "操作", field: "options", width: 400, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='del' onClick=\"del('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改基本信息</a>"+
                                "<a class='updatetype' onClick=\"updatetype('" + row.id + "')\"  href='javascript:;'>修改分类</a>"+
                                "<a class='showred' onClick=\"showred('" + row.id + "')\"  href='javascript:;'>显示红包</a>"+
                                "<a class='showcom' onClick=\"showcom('" + row.id + "')\"  href='javascript:;'>显示评价</a>";
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
                $(".updatetype").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
                $(".showred").linkbutton({
                    plain: true,
                });
                $(".showcom").linkbutton({
                    plain: true,
                });
            },
            pagination:true,
            pageNumber:1,
            pageSize:4,
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
                $.post("${app}/lawer/delete",{id:id});
                $dg.datagrid('reload');
            }
        });
    }
       //修改
    function editRow(id){
        $da.dialog({
            width:600,
            height:300,
            title:"律师的详细信息",
            iconCls:"icon-man",
            href:'${app}/back/lawer/lawerEdit.jsp?id='+id,
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

    //修改专长
    function updatetype(id){
        alert("改");
        $da.dialog({
            width:600,
            height:300,
            title:"律师的分类",
            iconCls:"icon-man",
            href:'${app}/back/lawer/lawertypeEdit.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:savetype(id),
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //查看评价
    function showcom(id){
        $da.dialog({
            width:600,
            height:300,
            title:"律师的评价",
            iconCls:"icon-man",
            href:'${app}/back/lawer/showcom.jsp?id='+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //查看红包
    function showred(id){
        $da.dialog({
            width:600,
            height:300,
            title:"律师的红包",
            iconCls:"icon-man",
            href:'${app}/back/lawer/showred.jsp?id='+id,
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
            href:'${app}/back/lawer/addLawer.jsp',
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
    //保存用户分类s avetype(id)
    function savetype(id){
        alert("保存");
        $("#updatelawertypeForm").form('submit',{
            url:'${app}/lawer/updatetype?id='+id,
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //保存用户
    function saveStu(){
        $("#updateForm").form('submit',{
            url:'${app}/lawer/update',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //保存用户1
    function saveStu1(){
        $("#insertForm").form('submit',{
            url:'${app}/lawer/add',
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
            <table class="laDg" ></table>
            <div class="laDa"></div>
        </div>
    </div>




