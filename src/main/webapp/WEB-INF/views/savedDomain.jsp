<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="allign-center">
    <c:set var="domain" scope="session" value="${newDomain}"/>
    <h3>
        <a href ="http://${domain.getName()}"> <c:out value="${domain.getName()}"/> </a> is
        <c:out value="${domain.getDomainStatus()}"/>
        it was save in database
        <br>
        see it here <a href="ListOfDomains"> here</a>
    </h3>
</div>
