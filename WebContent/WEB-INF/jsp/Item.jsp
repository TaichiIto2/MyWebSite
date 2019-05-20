<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<link href="https://fonts.googleapis.com/css?family=Creepster" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat+Subrayada" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<link href="/font/css/open-iconic-bootstrap.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Creepster" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<title>Item</title>
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

<div class="row msapace-A">
  <div class="col-sm-4">
    <img src="img/${item.fileName}" class="card-img-top" alt="..." width="500" height="400">
  </div>
  <div class="col-sm-8">
	<div class="row">
	<div class="col-sm-9">
	  <h1>${item.name}</h1>
	    <h1 class="msapace-A">${item.detail}</h1>
	</div>
	<div class="col-sm-3">
		<div class="con mt-5 mr-4">
		  <form class="form-signin" action="ShopCartServlet" method="get">
		    <input type="hidden" name="id" value="${item.id}">
		    <fieldset class="form-group">
			<div class="form-group">
			  <h2>値段表記</h2>
			  <h2>${item.price}</h2>
			  <h4>購入個数</h4>
		 <div class="col-auto my-1">
		   <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="item_pieces">
		     <option value="1">1</option>
			 <option value="2">2</option>
			 <option value="3">3</option>
			</select>
		</div>
	        </div>
			<button type="submit" class="btn btn-primary btn-block">カートに入れる</button>
			<span style="margin-right: 8em;"></span>
			</fieldset>
		 </form>
		</div>
	</div>
  </div>
</div>
</div>
</body>
</html>