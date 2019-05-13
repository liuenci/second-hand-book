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
        columns: [
            {
                field: 'id',
                title: '编号',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'name',
                title: '书名',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'author',
                title: '作者',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'originalPrice',
                title: '原价',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'discount',
                title: '折旧率',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'price',
                title: '现价',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'status',
                title: '状态',
                align: 'center',
                valign: 'middle',
                formatter: actionFormatter
            },
            {
                field: 'bindingType',
                title: '装订方式',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'press',
                title: '出版社',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'paperType',
                title: '纸张类型',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'paperNumber',
                title: '页数',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'isbn',
                title: 'ISBN',
                align: 'center',
                valign: 'middle'
            },
            {
                field: 'opt',
                title: '操作',
                width: 320,
                align: 'center',
                valign: 'middle',
                formatter: optFormatter,
            }
        ]
    });
}
//操作栏的格式化
function optFormatter(value, row, index) {
    var result = ""
    if (row.status == 1) {
        result = "<button class='btn btn-default btn-success' data-toggle='modal' onclick='get_data(this)'>下架</button>"
    } else if (row.status == 2) {
        result = "<button class='btn btn-default btn-info' data-toggle='modal' onclick='get_data(this)'>上架</button>"
    }
    return result;
}
function actionFormatter(value, row, index) {
    var result = ""
    if (row.status == 1) {
        result = "<p class='text-primary'>在售</p>"
    } else if (row.status == 0) {
        result = "<p class='text-success'>已售</p>"
    }else if (row.status == 2) {
        result = "<p class='text-info'>下架</p>"
    }
    return result;
}
function reflashBookTable() {
    // 先销毁表格，再初始化表格
    bookTable.bootstrapTable('destroy');
    var bookName = $('#bookName').val()
    initBookTable(bookName);
}

$(function () {
    initBookTable('')
})