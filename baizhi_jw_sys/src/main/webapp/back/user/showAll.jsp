<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#userDg");
        $da = $("#userDa");
        $dg.datagrid({
            url: '${app}/user/showAllByPage',
            //fit:true,
            striped:true,
            width:'100%',
            height:'90%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "余额", field: "money", width: 200, align: 'center'},
                {title: "用户名", field: "name", width: 200, align: 'center'},
                {title: "电话", field: "phone", width: 200, align: 'center'},
                {
                    title: "操作", field: "options", width: 400, align: 'center',
                    formatter: function (value, row, index) {
                        return "<a class='showorder' onClick=\"showorder('" + row.id + "')\"  href='javascript:;'>查看该用户所有订单</a>"+
                                "<a class='showuserred' onClick=\"showuserred('" + row.id + "')\"  href='javascript:;'>查看该用户所红包</a>"+
                                "<a class='showfav' onClick=\"showfav('" + row.id + "')\"  href='javascript:;'>查看该用户收藏的律师</a>";
                    }
                }
            ]],
            onLoadSuccess: function (data) {
                $(".showorder").linkbutton({
                    plain: true,
                    iconCls: 'icon-man',
                });
                $(".showuserred").linkbutton({
                    plain: true,
                    iconCls: 'icon-user_female',
                });
                $(".showfav").linkbutton({
                    plain: true,
                    iconCls: 'icon-medal_bronze_2',
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


    //查看所有订单
    function showorder(id){
        $da.dialog({
            width:600,
            height:300,
            title:"所有订单",
            iconCls:"icon-man",
            href:'${app}/back/user/showorder.jsp?id='+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }

    //查看所有红包
    function showuserred(id){
        $da.dialog({
            width:600,
            height:300,
            title:"所有红包",
            iconCls:"icon-man",
            href:'${app}/back/user/showred.jsp?id='+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //查看所有律师
    function showfav(id){
        $da.dialog({
            width:600,
            height:300,
            title:"所有红包",
            iconCls:"icon-man",
            href:'${app}/back/user/showlawer.jsp?id='+id,
            buttons:[{
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
    //关闭对话框
    function closeDa(){
        $da.dialog('close',true);
    }
</script>
    <div  class="easyui-layout" data-options="fit:true">

        <div data-options="region:'center',">
            <table id="userDg" ></table>
            <div id="userDa"></div>
        </div>
    </div>




