<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head runat="server">
    <title>就问后台管理登录界面-www.16sucai.com</title>
    <link href="${pageContext.request.contextPath}/easyui/css/alogin.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/themes/ui-sunny/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/css/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/js/easyui-lang-zh_CN.js"></script>
    <script>
        var $btn;
        var $loginff;
        $(function () {
            $btn=$("#btn");
            $loginff=$("#form1");
        })
        function test1() {
            $loginff.form('submit',{
                url:"${pageContext.request.contextPath}/admin/login",
                success:function (result) {
                    var data = eval('('+result+')');
                    if(data.temp){

                        window.location.href="${pageContext.request.contextPath}/back/main/main.jsp"
                    }else {
                        window.location.href="${pageContext.request.contextPath}/back/main/login.jsp"
                    }
                }
            })
        }
    </script>
</head>
<body>
<form id="form1" runat="server">
    <div class="Main">
        <ul>
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB"><span>
                <img src="${pageContext.request.contextPath}/easyui/images/login/logo.gif" alt="" style="" />
            </span></li>
            <li class="topC"></li>
            <li class="topD">
                <ul class="login">
                    <li><span class="left">用户名：</span> <span style="left">
                        <input id="Text1" name="adminname" type="text" class="txt" />

                    </span></li>
                    <li><span class="left">密 码：</span> <span style="left">
                       <input id="Text2" name="password" type="text" class="txt" />
                    </span></li>

                </ul>
            </li>
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B"></li>
            <li class="middle_C">
            <span class="btn">

                <img alt="" onclick="test1()" src="${pageContext.request.contextPath}/easyui/images/login/btnlogin.gif" />


            </span>
            </li>
            <li class="middle_D"></li>
            <li class="bottom_A"></li>
            <li class="bottom_B">
                第九组就问律师后台
            </li>
        </ul>
    </div>
</form>
</body>
</html>

