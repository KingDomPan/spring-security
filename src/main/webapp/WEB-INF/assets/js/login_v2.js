/* Webarch Admin Dashboard 
-----------------------------------------------------------------*/
$(document).ready(function() {
    $('#login_toggle').click(function() {
        var username = $("#login_username").val();
        var pwd = $("#login_pass").val();
        if (username == "" || pwd == "") {
            $(".error-info").css("display", "block");
            $("#error-inf").text("用户名或密码不能为空！！！");
            if (username == "") {
                $("#login_username").css("border", "1px solid red");
            };
            if (pwd == "") {
                $("#login_pass").css("border", "1px solid red");
            };
        };
    })
    $("#login_username").click(function() {
        $(this).css("border", "0px solid rgb(241,241,241)");
    })
    $("#login_pass").click(function() {
        $(this).css("border", "0px solid rgb(241,241,241)");
    })
    $('#register_toggle').click(function() {
        $('#frm_login').hide();
        $('#frm_register').show();
    })
    $(".lazy").lazyload({
        effect: "fadeIn"
    });
    $('#login-form').validate({
        focusInvalid: false,
        ignore: "",
        rules: {
            txtusername: {
                minlength: 2,
                required: true
            },
            txtpassword: {
                required: true,
            }
        },
        invalidHandler: function(event, validator) {
            //display error alert on form submit    
        },
        errorPlacement: function(label, element) { // render error placement for each input type   
            $('<span class="error"></span>').insertAfter(element).append(label)
            var parent = $(element).parent('.input-with-icon');
            parent.removeClass('success-control').addClass('error-control');
        },
        highlight: function(element) { // hightlight error inputs
        },
        unhighlight: function(element) { // revert the change done by hightlight
        },
        success: function(label, element) {
            var parent = $(element).parent('.input-with-icon');
            parent.removeClass('error-control').addClass('success-control');
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});