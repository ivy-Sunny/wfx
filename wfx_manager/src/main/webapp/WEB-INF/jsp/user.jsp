<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="state_file.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>角色管理</title>
</head>
<body>

<table id="userList" lay-filter="roleFilter"></table>
<%--表头--%>
<script id="addUserToolBar" type="text/html">
    <button lay-event="add" class="layui-btn layui-btn-normal ">添加用户</button>
</script>
<%--列表--%>
<script type="text/html" id="roleSelecy">
    <select name="" lay-verify="" lay-filter="selectFilter">
        <c:forEach items="${roles}" var="r">
            <option value="${r.roleCode}">${r.roleName}</option>
        </c:forEach>
    </select>
</script>
<script>
    layui.use(['table', 'layer', 'form', 'tree'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.$;
        var form = layui.form;
        var tree = layui.tree;
        //第一个实例
        table.render({
            elem: '#userList',
            url: 'user/findUserByPage',//数据接口
            page: true,//开启分页
            limit: 10, //每页显示5条
            limits: [5, 10],
            toolbar: "#addUserToolBar",
            cols: [[ //表头
                {field: 'userName', title: '用户名', sort: true, fixed: 'left'},
                {field: 'account', title: '账户', edit: false},
                {
                    field: 'userType', title: '人员类型', sort: true, templet: function (data) {
                        const key = {
                            1: '客服账号',
                            2: '管理账号',
                            3: '内置账号',
                            4: '财务账号',
                            5: "物流账号"
                        }
                        return key[data.userType];
                    }
                },
                {
                    field: 'roles', title: '用户角色', templet: function (data) {
                        return data.roles.length > 0 ? data.roles[0].roleName : "-";
                    }
                },
                {field: 'roleDesc', title: '授予角色', templet: "#roleSelecy"},
            ]]
        })
        form.on("select(selectFilter)",function (data){
            console.log(data.elem)
            console.log(data.value)
        })
    })


</script>


</body>
</html>
