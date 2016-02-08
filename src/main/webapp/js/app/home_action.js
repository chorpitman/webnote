var Note = window.Note || {};

Note.Action = (function () {
    var module = {};

    module.addNote = function (obj, successHandler) {
        $.ajax({
            type: "POST",
            url: "/api/note/add",
            contentType: 'application/json',
            data: JSON.stringify(obj),
            success: function (data) {
                successHandler(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error(textStatus);
            }
        });
    };

    return module;
}());