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
    <jsp:include page = "/자격/header.jsp"></jsp:include>
    <h3> 회원매출조회 </h3>
    <div>
        <table border="1">
            <thead>
                <tr>
                    <td> 회원번호 </td>
                    <td> 회원성명 </td>
                    <td> 고객등급 </td>
                    <td> 매출 </td>
                </tr>
            </thead>
            <tbody id="totalTbody">

            </tbody>
        </table>
    </div>

    <jsp:include page="/자격/footer.jsp"></jsp:include>

    <script src='/자격/total.js'></script>
</body>
</html>