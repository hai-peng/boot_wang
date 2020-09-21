layui.use([ 'layer', 'table', 'jquery','form'], function(){
    var layer = layui.layer //弹层
        ,table = layui.table //表格
        ,$=layui.jquery
        ,form=layui.form

    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,id:"empReload"
        ,height: 420
        ,url: 'emp/findAll' //数据接口
        ,title: '员工表'
        ,page: true//开启分页
        ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'empid', title: '编号', width:80}
            ,{field: 'empname', title: '姓名', width:120}
            ,{field: 'age', title: '年龄', width: 90}
            ,{field: 'sex', title: '性别', width:80}
            ,{field: 'phone', title: '电话', width: 120}
            ,{field: 'deptname', title: '部门', width:150 ,templet: function(d){
                    return d.dept.deptname
                }}
            ,{fixed: 'right', width: 185, align:'center', toolbar: '#barDemo'}
        ]],parseData:function(rs){//数据格式解析
            return {
                "code":rs.code,	//返回状态码200
                "msg":rs.msg,	//
                "count":rs.data.total,	//总条目
                "data":rs.data.list	//具体内容
            }
        },
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        switch(obj.event){
            case 'add':
                showEmpForm();
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            layer.msg('查看操作');
        } else if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){

                // obj.del(); //删除对应行（tr）的DOM结构
                deleteEmp(data.empid);
                layer.close(index);
                //向服务端发送删除指令
            });
        } else if(layEvent === 'edit'){
            // 1. 设置dept的值
            findAllDept();
            // 2. 获取指定员工信息
            findOneEmp(data.empid);
            // 3. 默认值
            showEmpForm();
        }
    });

    function findOneEmp(empid){
        $.ajax({
            type:"post",
            url:"emp/findOneEmp",
            data:{
                "empid":empid
            },
            dataType:"json",
            success:function(rs){
                // layer.msg(rs.data.empName);
                $("input[name='empid']").val(rs.data.empid);
                $("input[name='empname']").val(rs.data.empname);
                $("input[name='age']").val(rs.data.age);
                $("input[name='phone']").val(rs.data.phone);
                $("input[value='"+rs.data.sex+"']").prop("checked", true);
                $("option[value='"+rs.data.dept.deptid+"']").prop("selected", true);
                form.render();
                // 设置完了一定及时做炫染
            }
        })
    }

    function deleteEmp(empid) {
        $.ajax({
            type:"POST",
            url:"emp/deleteEmp",
            data:{
                "empid":empid
            },
            dataType:"json",
            success:function (rs) {
                if (rs.code==0){
                    layer.msg(rs.msg);
                    table.reload("empReload",{})
                    form.render();
                }
                layer.msg(rs.msg)

            }

        })


    }
    function showEmpForm(){
        findAllDept(); // 将下拉框设置值
        form.render(); //

        layer.open({
            type: 1,
            skin: 'layui-layer-rim', //加上边框
            area: ['480px', '580px'], //宽高
            content: $("#empFrom").show(),
            btn: ['确定', '取消']
            ,yes: function(index, layero){
                $("#submitEmpBtn").click();
            },success:function(index, layero){
                //监听提交
                form.on('submit(formDemo)', function(data){
                    // layer.msg(JSON.stringify(data.field));

                    addEmp(data.field);

                    layer.closeAll();

                    return false;
                });
            }
            ,btn2: function(index, layero){
                layer.closeAll();
            }, end:function(){
                $("#empFrom").hide();
                $("#resetEmpBtn").click();
            }
        });
    }

    function addEmp(emp){
        $.ajax({
            type:"post",
            url:"emp/addEmp",
            data:emp,
            dataType:"json",
            success:function(rs){
                // 刷新表格
                table.reload("empReload", {});
            }
        })
    }

    // 获取所有部门信息
    function findAllDept(){
        $.ajax({
            type:"post",
            url:"dept/findAllDept",
            dataType:"json",
            success:function(rs){
                // 有值，则添加到下拉框中
                $("option").remove();
                for (var i = 0; i < rs.data.length; i++) {
                    $("#depts").append('<option value="'+rs.data[i].deptid+'">'+rs.data[i].deptname+'</option>')
                }
                form.render();
            }
        })
    }
});