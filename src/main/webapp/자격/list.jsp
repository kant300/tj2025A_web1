<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='자격/index.css'>
    
</head>
<body>
    <jsp:include pgae="/자격/header.jsp"></jsp:include>

    <h3> 회원목록조회/수정 </h3>
    <div>
        <table border="1">
            <thead>
                <tr>
                    <td> 회원번호 </td>
                    <td> 회원성명 </td>
                    <td> 전화번호 </td>
                    <td> 주소 </td>
                    <td> 가입일자 </td>
                    <td> 고객등급 </td>
                    <td> 거주지역 </td>
                </tr>
            </thead>
            <tbody id="memberTbody"></tbody>
        </table>
    </div>

    <jsp:include page="/자격/footer.jsp"></jsp:include>
    <script src='main.js'></script>
</body>
</html>