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

	<h1>Pro-versio</h1>

	<h2>Tiheyslaskuri</h2>
	<table>
		<form method="post" action="additem">
			<td></td>
			<td>Arvo</td>
			<tr>
				<td>Korkeus (mm)</td>
				<td><input name="korkeus" type="text" required autocomplete="off" value="${a}"/></td>
			</tr>
			<tr>
				<td>Pituus (mm)</td>
				<td><input name="pituus" type="text" required autocomplete="off" value="${b}"/></td>
			</tr>
			<tr>
				<td>Leveys (mm)</td>
				<td><input name="leveys" type="text" required autocomplete="off" value="${c}"/></td>
			</tr>
			<tr>
				<td>Paino (g)</td>
				<td><input name="paino" type="text" required autocomplete="off" value="${d}"/></td>
			</tr>
			<tr>
				<td>Grain</td>
				<td><input name="grain" type="text" required autocomplete="off" value="${e}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Laske" /></td>
		</form>
		</tr>
		<tr>
			<td>Tulos (kg/m3)</td>
			<td>${tulosKg}</td>
		</tr>
	</table>
	<br/>
	<table border="1" cellspacing="1" cellpadding="2">
		<tr>
			<td>ID</td>
			<td>Tiheys</td>
			<td>Korkeus</td>
			<td>Pituus</td>
			<td>Leveys</td>
			<td>Paino</td>
			<td>Grain</td>
			<td></td>
		</tr>
		
		<c:forEach items="${daolist}" var="item">
			<tr>
				<td><c:out value="${ item.id }" /></td>
				<td><c:out value="${ item.tiheys }" /></td>
				<td><c:out value="${ item.korkeus }" /></td>
				<td><c:out value="${ item.pituus }" /></td>
				<td><c:out value="${ item.leveys }" /></td>
				<td><c:out value="${ item.paino }" /></td>
				<td><c:out value="${ item.grain }" /></td>
				<td>
					<form method="post" action="/removeitem">
						<input type="hidden" name="id" value="${ item.id }">
						<input type="submit" value="Poista">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
