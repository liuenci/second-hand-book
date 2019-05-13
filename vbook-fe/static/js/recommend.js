function getRecommendNaturalDataList() {
    $.ajax({
        url: 'http://localhost:8080/book/list',
        type: 'get',
        dataType: 'json',
        success: function (result) {
            var data = result.rows
            var index = 0
            var dataindex = 0
            while (index < 12 && dataindex < data.length) {
                const element = data[dataindex];
                if (element.type == '自然科学') {
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
                    $('#recommend-natural-list').append(div)
                    index++
                }
                dataindex++
            }
        }
    })
}

function getRecommendSocialDataList() {
    $.ajax({
        url: 'http://localhost:8080/book/list',
        type: 'get',
        dataType: 'json',
        success: function (result) {
            var data = result.rows
            var index = 0
            var dataindex = 0
            while (index < 12 && dataindex < data.length) {
                const element = data[dataindex];
                if (element.type == '社会科学') {
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
                    $('#recommend-social-list').append(div)
                    index++
                }
                dataindex++
            }
        }
    })
}

// 轮播图
function imgrecommend() {
    $.ajax({
        url: 'http://localhost:8080/admin/book/recommend/list',
        type: 'get',
        dataType: 'json',
        success: function (response) {
            $('#slide-list').empty()
            var data = response.data
            for(var i = 0; i < data.length; i++){
                const element = data[i]
                var div = $('<div>')
                div.addClass('slide-li')
                var img = $('<img>')
                img.attr('src','static/image/'+element.imgName)
                img.attr('width','1100px')
                img.click(function () {
                    localStorage.setItem("bookId", element.id)
                    window.location = 'detail.html'
                })
                div.append(img)
                $('#slide-list').append(div)
            }
        }
    })

}

$(function () {
    getRecommendNaturalDataList()
    getRecommendSocialDataList()
    imgrecommend()
})