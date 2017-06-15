<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/util.jsp"%>
<script>
    var $dg,$da;
    $(function () {
        $dg = $("#onetypeDg");
        $da = $("#onetypeDa");
        $dg.datagrid({
            url: '${app}/dealtype/showAllByPage',
            //fit:true,
            striped:true,
            width:'100%',
            height:'90%',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "一级分类名", field: "name", width: 200, align: 'center'},
                {
                    title: "操作", field: "options", width: 400, align: 'center',
                    formatter: function (value, row, index) {
                        return   "<a class='showtwo' onClick=\"showtwo('" + row.id + "')\"  href='javascript:;'>显示二级</a>"+
                                "<a class='edit' onClick=\"edit('" + row.id + "')\"  href='javascript:;'>修改</a>";
                    }
                }
            ]],
            onLoadSuccess: function (data) {

                $(".edit").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
                $(".showtwo").linkbutton({
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
                width:80,
                iconCls:'icon-add',
                text:"添加",
                handler:myadd,
            }]
        });
    });

       //修改
    function edit(id){
        $da.dialog({
            width:600,
            height:300,
            title:"律师的详细信息",
            iconCls:"icon-man",
            href:'${app}/back/dealtype/dealtypeEdit.jsp?id='+id,
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

    //查看二级
    function showtwo(id){
        $da.dialog({
            width:800,
            height:300,
            title:"二级分类",
            iconCls:"icon-man",
            href:'${app}/back/dealtype/showtwo.jsp?id='+id,
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
            href:'${app}/back/dealtype/addOne.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveOne,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }

    //更新的保存用户
    function saveStu(){
        $("#updateForm").form('submit',{
            url:'${app}/dealtype/update',
            success:function(){
                $da.dialog('close',true);
                $dg.datagrid('reload');
            }
        });
    }
    //添加的保存用户
    function saveOne(){
        $("#oneForm").form('submit',{
            url:'${app}/dealtype/addOne',
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
            <table id="onetypeDg" ></table>
            <div id="onetypeDa"></div>
        </div>
    </div>




