<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    Flagged Status
                </th>
            </tr>
            <c:forEach var="domains" items="${AllDomains}">
            <tr>
                <td>
                    ${domains.name}
                </td>
                <td>
                    ${domains.domainStatus}
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>

