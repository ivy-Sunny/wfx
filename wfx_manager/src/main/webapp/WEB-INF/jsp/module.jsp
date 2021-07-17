<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="state_file.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>权限管理</title>
</head>
<body>
<input id="moduleCodeVal" style="display: inline-block;width: 200px;margin: 25px 0 5px 50px" type="text"
       name="title"
       required lay-verify="required" placeholder="请输入菜单编码" autocomplete="off" class="layui-input">
<input id="moduleNameVal" style="display: inline-block;width: 200px;margin: 25px 0 5px 20px" type="text"
       name="title"
       required lay-verify="required" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
<button id="search" style="margin-left: 15px" type="button" class="layui-btn">搜索</button>
<script id="headerToolBar" type="text/html">
    <button lay-event="add" class="layui-btn layui-btn-normal ">添加角色</button>
</script>
<%--行工具--%>
<script id="rowBar" type="text/html">
    <button lay-event="delEvent" class="layui-btn layui-btn-sm layui-btn-danger ">删除</button>
</script>
<table id="moduleList" lay-filter="moduleFilter"></table>
<%--添加菜单的form--%>
<form style="display: none" class="layui-form" action="" id="addModuleForm" lay-filter="updateRoleFilter">
    <div class="layui-form-item" style="margin-top: 20px">
        <label class="layui-form-label">父级菜单</label>
        <div style="width: 350px" class="layui-input-block">
            <select name="paramModule" lay-filter="aihao">
                <c:forEach items="${modules}" var="item">
                    <option value="${item.moduleCode}">${item.moduleName}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">菜单编号</label>
        <div class="layui-input-block">
            <input style="width: 350px" type="text" name="moduleCode" lay-verify="required" placeholder="请输入菜单编号"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">菜单名称</label>
        <div class="layui-input-block">
            <input style="width: 350px" type="text" name="moduleName" lay-verify="required" placeholder="请输入菜单名称"
                   autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">菜单链接</label>
        <div class="layui-input-block">
            <input style="width: 350px" type="text" name="linkUrl" placeholder="请输入菜单链接"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

</form>
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
        table.on('edit(moduleFilter)', function (obj) { //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
            $.post("module/updateModule", obj.data, function (res) {
                if (res.success) {
                    layer.msg(res.msg, {icon: 6})
                } else {
                    layer.msg(res.msg, {icon: 5})
                }
            })
        });


        //监听表头事件
        table.on('toolbar(moduleFilter)', function (obj) {
            var layuiEvent = obj.event
            if (layuiEvent == "add") {
                //弹出一个form表单
                layer.open({
                    type: 1,
                    title: '添加角色',
                    content: $('#addModuleForm'),
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    area: ['500px', '300px'],
                    yes: function (index, layero) {
                    }
                });

            }
        })

        function initTable(param = {}) {
            table.render({
                elem: '#moduleList',
                url: 'module/searchByPage',//数据接口
                page: true, //开启分页
                limit: 10,//每页显示5条
                limits: [5, 10],
                where: param,
                toolbar: "#headerToolBar",
                // toolbar: "#",
                cols: [[ //表头
                    {field: 'moduleCode', title: '菜单编码', sort: true, fixed: 'left'},
                    {field: 'moduleName', title: '菜单名称', sort: true, edit: true},
                    {field: 'linkUrl', title: '链接地址', sort: true, edit: true},
                    {title: "操作", toolbar: "#rowBar"}
                ]],
            })
        }
    })
</script>
</body>
</html>
