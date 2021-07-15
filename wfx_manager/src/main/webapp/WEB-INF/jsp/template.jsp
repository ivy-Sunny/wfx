<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="state_file.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>角色管理</title>
</head>
<body>

<table id="roleList" lay-filter="roleFilter"></table>

<script>
    layui.use(['table', 'layer', 'form', 'tree'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.$;
        var form = layui.form;
        var tree = layui.tree;
        //第一个实例
        table.render({
            elem: '#',
            url: '',//数据接口
            page: true, //开启分页
            limit: 10,//每页显示5条
            limits: [5, 10],
            toolbar: "#addRoleToolBar",
            cols: [[ //表头
                {field: '', title: '角色编码', sort: true, fixed: 'left'},
                {field: '', title: '', sort: true},
                {title: "操作", toolbar: "#rowBar"}
            ]]
        })
    })
</script>
</body>
</html>
