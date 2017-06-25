<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
   <head>
      <title>Lookify Music</title>
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/master.css" />" />
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/normalize.css" />" />
      <link type="text/css" rel="stylesheet" href="<c:url value="/resources/style/skeleton.css" />" />		
   </head>

   <body>
   	<div class="lookify">
   		<h1 class="lookify_home_header">LOOKIFY</h1>
   		<div class="lookify_home_button-float">
      		<a href = "<c:url value = "/dashboard"/>"><button class="lookify_home_button">Start Looking</button></a>
    	</div>
   	</div>
   </body>
</html>
