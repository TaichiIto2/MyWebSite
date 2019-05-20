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
<link rel="stylesheet" type="text/css" href="UserDel.css">
<link href="https://fonts.googleapis.com/css?family=Creepster" rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
<div class="container mt-5">
  <form action="UserDeleteServlet" method="post">
    <input type="hidden" name="id" value="${user.id }">
    <h1 class="red_font"><i class="fas fa-exclamation-triangle"></i>  ユーザ削除確認  <i class="fas fa-exclamation-triangle"></i></h1>
    <h3 class="msapace-A orenge_font">ログインID : ${user.loginId}</h3>
    <h4>を本当に削除してもよろしいでしょうか。</h4>

        <a class="btn btn-info" href="AllUserServlet">キャンセル</a>
        <button class="btn btn-info" type="submit"> O K</button>
    </div>
  </form>
</div>

</body>
</html>