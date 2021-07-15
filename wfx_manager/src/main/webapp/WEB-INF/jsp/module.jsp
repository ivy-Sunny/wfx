<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="state_file.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>权限管理</title>
</head>
<body>
<input id="moduleCodeVal" style="display: inline-block;width: 200px;margin: 25px 0 5px 50px" type="text" name="title"
       required lay-verify="required" placeholder="请输入菜单编码" autocomplete="off" class="layui-input">
<input id="moduleNameVal" style="display: inline-block;width: 200px;margin: 25px 0 5px 20px" type="text" name="title"
       required lay-verify="required" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
<button id="search" style="margin-left: 15px" type="button" class="layui-btn">搜索</button>
<table id="moduleList" lay-filter="moduleFilter"></table>

<script>
    layui.use(['table', 'layer', 'form', 'tree'], function () {
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.$;
        var form = layui.form;
        var tree = layui.tree;
        initTable({moduleCode: "", moduleName: ""});
        //第一个实例
        $("#search").click(function () {
            var moduleCode = $("#moduleCodeVal").val();
            var moduleName = $("#moduleNameVal").val();
            initTable({moduleCode, moduleName})
        })

        function initTable(param = {}) {
            table.render({
                elem: '#moduleList',
                url: 'module/searchByPage',//数据接口
                page: true, //开启分页
                limit: 10,//每页显示5条
                limits: [5, 10],
                where: param,
                // toolbar: "#",
                cols: [[ //表头
                    {field: 'moduleCode', title: '菜单编码', sort: true, fixed: 'left'},
                    {field: 'moduleName', title: '菜单名称', sort: true},
                    {field: 'linkUrl', title: '链接地址', sort: true},
                    {title: "操作", toolbar: "#rowBar"}
                ]],
            })
        }
    })
</script>
</body>
</html>
