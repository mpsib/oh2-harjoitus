<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Web application test page</title>
<link rel="stylesheet" href="/styles/demo.css">
</head>

<body>

	<h1>Puun tiheyslaskuri</h1>

	<table>
		<form method="post">
			<td></td>
			<td>Arvo</td>
			<tr>
				<td>Paksuus (mm)</td>
				<td><input name="paksuus" type="text" required
					autocomplete="off" value="${a}"/></td>
			</tr>
			<tr>
				<td>Pituus (mm)</td>
				<td><input name="pituus" type="text" required
					autocomplete="off" value="${b}" /></td>
			</tr>
			<tr>
				<td>Leveys (mm)</td>
				<td><input name="leveys" type="text" required
					autocomplete="off" value="${c}" /></td>
			</tr>
			<tr>
				<td>Paino (g)</td>
				<td><input name="paino" type="text" required 
					autocomplete="off" value="${d}"/></td>
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
		<tr>
			<td>Tulos (lb/ft3)</td>
			<td>${tulosLb}</td>
		</tr>

	</table>

	<br>
	<form>
		<input type="submit" value="Tietokantaohjelma" action="/pin" />
	</form>




</body>
</html>
