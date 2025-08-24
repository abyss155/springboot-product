<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Player</title>
</head>
<body>
    <h2>Add New Player</h2>
<form:form method="POST" action="savePlayer" modelAttribute="player">
        <table>
            <tr>
                <td>Jersey Number:</td>
                <td><form:input path="jno" /></td>
            </tr>
            <tr>
                <td>Player Name:</td>
                <td><form:input path="playerName" /></td>
            </tr>
            <tr>
                <td>Matches Played:</td>
                <td><form:input path="mp" /></td>
            </tr>
            <tr>
                <td>Runs Scored:</td>
                <td><form:input path="rs" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save Player" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
