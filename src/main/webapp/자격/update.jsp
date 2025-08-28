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
    <jsp:include page="/자격/header.jsp"></jsp:include>

    <h3> 홈쇼핑 회원 정보 수정 </h3>
    <div>
        <table border="1">
            <tr>
                <td> 회원번호(자동발생) </td>
                <td><input type="number" class="custNo" disabled></td>
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
                <td> 회원주소 </td>
                <td><input type="text" class="address"></td>
            </tr>
            <tr>
                <td> 가입일자 </td>
                <td><input type="date" class="joinDate"></td>
            </tr>
            <tr>
                <td> 고객등급[A:VIP , B:일반 , C:직원]</td>
                <td><input type="text" class="grade"></td>
            </tr>
            <tr>
                <td> 도식코드 </td>
                <td><input type="text" class="city"></td>
            </tr>
        </table>

        <div id="buttonBox">
            <button onclick="mUpdate()"> 수정 </button>
            <button onclick="mList()"> 조회 </button>
        </div>
    </div>
    <script src='/자격/mUpdate.js'></script>
</body>
</html>