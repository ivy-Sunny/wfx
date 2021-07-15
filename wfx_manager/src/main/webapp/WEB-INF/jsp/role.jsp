<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="state_file.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>角色管理</title>
</head>
<body>

<table id="roleList" lay-filter="roleFilter"></table>

<%--tree--%>
<div id="moduleTree" style="display: none"></div>
<%--表头--%>
<script id="addRoleToolBar" type="text/html">

    <button lay-event="add" class="layui-btn layui-btn-normal ">添加角色</button>

</script>

<%--行工具--%>
<script id="rowBar" type="text/html">
    <button lay-event="updateEvent" class="layui-btn layui-btn-sm layui-btn-normal ">编辑</button>
    <button lay-event="delEvent" class="layui-btn layui-btn-sm layui-btn-danger ">删除</button>
    <button lay-event="grantEvent" class="layui-btn layui-btn-sm layui-btn-warm ">授权</button>
</script>
<%--添加角色的form--%>
<form action="role/addRole" style="display: none" class="layui-form" action="" id="addRoleForm"
      lay-filter="addRoleFilter">

    <div class="layui-form-item" style="margin-top: 25px">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-block">
            <input style="width: 350px" type="text" name="roleName" lay-verify="required" placeholder="请输入角色名称"
                   autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-block">
            <input style="width: 350px" type="text" name="roleDesc" lay-verify="required" placeholder="请输入角色描述"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

</form>


<%--修改角色的form--%>
<form style="display: none" class="layui-form" action="" id="updateRoleForm" lay-filter="updateRoleFilter">
    <div class="layui-form-item" style="margin-top: 20px">
        <label class="layui-form-label">编号</label>
        <div class="layui-input-block">
            <input style="width: 350px;color: #999999" readonly type="text" name="roleCode" lay-verify="required"
                   placeholder="请输入角色名称"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-block">
            <input style="width: 350px" type="text" name="roleName" lay-verify="required" placeholder="请输入角色名称"
                   autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-block">
            <input style="width: 350px" type="text" name="roleDesc" lay-verify="required" placeholder="请输入角色描述"
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
        //第一个实例
        table.render({
            elem: '#roleList'
            , url: 'role/findByPage' //数据接口
            , page: true //开启分页
            , limit: 10 //每页显示5条
            , limits: [5, 10]
            , toolbar: "#addRoleToolBar"
            , cols: [[ //表头
                {field: 'roleCode', title: '角色编码', sort: true, fixed: 'left'}
                , {field: 'roleName', title: '角色名称', edit: true}
                , {field: 'roleDesc', title: '描述', sort: true},
                {title: "操作", toolbar: "#rowBar"}
            ]]
        });
        //监听表头事件
        table.on('toolbar(roleFilter)', function (obj) {
            var layuiEvent = obj.event
            console.log(layuiEvent)
            switch (layuiEvent) {
                case 'add':

                    //form表单置为空
                    form.val("addRoleFilter", {
                        "roleCode": ""
                        , "roleName": ""
                        , "roleDesc": ""
                    });

                    //弹出一个form表单
                    layer.open({
                        type: 1,
                        title: '添加角色',
                        content: $('#addRoleForm'),
                        btn: ['确定', '取消'],
                        btnAlign: 'c',
                        area: ['500px', '300px'],
                        yes: function (index, layero) {
                            //请求
                            $.post("role/addRole", $("#addRoleForm").serialize(), function (res) {
                                if (res.success) {
                                    layer.msg(res.msg, {icon: 6});
                                } else {
                                    layer.msg(res.msg, {icon: 5});
                                }

                                //表格reload
                                table.reload('roleList', {
                                    page: {
                                        curr: 1 //重新从第 1 页开始
                                    }
                                });
                                layer.close(index)
                            })
                        }
                    });


                    break;
                case 'delete':
                    layer.msg('删除');
                    break;
                case 'update':
                    layer.msg('编辑');
                    break;
            }
            ;
        });

        //监听行工具事件
        table.on('tool(roleFilter)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event;
            if (layEvent === 'updateEvent') { //编辑
                //数据回显
                form.val("updateRoleFilter", {
                    "roleCode": data.roleCode
                    , "roleName": data.roleName
                    , "roleDesc": data.roleDesc

                });
                console.log($("#updateRoleForm").serialize())
                //弹出layer
                layer.open({
                    type: 1,
                    title: '修改角色',
                    content: $('#updateRoleForm'),
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    area: ['500px', '300px'],
                    yes: function (index, layero) {
                        //请求
                        $.post("role/updateRole", $("#updateRoleForm").serialize(), function (res) {
                            if (res.success) {
                                layer.msg(res.msg, {icon: 6});
                            } else {
                                layer.msg(res.msg, {icon: 5});
                            }

                            //表格reload
                            table.reload('roleList', {
                                page: {
                                    curr: 1 //重新从第 1 页开始
                                }
                            });
                            layer.close(index)
                        })
                    }
                });


            } else if (layEvent === 'delEvent') {//删除
                layer.confirm('确定删除吗?', {icon: 3, title: '提示'}, function (index) {
                    //获取roleCode
                    var roleCode = data.roleCode;
                    $.get("role/delRole?roleCode=" + roleCode, function (res) {
                        if (res.success) {
                            layer.msg(res.msg, {icon: 6});
                        } else {
                            layer.msg(res.msg, {icon: 5});
                        }

                        //表格reload
                        table.reload('roleList', {
                            page: {
                                curr: 1 //重新从第 1 页开始
                            }
                        });
                        layer.close(index)
                    });


                    layer.close(index);
                });
            } else if (layEvent === 'grantEvent') {
                layer.open({
                    type: 1,
                    title: '授权',
                    content: $('#moduleTree'),
                    btn: ['确定', '取消'],
                    btnAlign: 'c',
                    area: ['450px', '600px'],
                    success: function (e) {
                        $.get('role/findTree?roleCode=' + data.roleCode, function (res) {
                            tree.render({
                                showCheckbox: true,
                                elem: '#moduleTree',
                                data: res,
                                id: "treeId",
                            })
                        })
                    },
                    yes: function (e) {
                        var checkData = tree.getChecked('treeId');
                        let checkedIds = [];
                        $.each(checkData, function (index, item) {
                            if (item.children.length == 0) {
                                checkedIds.push(item.id);
                            }
                        })
                        $.post("role/updateTree", {
                            roleCode: data.roleCode,
                            checkedIds: JSON.stringify(checkedIds)
                        }, function (res) {

                        })
                    }
                })
            }
        });
    });


</script>


</body>
</html>
