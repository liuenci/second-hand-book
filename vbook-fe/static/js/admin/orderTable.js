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
        columns: [
            {
                field: 'id',
                title: '编号',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'orderNo',
                title: '订单编号',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'totalPrice',
                title: '总价',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'createTime',
                title: '创建时间',
                align: 'center',
                valign: 'middle'
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
    var result = " <button class='btn btn-default btn-info' data-toggle='modal' onclick='get_data(this)'>订单详情</button>";
    return result;
}

function get_data(t) {
    var value = $(t).parents('tr').find('td').eq(1).text()
    $('#order_item_table').bootstrapTable('destroy');
    $('#order_item_table').bootstrapTable({
        url: 'http://localhost:8080/user/order/' + value,
        method: 'get',
        toolbar: "#toolbar",
        pagination: "false",
        striped: true, // 是否显示行间隔色
        //search : "true",
        uniqueId: "id",
        dataType: "json",
        pagination: false, // 是否分页
        sortable: false, // 是否启用排序
        columns: [
            {
                field: 'bookId',
                title: '编号'
            },
            {
                field: 'bookName',
                title: '书名'
            },
            {
                field: 'price',
                title: '价格'
            },
            {
                field: 'quantity',
                title: '数量'
            }]
    });
    $("#order_items_id").modal("toggle");
}

function reflashOrderList() {
    // 先销毁表格，再初始化表格
    orderTable.bootstrapTable('destroy');
    var orderNo = $('#orderNo').val()
    initOrderTable(orderNo);
}

$(function () {
    initOrderTable('')
})