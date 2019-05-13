function getRecommendDataList() {
    var name = $('#search').val()
    $.ajax({
        url: 'http://localhost:8080/book/recommended',
        type: 'get',
        async: false,
        dataType: 'json',
        success: function (result) {
            $('#recommend').empty()
            var data = result.rows
            var length = data.length > 12 ? 12 : data.length
            for (var index = 0; index < length; index++) {
                const element = data[index];
                console.log(element);
                var div = $('<div>');
                div.addClass('col-sm-2')
                div.css('height', '300px')


                // 追加图片
                var img = $('<img>');
                img.css('cursor', 'pointer')
                var imgName = element.imgName == null ? 'default.jpg' : element.imgName
                img.attr('src', "static/image/" + imgName)
                img.attr('width', "100%")
                img.attr('height', "70%")
                img.css('box-shadow', "1px 1px 4px 0px rgba(191, 191, 191, 1)")
                img.css('margin-bottom', '10px')
                img.click(function () {
                    localStorage.setItem("bookId", element.id)
                    window.location = 'detail.html'
                })
                div.append(img)

                // 追加书名
                var p1 = $('<span>')
                p1.text(element.name)
                p1.css('fontWeight', 'bold')
                div.append(p1)

                // 追加作者
                var p2 = $('<span>')
                p2.text(' ' + element.author + ' 著')
                p2.css('color', '#999')
                div.append(p2)

                // 追加金额
                var p3 = $('<p>')
                p3.text('￥' + element.price)
                p3.css('color', 'red')
                p3.css('fontSize', '16px')
                div.append(p3)
                $('#recommend').append(div)
            }
        }
    })
}
$(function () {
    getRecommendDataList()
})