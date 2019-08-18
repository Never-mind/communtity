function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success: function (response) {
            if(response.code==200){
                $("#comment_section").hide();
            }else {
                if(response.code==2003){
                    var isAccepted = confirm(response.message);
                    if(isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=4d957fc8f051868e5635&redirect_uri=http://localhost:8989/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", "true");
                    }
                }else {
                    alert(response.message);
                }
            }
            console.log(response)
        },
        dataType: "json"
    });
}