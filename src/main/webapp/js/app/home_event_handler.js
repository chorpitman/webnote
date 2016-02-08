var Note = window.Note || {};

Note.EventHandler = (function () {
    var module = {};

    module.addNoteHandler = function () {
        var obj = {
            date: new Date(),
            title: $('#addInputTitle').val(),
            category: $('#addInputCategory').val(),
            description: $('#addFormDescription').val(),
            userId: $('#addInputUserId').val()
        };

        Note.Action.addNote(obj, function (data) {
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
        });
    };

    return module;
}());