<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="/css/kakao/datamap.css" rel="stylesheet"/>
    
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <div id="map">  </div>
        <div id="sidebar"> </div>
    </div>
    
    <script src='/js/kakao/datamap.js'></script>
</body>
</html>