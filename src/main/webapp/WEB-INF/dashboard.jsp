<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<table class="u-full-width">
				  <thead>
    				<tr>
      					<th>Song Name</th>
      					<th>Artist</th>
      					<th>Rating</th>
      					<th>Action:</th>
    				</tr>
  			</thead>
  			<tbody>
				<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="<c:url value="/song/${song.id}"/>"><c:out value="${song.name}" /></a></td>
					<td><c:out value="${song.artist}" /></td>
					<td><c:out value="" /></td>
					<td><a href="<c:url value = "/delete/${song.id}"/>">Delete</a></td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</div>
   </body>
</html>