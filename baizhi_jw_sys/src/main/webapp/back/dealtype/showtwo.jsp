<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/util.jsp"%>

<script>

    var $dg,$da;
    $(function () {
        $dg = $(".twotypeDg");
        $da = $(".twotypeDa");
        $dg.datagrid({
            url: '${app}/dealtype/showAlltwobyone?id=${param.id}',
            //fit:true,
            striped:true,
            width:'100%',
            height:'300',
            columns: [[
                {title: "编号", field: "id", width: 200, align: 'center'},
                {title: "分类名名", field: "name", width: 200, align: 'center'},
                {
                    title: "操作", field: "options", width: 400, align: 'center',
                    formatter: function (value, row, index) {
                        return  "<a class='edit' onClick=\"editRow('" + row.id + "')\"  href='javascript:;'>修改二级</a>";
                    }
                }
            ]],

            onLoadSuccess: function (data) {

                $(".edit").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });


            },
            pagination:true,
            toolbar: [{
                width:80,
                iconCls:'icon-add',
                text:"添加",
                handler:myadd,
            }]

        });

    });

    //修改
    function editRow(id){
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
    //添加
    function myadd(){
        $da.dialog({
            width:600,
            height:300,
            title:"添加二级分类",
            iconCls:"icon-man",
            href:'${app}/back/dealtype/addTwo.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveTwo,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDa,
            }],
        });
    }
    //添加的保存用户
    function saveTwo(){
        $("#twoForm").form('submit',{
            url:'${app}/dealtype/addTwo?tid='+${param.id},
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

<div style="text-align: center;">
    <div data-options="region:'center',">
        <table class="twotypeDg" ></table>
        <div class="twotypeDa"></div>
    </div>
</div>