var orderTable = $('#orderTable');
//初始化bootstrap table ，并且启动它
function initOrderTable(orderNo) {
    orderNo = orderNo == undefined ? '' : orderNo
    orderTable.bootstrapTable({
        url: 'http://localhost:8080/admin/order/list',
        method: 'get',
        queryParams: 'orderNo=' + orderNo,
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
                field: 'orderNo',
                title: '订单编号'
            },
            {
                field: 'totalPrice',
                title: '总价'
            },
            {
                field: 'createTime',
                title: '创建时间'
            }
        ]
    });
}
function reflashOrderList() {
    // 先销毁表格，再初始化表格
    orderTable.bootstrapTable('destroy');
    let orderNo = $('#orderNo').val()
    initOrderTable(orderNo);
}
$(function () {
    initOrderTable('')
})