<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Team Players</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>
    <h2>Team Players</h2>
    <table border="1" class="table">
    <thead class="thead-dark">
        <tr>
            <th>Jersey Number</th>
            <th>Player Name</th>
            <th>Matches Played</th>
            <th>Runs Scored</th>
        </tr>
        </thead >
        <tbody>
        <c:forEach var="player" items="${allplayers}">
            <tr>
                <td>${player.jno}</td>
                <td>${player.playerName}</td>
                <td>${player.mp}</td>
                <td>${player.rs}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
