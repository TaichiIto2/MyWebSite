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
<link href="https://fonts.googleapis.com/css?family=Alegreya+Sans" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" type="text/css"/>
<link rel="stylesheet" type="text/css" href="Userde.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat+Subrayada" rel="stylesheet">
<title>DetailMasta</title>
</head>
<body>
<div class="container">
    <h1 class="font_hixtuki msapace-A">Item Detail</h1>
    <div class="row msapace-A">
        <div class="col-md-3 col-sm-6 ">
            <div class="service-box">
                <div class="service-icon yellow">
                    <div class="front-content">
                        <h3>商品名</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>商品名</h3>
                    <p>${item.name}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6 ">
            <div class="service-box">
                <div class="service-icon aquamarine">
                    <div class="front-content">
                        <h3>商品 ID</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>商品 ID</h3>
                    <p>${item.id}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box ">
                <div class="service-icon red">
                    <div class="front-content">
                        <i class="fas fa-laugh-squint"></i>
                        <h3>登録日・更新日</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>登録日・更新日</h3>
                    <p>${item.create_date}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box">
                <div class="service-icon orchid">
                    <div class="front-content">
                        <i class="fas fa-money-bill-alt"></i>
                        <h3>価格</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>価格</h3>
                    <p>${item.price}</p>
                </div>
            </div>
        </div>
    </div>
        <div class="row mt-5 msapace-A">
        <div class="col-md-3 col-sm-6 ">
            <div class="service-box">
                <div class="service-icon hotpink">
                    <div class="front-content">
                        <i class="fas fa-map"></i>
                        <h3>商品説明</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>商品説明</h3>
                    <p>${item.detail}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6 ">
            <div class="service-box">
                <div class="service-icon navy">
                    <div class="front-content">
                      <i class="fab fa-firefox"></i>
                        <h3>在庫数</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>在庫数</h3>
                    <p>${item.stock}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box">
                <div class="service-icon orange">
                    <div class="front-content">
                        <i class="fas fa-images"></i>
                        <h3>画像</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>画像</h3>
                    <p>${item.fileName}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box">
                <div class="service-icon darkcyan">
                    <div class="front-content">
                        <h3>売り上げ数</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>売り上げ数</h3>
                    <p>${item.purchase_num}</p>
                </div>
            </div>
        </div>
    </div>
    <a href="MastaServlet" class="btn-circle-border-double"> 戻 る </a>
</div>
</body>
</html>