<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title> 쇼핑몰 회원관리 </title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='자격/index.css'>
    
</head>
<body>
    <jsp:incluce page="/자격/header.jsp"></jsp:incluce>

    <h3> 홈쇼핑 회원 등록 </h3>
    <div>
        <table border="1">
            <tr>
                <td> 회원번호(자동발생) </td>
                <td><input type="text" class="custNo" disabled></td>
            </tr>
            <tr>
                <td> 회원성명 </td>
                <td><input type="text" class="custName"></td>
            </tr>
            <tr>
                <td> 회원전화 </td>
                <td><input type="text" class="phone"></td>
            </tr>
            <tr>
                <td> 가입일자 </td>
                <td><input type="text" class = "grade"></td>
            </tr>
            <tr>
                <td> 도시코드 </td>
                <td><input type="text" class="city"></td>
            </tr>
        </table>

        <div id="buttonBox">
            <button onclick="mCreate()"> 등록 </button>
            <button onclick="mList()"> 조회 </button>
        </div>
    
    </div>    
    <jsp:include page="/자격/footer.jsp"></jsp:include>"
    <script src='/자격/create.js'></script>
</body>
</html>