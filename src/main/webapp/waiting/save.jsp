 <%@ page language="java" contentType="text/html; charset=UTF-8"
                    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    
</head>
<body>
    
    <jsp:include page="/waiting/header.jsp"></jsp:include>

    <div>
        <h3> 등록페이지 </h3>
        연락처 : <input type="text" class="phone" /> <br/>
        인원수 : <input type="int" class="count" /> <br/>
        <button type="button" onclick="save()"> 등록 </button>
    </div>
    <script src="/waiting/save.js"></script>
</body>
</html>