<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="add-domain">
    <h2> Pleace enter domain name <h2>
    <form:form method="POST" action ="addDomain">
        <div class="input-group">
            <input class="form-control" name="name" pattern="^[a-zA-Z0-9][a-zA-Z0-9-]{0,61}[a-zA-Z0-9]\.[a-zA-Z]{2,}$"
            title="Only domain name" required placeholder="name like google.com"/>
             <span class="input-group-btn">
                <input class="btn btn-info" type="submit" value="Save"/>
             </span>
        </div>
    </form:form>
</div>