<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
   
</head>
<body>

    <jsp:include page="/waiting5/header.jsp"></jsp:include><!--헤더.jsp 불러오기-->
    <div>
        <h3> 게시물 전체조회 페이지 </h3>
        <a href="/waiting5/write.jsp"> 글쓰기 </a>
        <table border="1">
            <thead>
                <tr>
                    <th> 번호 </th>
                    <th> 연락처 </th>
                    <th> 인원수 </th>
                    <th> 등록일 </th>
                </tr>
            </thead>
            <tbody id="waitingTbody">

            </tbody>

        </table>
    </div>

    <script src="/waiting5/list.js"></script><!--JS불러오기-->
    
</body>
</html>