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
            }
        ]
    });
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