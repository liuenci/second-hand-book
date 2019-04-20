var bookTable = $('#bookTable');
//初始化bootstrap table ，并且启动它
function initBookTable(bookName) {
    bookName = bookName == undefined ? '' : bookName
    bookTable.bootstrapTable({
        url: 'http://localhost:8080/admin/book/list',
        method: 'get',
        queryParams: 'name=' + bookName,
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
                title: '书名'
            },
            {
                field: 'price',
                title: '价格'
            }
        ]
    });
}
function reflashBookTable() {
    // 先销毁表格，再初始化表格
    bookTable.bootstrapTable('destroy');
    let bookName = $('#bookName').val()
    initBookTable(bookName);
}
$(function () {
    initBookTable('')
})