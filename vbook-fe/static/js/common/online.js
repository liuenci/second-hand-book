$(function () {
    // 判断是否在线
    $.ajax({
        url: 'http://localhost:8080/user/online',
        async: false,
        success: function (result) {
            if (result.status == 0) {
                $('#btn-user-login').remove();
                $('#btn-user-register').remove();
                $('#name').text(result.data.name)
            } else {
                $('#btn-user-center').remove();
            }

            $('#logout').click(function () {
                $.ajax({
                    url: 'http://localhost:8080/user/logout',
                    async: false,
                    success: function (result) {
                        if (result.status == 0) {
                            window.location = window.location
                        }
                    }
                })
            })
        }
    })
})
