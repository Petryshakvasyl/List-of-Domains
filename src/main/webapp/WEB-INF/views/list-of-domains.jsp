<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h2> List of Domains <h2>
</div>

        <c:forEach var="domains" items="${AllDomains}">
        <div>
            ${domains.name}
        </div>
         <div>
            ${domains.domainStatus}
        </div>
        </c:forEach>
