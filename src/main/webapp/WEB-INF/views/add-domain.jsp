<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3> Pleace enter URL <h3>
<form:form method="POST" action = "addDomain">
<input name="name" />
<input type="submit" value="Submit"/>
</form:form>
