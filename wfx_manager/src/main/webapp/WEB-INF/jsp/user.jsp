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


<script>
    layui.use(['table', 'layer', 'form', 'tree'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.$;
        var form = layui.form;
        var tree = layui.tree;
        //第一个实例
        table.render({
            elem: '#userList'
            , url: 'user/findUserByPage' //数据接口
            , page: true //开启分页
            , limit: 10 //每页显示5条
            , limits: [5, 10]
            , toolbar: "#addRoleToolBar"
            , cols: [[ //表头
                {field: 'userName', title: '用户名', sort: true, fixed: 'left'},
                {field: 'account', title: '账户', edit: false},
                {field: 'userType', title: '人员类型', sort: true},
                {field: 'roleId', title: '用户角色', sort: true},
                {field: 'roleDesc', title: '用户授予角色', sort: true},
            ]]
        })
    })


</script>


</body>
</html>
