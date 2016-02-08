var Note = window.Note || {};

Note = (function() {
    var module = {};

    module.bindEvents = function() {
        $(document).on('click', '#saveAddNote', Note.EventHandler.addNoteHandler);
    };

    module.unbindEvents = function() {
        $(document).off('click', '#saveAddNote');
    };

    return module;
})();
