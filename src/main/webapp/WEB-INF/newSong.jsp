<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>Lookify Music</title>
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/master.css" />" />
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/normalize.css" />" />
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/skeleton.css" />" />		
   </head>

   <body>
		<nav class="navbar">
			<h1 class="branding">LOOKIFY</h1>
			<ul class="navbar-list">
				<li class="navbar-item"><a href="/dashboard">Dashboard</a></li>
				<li class="navbar-item"><a href="/new">Add A Song</a></li>
			</ul>
		</nav>
		<div class="container">
			<form:form method="POST" action="/new" modelAttribute="song">
			<div class="row">
   			  <div class="twelve columns">
    			<form:label path="name">Song Title:
    			<form:errors path="name"/>
    			<form:input cssClass="u-full-width" path="name"/></form:label>
    		  </div>
    		</div>
    		<div class="row">
    		 <div class="six columns">
    			<form:label path="artist">Artist Name:
    			<form:errors path="artist"/>
    			<form:input cssClass="u-full-width" path="artist"/></form:label>
    		 </div>
    	     <div class="six columns">
			  </div>
			</div>
    	    <input class="button-primary" type="submit" value="Submit"/>
			</form:form>
		</div>
   </body>
</html>