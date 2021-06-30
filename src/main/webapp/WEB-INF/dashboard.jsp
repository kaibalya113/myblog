
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>

<title>Dashboard</title>

<style>
.myDiv{
	color: white;
  background-color: grey;
  margin: auto;
  font-size: 25px;
  width: 98%;
}
.dot {
  height: 35px;
  width: 55px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
}
</style>

</head>
<body onload="data()">

	<%@include file="top.jsp"%>

	<main>
	<h2><center>Select Catagories</center></h2>
		<div class="row"> 
			<div class="col-sm-10" style="background-color: grey; box-sizing: border-box; width: 900px; height: 100px;">
  
  				<span class="dot"></span>
  <span class="dot"></span>
  <span class="dot"></span>
  <span class="dot"></span>
  			</div>
			
		</div>
		<br>
  <div class="row">
  <div class="col-sm-2">.col-sm-4</div>
  <div class="col-sm-8">.col-sm-4</div>
  <div class="col-sm-2">.col-sm-4</div>
</div>

	</main>

	<%@include file="footer.jsp"%>

		<script>
		
		
		</script>
		<script>
		function data(){
			let url = window.location.origin+"/";
			$.ajax({
				url: url+"dashboardata",
				type: "GET",
				success: function(data){
					console.log(data)
					let finaldata = data;
					return 
					
				}
			})
		}
		</script>

</body>
</html>