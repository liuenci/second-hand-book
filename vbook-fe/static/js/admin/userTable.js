var userTable = $('#userTable');
//初始化bootstrap table ，并且启动它
function initUserList(userName) {
    userName = userName == undefined ? '' : userName
    userTable.bootstrapTable({
        url: 'http://localhost:8080/admin/user/list',
        method: 'get',
        queryParams: 'name=' + userName,
        toolbar: "#toolbar",
        pagination: "false",
        striped: true, // 是否显示行间隔色
        //search : "true",
        uniqueId: "id",
        dataType: "json",
        pagination: false, // 是否分页
        sortable: false, // 是否启用排序
        formatNoMatches: function () { //没有匹配的结果  
            return '无符合条件的记录';
        },
        columns: [{
                field: 'id',
                title: '编号'
            },
            {
                field: 'name',
                title: '用户名'
            },
            {
                field: 'phone',
                title: '手机号'
            },
            {
                field: 'email',
                title: '邮箱'
            },
            {
                field: 'balance',
                title: '余额'
            },
            {
                field: 'level',
                title: '推荐级别'
            },
            {
                field: 'opt',
                title: '操作',
                width: 320,
                align: 'center',
                valign: 'middle',
                formatter: actionFormatter,
            }
        ]
    });
}
//操作栏的格式化
function actionFormatter(value, row, index) {
    var status = row.role
    var result = "";
    if(status == 1) {
        result += "<button class='btn btn-default btn-primary btn-order-item' data-toggle='modal' onclick='lock_or_unlock_user(this,2)'>冻结会员</button>"
    } else if(status == 2){
        result += " <button class='btn btn-default btn-info btn-order-comment' data-toggle='modal' onclick='lock_or_unlock_user(this,1)'>解封会员</button>"
    }
    result += " <button class='btn btn-default btn-danger btn-order-comment' data-toggle='modal' onclick='deleteUserByUserId(this)'>删除会员</button>";
    return result;
}
function lock_or_unlock_user(t,type) {
    var id = $(t).parents('tr').find('td:first').text()
    id = Number(id)
    $.ajax({
        url:'http://localhost:8080/admin/user/lockOrUnLock',
        type:'post',
        data: {
            userId: id,
            userStatus: type
        },
        success: function (response) {
            if(response.status == 0) {
                if(type == 1) {
                    alert('解冻成功')
                }else if(type == 2){
                    alert('冻结成功')
                }
            }
            var _body = window.parent;
            var _iframe1=_body.document.getElementById('iframe');
            _iframe1.contentWindow.location.reload(true);
        }
    })
}
function deleteUserByUserId(t){
    var id = $(t).parents('tr').find('td:first').text()
    id = Number(id)
    $.ajax({
        url:'http://localhost:8080/admin/user/delete',
        type:'post',
        data: {
            userId: id
        },
        success: function (response) {
            if(response.status == 0) {
                alert("删除成功")
            }
            var _body = window.parent;
            var _iframe1=_body.document.getElementById('iframe');
            _iframe1.contentWindow.location.reload(true);
        }
    })
}
function reflashUserList() {
    // 先销毁表格，再初始化表格
    userTable.bootstrapTable('destroy');
    let userName = $('#userName').val()
    initUserList(userName);
}
$(function () {
    initUserList('')
})