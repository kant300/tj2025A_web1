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
        <div>
            <h3> 홈쇼핑 회원 등록</h3>
            회원번호(자동발생) : <input class="custNo"/><br/>
            회원성명 : <input class="custName"/><br/>
            회원전화 : <input class="phone"/><br/>
            회원주소 : <input class="address"/><br/>
            가입일자 : <input class="joinDate"/><br/>
            고객등급[A:VIP,B:일반,C:직원] : <input class="grade"/><br/>
            도시코드 : <input class="city"/><br/>
        </div>

        <div id="buttonBox">
            <button type="button" onclick="mCreate()"> 등록 </button>
            <button type="button" onclick="mList()"> 조회 </button>
        </div>
    
    </div>    
    <jsp:include page="/자격/footer.jsp"></jsp:include>"
    <script src='/자격/create.js'></script>
</body>
</html>