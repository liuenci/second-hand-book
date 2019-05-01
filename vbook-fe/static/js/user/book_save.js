var imageData = []; //多图上传返回的图片属性接受数组  这里是因为我在做表单其他属性提交的时候使用，在这里我没有将别的input写出来
    $("#img").fileinput({
        language: 'zh',
        uploadUrl: "http://localhost:8080/book/upload",
        showUpload: true, //是否显示上传按钮
        showRemove: true, //显示移除按钮
        showPreview: true, //是否显示预览
        showCaption: false,//是否显示标题
        autoReplace: true,
        minFileCount: 0,
        uploadAsync: true,
        maxFileCount: 11,//最大上传数量
        browseOnZoneClick: true,
        msgFilesTooMany: "选择上传的文件数量 超过允许的最大数值！",
        enctype: 'multipart/form-data',
        // overwriteInitial: false,//不覆盖已上传的图片
        allowedFileExtensions: ["jpg", "png", "gif"],
        browseClass: "btn btn-primary", //按钮样式
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
    }).on("fileuploaded", function (e, result) {//文件上传成功的回调函数，还有其他的一些回调函数，比如上传之前...
        result = result.response
        $('#id').val(result.data.id)
        $('#imgName').val(result.data.imgName)
        $('#userId').val(result.data.userId)
    });
    $(function () {
        $('#originalPrice').blur(function () {
            var discount = $('#discount').val()
            var value = $('#originalPrice').val() * discount / 10
            $('#price').text('折旧后可卖' + value + '元')
        })
        $('#discount').blur(function () {
            var discount = $('#discount').val()
            var value = $('#originalPrice').val() * discount / 10
            $('#price').text('折旧后可卖' + value + '元')
        })
        $('#discount').change(function () {
            var discount = $('#discount').val()
            var value = $('#originalPrice').val() * discount / 10
            $('#price').text('折旧后可卖' + value + '元')
        })
        $('#btn-book-add').click(function () {
            alert($('#ISBN').val())
            $.ajax({
                url: 'http://localhost:8080/book/add',
                type: 'post',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({
                    id: $('#id').val(),
                    userId: $('#userId').val(),
                    imgName: $('#imgName').val(),
                    name: $('#name').val(),
                    author: $('#author').val(),
                    type: $('#type').val(),
                    originalPrice: $('#originalPrice').val(),
                    discount: $('#discount').val(),
                    bindingType: $('#bindingType').val(),
                    press: $('#press').val(),
                    paperType: $('#paperType').val(),
                    isbn: $('#ISBN').val(),
                    paperNumber: $('#paperNumber').val()
                    
                }),
                success: function (result) {
                    if (result.status == 0 && result.data != null) {
                        window.location = '../../../index.html'
                    }
                    if (result.status == 11) {
                        alert('用户不存在')
                        window.location = './register.html'
                    }
                }

            })
        })
    })