$(document).ready(function () {

    $('button.btn-danger').click(function () {
        var note = $(this).closest("tr.note");
        var id = $(note).attr('id');
        $.ajax({
            type: "DELETE",
            url: "/api/note/" + id,
            success: function (data, status, jqXHR) {
                if (jqXHR.status == 200) {
                    note.remove();
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error(textStatus);
            }
        });
    });



});