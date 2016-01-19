$(document).ready(function () {

    $('a.delete').click(function () {
        var id = $(this).attr('id');
        var note = $(this);
        $.ajax({
            type: "DELETE",
            url: "/api/note/" + id,
            success: function (data, status, jqXHR) {
                if (jqXHR.status == 200) {
                    note.closest("tr.note").remove();
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error(textStatus);
            }
        });
    });


});