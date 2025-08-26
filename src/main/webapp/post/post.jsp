<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    
    
</head>
<body>

    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <div>
            <button onclick="location.herf='write.jsp'"> 글쓰기 </button>
        </div>

        <table>
            <thead>
                <tr><td> 번호 </td> <td>제목  </td> <td> 작성자 </td> <td> 작성일 </td> <td> 조회수 </td></tr>
            </thead>
            <tbody class="postBody">
                <tr>
                    <td> 1 </td>
                    <td> 테스트제목 </td>
                    <td> 유재석 </td>
                    <td> 2025-08-26 </td>
                    <td> 3 </td>
                </tr>
            </tbody>
        </table>

        
        <div style="width: 300px;">
            <ul class="pageBtnBox"
            style="display: flex; justify-content: space-between;">
                <li> <a href="post.jsp?cno=1&page=1"> 1 </a></li>
                <li> <a href="post.jsp?cno=1&page=2"> 2 </a></li>
                <li> <a href="post.jsp?cno=1&page=3"> 3 </a></li>
                <li> <a href="post.jsp?cno=1&page=4"> 4 </a></li>
                <li> <a href="post.jsp?cno=1&page=5"> 5 </a></li>

            </ul>

        </div>


        <div style="display: flex;">
            <div>
                <select class="key">
                    <option value="ptitle"> 제목 </option>
                    <option value="pcontent"> 내용 </option>
                </select>
            </div>
            <div> 
                <input type="text" class="keyword" placeholder="검색어 입력하세요." />
            </div>
            <div>
                <button type="button" onclick="onSearch()"> 검색 </button>
            </div>

        </div>
    </div>

    <script src='/js/post/post.js'></script>
</body>

</html>