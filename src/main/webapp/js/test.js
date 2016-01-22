$(document).ready(function () {

    $('button.btn-danger').click(function () {
        var note = $(this).closest("tr.noteRest");
        var id = $(note).attr('id');
        $.ajax({
            type: "DELETE",
            url: "/api/note/" + id,
            success: function (data, status, jqXHR) {
                if (jqXHR.status == 200) {
                    note.remove();
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error(textStatus);
            }
        });
    });

    //start write new function
    $('button.btn-success').click(function () {
        var note = $(this).closest("tr.noteRest");
        var id = $(note).attr("id");
        $.ajax({
            type: "GET",
            url: "api/note/" + id,
            dataType: "json",
            success: function (data, status, jgXHR) {
                if (jgXHR.status == 200) {
                    $('#inputTytle').val(data.title);
                    $('#inputCategory').val(data.category);
                    $('#textArea').val(data.description);
                }
            }
        })
    });

    $("#saveChangesOnNote").on('click', function () {
        $.ajax({
            utl: "/api/note",
            type: "PUT",
            dataType: 'json',
            data: $("#formId").serialize(),
            success: function (result) {
                alert("djfjsdklfjsldjfsdljs")
                console.log(result);
            }
        })
    })

});


