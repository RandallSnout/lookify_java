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
			<h1>${song.name}</h1>
			<p>By: ${song.artist}</p>
			<h3>Leave a Review</h3>
				<form:form method="POST" action="/newReview/${song.id}" modelAttribute="review">
				<form:hidden path="song" value="${song.id}"/>
				<div class="row">
   			 	  <div class="twelve columns">
    			   <form:label path="body">Review:
    			   <form:errors path="body"/>
    			   <form:textarea cssClass="u-full-width" path="body"/></form:label>
    		     </div>
    		   </div>
    		   <div class="row">
    		     <div class="six columns">
    			   <form:label path="rating">Rating:
    			   <form:errors path="rating"/>
    			   <form:select path="rating">
    			   		<form:option value="1" label="1" />
    			   		<form:option value="2" label="2" />
    			   		<form:option value="3" label="3" />
    			   		<form:option value="4" label="4" />
    			   		<form:option value="5" label="5" />
    			   		<form:option value="6" label="6" />
    			   		<form:option value="7" label="7" />
    			   		<form:option value="8" label="8" />
    			   		<form:option value="9" label="9" />
    			   		<form:option value="10" label="10" />
    			   </form:select>
    			   </form:label>
    		     </div>
    	         <div class="six columns">
			     </div>
			   </div>
    	       <input class="button-primary" type="submit" value="Submit"/>
			   </form:form>
			<h3>Song Reviews</h3>
						<table class="u-full-width">
				  <thead>
    				<tr>
      					<th>Review</th>
      					<th>Rating</th>
    				</tr>
  			</thead>
  			<tbody>
				<c:forEach items="${reviews}" var="review">
				<tr>
					<td><c:out value="${review.body}" /></td>
					<td><c:out value="${review.rating}" /></td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
   </body>
</html>