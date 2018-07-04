<%--
  Created by IntelliJ IDEA.
  User: Alice
  Date: 2018-07-03
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Przelicznik</title>
  </head>
  <h1>Przelicznik metryczny</h1>
  <form method="post" action="metryka">
    <input type="text" name="metry" placeholder="metry"><br>
    <input type="text" name="centymetry" placeholder="centymetry"><br>
    <input type="text" name="milimetry" placeholder="milimetry"><br>
    <input type="submit" value="Przelicz">
  </form>
  <h1>Przelicznik wag</h1>
  <form method="post" action="waga">
    <input type="text" name="kilogramy" placeholder="kilogramy"><br>
    <input type="text" name="gramy" placeholder="gramy"><br>
    <input type="text" name="milimramy" placeholder="milimramy"><br>
    <input type="submit" value="Przelicz">
  </form>
</html>
