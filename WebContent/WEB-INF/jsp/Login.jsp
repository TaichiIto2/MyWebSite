<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<link href="https://fonts.googleapis.com/css?family=Creepster" rel="stylesheet">
<title>ログイン</title>
</head>
<body class= "back_images">
<div class="bg_test">
  <div class="change_font ml-5">
    <p class="heading-typeB">MY WEB SITE.!!!</p>
  </div>
</div>
  <div class="gyo"></div>
<div class="container con mt-5">
  <div class="row header">
    <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
    Sign In
  </div>
  <form action="LoginServlet" method="post">
    <fieldset class="form-group">
      <div class="form-group">
        <legend>LOGIN ID</legend>
        <input type="text" class="form-control" name="loginId" value="${userInfo.name}">
      </div>
      <div class="form-group">
        <legend>PASSWORD</legend>
        <input type="text" class="form-control" name="password" value="${userInfo.name}">
      </div>
      <button type="submit" class="btn btn-primary btn-block">Sign in</button>
      <span style="margin-right: 8em;"></span>
      <div class="heading-typeA">新規作成の方</div>
 	<a class="btn btn-primary btn-block" href="NewMakeServlet" role="button">新規アカウント作成</a>
    </fieldset>
    <c:if test="${errMsg != null}">
      <div class="alert alert-danger" role="alert">${errMsg}</div>
    </c:if>

  </form>
</div>
</body>
</html>