<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<link rel='stylesheet' href='resources/main.css'>
<div>
<br/>
</div>
<nav class="navbar navbar-default" id="navb">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/home"><img id="home-logo" src="resources/img/home_logo.png"></a>
    </div>

    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li> <a class="nav-link" href="ListOfDomains">
       <h4><span class="glyphicon glyphicon-tasks"  ></span> All Domains</h4></a></li>
        <li> <a class="nav-link" href="updateDomain">
         <h4><span class="glyphicon glyphicon-repeat"  ></span> Update</h4></a></li>
        <li> <a class="nav-link" href="/home">
        <h4><span class="glyphicon glyphicon-hand-up"  ></span> Add</h4></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="contactInfo"><h4>Contacts</h4></a></li>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
