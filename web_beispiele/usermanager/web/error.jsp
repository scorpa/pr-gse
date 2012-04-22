<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
        <link rel="stylesheet" type="text/css" href="usermanager.css" />
	</head>
	<body>
		<h1>An error occurred:</h1>
		<h2 class="error">${pageContext.errorData.throwable.message}</h2>
	</body>
</html>