$(document).ready(function () {
    //DELTE BUTTON
    $(document).on('click', 'button.deleteNote', function () {
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
            error: function (jqXHR, textStatus, errorThrown) {
                console.error(textStatus);
            }
        });
    });

    //EDIT: get all fields in form
    $(document).on('click', 'button.editNote', function () {
        var note = $(this).closest("tr.note");
        var id = $(note).attr("id");
        var title = $(note).find(".note_title").text();
        var category = $(note).find(".note_category").text();
        var description = $(note).find(".note_description").text();

        $('#idNote').val(id);
        $('#inputTitle').val(title);
        $('#inputCategory').val(category);
        $('#description').val(description);
    });

    //BUTTON SAVE CHANGES: model window is opened AND WE PREESS SAVE BUTTON
    $(document).on('click','#saveChangesOnNote' ,function () {
        //var note = $("#formId").serialize();
        //console.log(JSON.stringify(note));
        var note = $(this).closest("tr.note");
        var id = $(note).attr('id');

        var obj = {
            id: $('#idNote').val(),
            title: $('#inputTitle').val(),
            category: $('#inputCategory').val(),
            description: $('#description').val()
        };

        $.ajax({
            type: "PUT",
            url: "/api/note",
            contentType: 'application/json',
            data: JSON.stringify(obj),
            success: function (data, status, jqXHR) {
                if (jqXHR.status == 200) {
                    //refresh
                    var note = $('#' + obj.id);
                    note.find('.note_title').text(obj.title);
                    note.find('.note_category').text(obj.category);
                    note.find('.note_description').text(obj.description);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error(textStatus);
            }
        });
    });

    //add new note
    $(document).on('click', '#saveAddNote',function () {

        var obj = {
            date: new Date(),
            title: $('#addInputTitle').val(),
            category: $('#addInputCategory').val(),
            description: $('#addFormDescription').val(),
            userId: $('#addInputUserId').val()
        };

        $.ajax({
            type: "POST",
            url: "/api/note/add",
            contentType: 'application/json',
            data: JSON.stringify(obj),
            success: function (data, status, jqXHR) {
                console.log(data);
                // find note item and clone it
                var note = $('#itemCopy').find(".note").clone();

                //set all data and id attr
                note.attr('id', data);
                note.find('.note_date').text(obj.date.toLocaleString());
                note.find('.note_title').text(obj.title);
                note.find('.note_category').text(obj.category);
                note.find('.note_description').text(obj.description);

                // find all notes and add to the end of list notes
                $('#addCopyItem').append(note);
                //$('button.editNote').on('editNote', false);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error(textStatus);
            }
        });
    })
});