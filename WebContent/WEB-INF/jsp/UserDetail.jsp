<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head lang="en">
<link href="https://fonts.googleapis.com/css?family=Alegreya+Sans" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" type="text/css"/>
<link rel="stylesheet" type="text/css" href="Userde.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat+Subrayada" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <h1 class="font_hixtuki msapace-A">User Detail</h1>
    <div class="row msapace-A">
        <div class="col-md-3 col-sm-6 ">
            <div class="service-box">
                <div class="service-icon yellow">
                    <div class="front-content">
                        <i class="fas fa-user"></i>
                        <h3>名前</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>名前</h3>
                    <p>${user.name}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6 ">
            <div class="service-box">
                <div class="service-icon aquamarine">
                    <div class="front-content">
                        <i class="fas fa-id-card"></i>
                        <h3>Login ID</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>Login ID</h3>
                    <p>${user.loginId}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box ">
                <div class="service-icon red">
                    <div class="front-content">
                        <i class="fas fa-laugh-squint"></i>
                        <h3>ポストアドレスと都道府県</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>ポストアドレスと都道府県</h3>
                    <p>${userdata.postcode}</p>
                    <p>${user.metropolis}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box">
                <div class="service-icon orchid">
                    <div class="front-content">
                        <i class="fas fa-envelope"></i>
                        <h3>登録メールアドレス</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>登録メールアドレス</h3>
                    <p>${user.email}</p>
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
                        <h3>住所</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>住所</h3>
                    <p>${userdata.districts}</p>
                    <p>${user.addres}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box ">
                <div class="service-icon darkcyan">
                    <div class="front-content">
                        <i class="fas fa-calendar-check"></i>
                        <h3>登録日時</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>登録日時</h3>
                    <p>${user.create_date}</p>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="service-box">
                <div class="service-icon orange">
                    <div class="front-content">
                        <i class="fas fa-clock"></i>
                        <h3>更新日時・更新者のログインID</h3>
                    </div>
                </div>
                <div class="service-content">
                    <h3>更新日時・更新者のログインID</h3>
                    <p>${user.update_date}</p>
                </div>
            </div>
        </div>
    </div>
    <a href="AllUserServlet" class="btn-circle-border-double"> 戻 る </a>
</div>
</body>
</html>