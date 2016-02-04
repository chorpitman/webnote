<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="myModalAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">web-notes.com</span>
                    <span class="sr-only">web-notes.com add</span>
                </button>
                <h4 class="modal-title" id="myModalLabelAdd">ADD NOTE SERVICE</h4>
            </div>
            <div class="modal-body">
                <%--body of modal window  START--%>
                <div class="container">
                    <div class="col-sm-6">
                        <form class="form-horizontal" role="form" id="addFormId" method="post">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Title</label>
                                <div class="col-sm-10">
                                    <input name="title" type="text" class="form-control" id="addInputTitle"
                                           placeholder="Input title for note">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">Category</label>
                                <div class="col-sm-10">
                                    <input name="category" type="text" class="form-control" id="addInputCategory"
                                           placeholder="Input category for note">
                                </div>
                            </div>

                            <!-- описание + текст арея -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">Description</label>

                                <!-- текст арея -->
                                <div class="col-sm-10">
                    <textarea class="form-control" rows="6" maxlength="1500"
                              placeholder="Describe your note" id="addFormDescription" name="description"></textarea>
                                </div>
                            </div>

                            <%--//user id - hidden--%>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">user id</label>
                                <div class="col-sm-10" id="userId">
                                    <input name="category" type="text" class="form-control" id="addInputUserId"
                                           placeholder="Input user id for note" value="<c:out value="${userid}"/>">
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
                <%--body of modal window END--%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="saveAddNote" data-dismiss="modal">Save note</button>
            </div>
        </div>
    </div>
</div>
