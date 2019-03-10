<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="/css/login.css" rel="stylesheet">

</head>
<body>
    <div class="container">

      <form class="form-signin" action="/loginPage" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input name="mem_id"  type="text" id="mem_id" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only" >Password</label>
        <input name="mem_pass" type="password" id="mem_pass" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input id="rememberme" type="checkbox" value="remember-me" > Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id ="signin">Sign in</button>
      </form>

    </div> <!-- /container -->
</body>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/cookieUtil.js"></script>
  <script src="<%=request.getContextPath()%>/js/js.cookie.js"></script>
  <script>
  
  	$(document).ready(function(){
  		if(Cookies.get("memId")){
  			$("#memId").val(Cookies.get("memId"));
  			$("#rememberme").prop("checked",true);
  		}
  		
  		$("#signin").click(function(){
  			console.log("sign click");
  			if($("#rememberme").prop("checked")){
  				Cookies.set("memId",$("#memId").val(),{expires : 30});
  				Cookies.set("rememberme" ,"y",{expires : 30});
  			}else{
  				Cookies.remove("memId");
  				Cookies.remove("rememberme");
  			}
  			$("form").submit();
  		});
  	});
  </script>
</html>