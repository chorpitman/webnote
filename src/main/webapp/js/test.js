$(document).ready(function(){
    $("a.edit").click(function(){
        $.ajax({url: "/api/note/get", success: function(result){
            $("#res").html(result);
        }});
    });
});