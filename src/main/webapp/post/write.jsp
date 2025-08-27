<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <!-- 썸머노트 용 js/css -->
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">
        <select class="cno">
            <option value="1"> 뉴스 </option>
            <option value="2"> 이벤트 </option>
            <option value="3"> FAQ </option>
            <option value="4"> 튜토리얼 </option>
            <option value="5"> 사용자 리뷰 </option>
        </select>
        <input class="ptitle"/>
        <textarea class="pcontent" id="summernote" name="editordata"></textarea>
        <button type="button" onclick="onWrite()"> 등록 </button>
    </div>
    
    <script src='/js/post/write.js'></script>
    
</body>
</html>