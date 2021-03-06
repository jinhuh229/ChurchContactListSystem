<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>The Jesus Hope Church of GA | 예수소망교회</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    
	<link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="style.css">
    
	
</head>
<body>

	<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="https://cdn1.iconfinder.com/data/icons/real-estate-and-home-furniture/137/RealEstate-23-512.png" id="icon" alt="User Icon" /><br />
      
      <a class="underlineHover" href="index.html">The Jesus Hope Church of GA</a>
    </div>

    <form action = "RegisterCheck" method="post">
      <input type="text" id="id" class="fadeIn second" name="id" placeholder="* login">
      <input type="text" id="pw" class="fadeIn third" name="pw" placeholder="* password">
      <input type="text" id="name" class="fadeIn fourth" name="name" placeholder="* name">
      <input type="text" id="group" class="fadeIn fourth" name="group" placeholder="* 구역">
      <input type="text" id="birthday" class="fadeIn fourth" name="birthday" placeholder="* 생일 (yyyy-mm-dd)">
      <input type="text" id="startDate" class="fadeIn fourth" name="startDate" placeholder="교회등록날짜 (yyyy-mm)">
      
      <input type="submit" class="fadeIn fourth" value="Register">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a><br />
      <a  href="index.html"class="underlineHover" href="#">Login</a>
    </div>

  </div>
</div>




	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/js/bootstrap.min.js" integrity="sha384-7aThvCh9TypR7fIc2HV4O/nFMVCBwyIUKL8XCtKE+8xgCgl/PQGuFsvShjr74PBp" crossorigin="anonymous"></script>
	
</body>
</html>