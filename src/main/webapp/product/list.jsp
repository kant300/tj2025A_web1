<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <div id="map" style="width:100%;height:350px;"></div>
        <div id="product"></div>
            
        

    </div>

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9eb4f86b6155c2fa2f5dac204d2cdb35&libraries=clusterer"></script>
    <script src='/js/kakao/position.js'></script>
    <script src='/js/product/list.js'></script>
</body>
</html>