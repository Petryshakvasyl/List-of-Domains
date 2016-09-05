<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<script   src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="resources/js/updateDomain.js"></script>
<div class="container">
    <div class="list-table">
        <br/>
        <br/>
        <table>
            <tr>
                <th>
                    Domain name
                </th>
                <th>
                    Update domain
                </th>
                <th>
                    Delete domain
                </th>
            </tr>
            <c:forEach var="domains" items="${AllDomains}">
            <tr>
                <td>
                    ${domains.name}
                </td>
                <td>
                    <button onclick="updateDomain(${domains.id})" class="btn btn-info">Update</button>
                </td>
                <td>
                    <button onclick="deleteDomain(${domains.id})" class="btn btn-warning"> Delete</button>
                </td>
            </tr>
            </c:forEach>
        </table>

        <div id="updatingDomain" class="modal fadde">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">x</button>
                        <p>Updating domain`s name</p>
                    </div>
                    <div class="modal-body">
                        <div class="input-group">
                            <input id="modal-input" class="form-control" name="name" pattern="^[a-zA-Z0-9][a-zA-Z0-9-]{0,61}[a-zA-Z0-9]\.[a-zA-Z]{2,}$"
                            title="Only domain name" required/>
                            <span class="input-group-btn">
                                <button id="button-update" class="btn btn-info">Update</button>
                            </span>
                        </div>
                        <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

