<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--Bootstrap４に必要なCSSとJavaScriptを読み込み-->
<link rel="stylesheet" type="text/css" href="style.css">
<script src="https://ajaxzip3.github.io/ajaxzip3.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Creepster" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg" style="background-color: #232f3e;">
  <a class="navbar-brand change_font color_white" href="HomeShopServlet">MY WEB SITE.!!!</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
    <form action="SearchResultServlet" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" name="search_word" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link color_white" href="ShopCartServlet"><i class="fas fa-shopping-cart fa-2x"></i></a>
      </li>
      <li class="nav-item">
        <a class="nav-link litbig_font color_white"  href="BuyHistoryServlet">購入履歴<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle litbig_font color_white" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          設定
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <p class="dropdown-item">${userInfo.name}さん</p>
          <c:if test="${userInfo.loginId == 'admin'}">
          <a class="dropdown-item" href="MastaServlet">管理者</a>
          </c:if>
          <a class="dropdown-item" href="AllUserServlet">ユーザーデーター</a>
          <a class="dropdown-item" href="NewMakeServlet">新規アカウント作成</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link litbig_font color_white" href="LogoutServlet">ログアウト<span class="sr-only">(current)</span></a>
      </li>
    </ul>
  </div>
</nav>
<form class="needs-validation" action="UserUpdateServlet" method="post">
<input type="hidden" name="id" value="${user.id }">
<div class="form-row">
  <div class="container">
  <h3 class="msapace-A">アカウントを更新</h3>
    <div class="row msapace-A">
    <div class="col-sm-4 font_big">名前</div>
    <div class="col-sm-8">
      <input type="text" value="${user.name}" class="form-control" placeholder="名字" name="name" required>
    </div>
    </div>
    <div class="row mt-4">
    <div class="col-sm-4 font_big">ログインID</div>
    <div class="col-sm-8">
      <input type="text" value="${user.loginId}" class="form-control" name="loginId" placeholder="LoginId" required>
    </div>
    </div>
    <div class="row mt-4">
    <div class="col-sm-4 font_big">E-mail</div>
    <div class="col-sm-8">
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text"><i class="fas fa-envelope"></i></div>
        </div>
      <input type="email" class="form-control" name="email" id="inputEmail4" placeholder="Eメール" required>
      </div>
    </div>
    </div>
    <div class="row mt-4">
    <div class="col-sm-4 font_big">パスワード</div>
    <div class="col-sm-8">
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text"><i class="fas fa-key"></i></div>
        </div>
      <input type="text" class="form-control" name="password" id="inputPassword" placeholder="パスワード" required>
      </div>
    </div>
    </div>
    <div class="row mt-4">
    <div class="col-sm-4 font_big">確認用  パスワード</div>
    <div class="col-sm-8">
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text"><i class="fas fa-key"></i></div>
        </div>
      <input type="text" class="form-control" name="password2" id="inputPassword" placeholder="確認用  パスワード" required>
      </div>
    </div>
    </div>
  <div class="form-row">
    <div class="form-group col-md-2">
      <label for="inputZip">郵便番号</label>
      <input type="text" name="post" class="form-control" size="10" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this,'','pref01','addr01');" required>
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">都道府県</label>
      <input type="text" name="metropolis" class="form-control" size="20" required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputCity">区市町村</label>
      <input type="text" name="districts" class="form-control" size="60" required>
    </div>
  </div>
  <div class="form-group">
    <label for="inputAddress">住所</label>
    <input type="text" name="addres" class="form-control" id="inputAddress1" placeholder="マンション名,部屋番号など" required>
  </div>
  <div class="form-group">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" id="gridCheck" required>
      <label class="form-check-label" for="gridCheck">
        同意しますか？
      </label>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">新規作成</button>
  <a class="btn btn-danger" href="AllUsersServlet" role="button">キャンセル</a>
   </div>
  </div>
</form>
<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
</body>
</html>