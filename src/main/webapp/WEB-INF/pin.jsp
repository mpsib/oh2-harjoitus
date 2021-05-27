<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Web application test page</title>
<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>

	<h1>Syötä pin-koodi</h1>

	<form>
		<input name="pin" type="text" required autocomplete="off"/>
		<input type="submit" value="->" action="/sovellus" />
	</form>




</body>
</html>
