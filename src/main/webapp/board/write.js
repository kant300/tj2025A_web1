console.log( "write.js open");

// [1] 등록
const boardWrite = async () => {
    // 1. 입력받은 데이터 가져오기
    const bcontent = document.querySelector('.bcontent').value;
    const bwriter = document.querySelector('.bwriter').value;
    // 2. 입력받4은 데이터를 객체화한다. // 속성명과 속성값의 변수명이 같으면 속성명 생략가능
    const object = { 'bcontent' : bcontent , 'bwriter' : bwriter };
    // 3. fetch 옵션
     const option = {
        method : "POST",  // HTTP METHOD(보내는 방법)
        headers : { "Content-Type" : "application/json"}, // HTTP HEADERS(부가정보/설정)
        body : JSON.stringify( object ) // HTTP BODY(보내는 내용물)
    }

    const response = await fetch("/board" , option );
    
    const data = await response.json();

    if(data == true ){
        alert("글쓰기 성공");
        location.href="/board/list.jsp" // 페이지이동 : location.href="" vs <a href=""></a>
    }else{
        alert("글쓰기 실패");
    }
}