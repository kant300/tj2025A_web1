console.log('update.js open');

// [1] 개별조회(수정하기 전 내용물 확인용)
const boardFind = async () => {
    console.log('boardFind exe')
    // 1. 현재 게시물 번호 가져오기
    const bno = new URLSearchParams(location.search).get('bno');
    // 2. 
    const response = await fetch(`/board/find?bno=${bno}` );
    const data = await response.json();
    // 3. 현재 게시물의 수정하기 전 내용 출력
document.querySelector('.bcontent').innerHTML = data.bcontent;
}
boardFind(); // JS실행시 1번실행< 버튼 없음으로 >

// [2] 개별수정
const boardUpdate = async () => {
    console.log("boardUpdate exe");
    //
    const bno = new URLSearchParams(location.search).get('bno');

    const bcontent = document.querySelector('.bcontent').value;

    const obj = { "bno" : bno , "bcontent" : bcontent };

    const option = {
        method : "PUT",  // HTTP METHOD(보내는 방법)
        headers : { "Content-Type" : "application/json"}, // HTTP HEADERS(부가정보/설정)
        body : JSON.stringify( obj ) // HTTP BODY(보내는 내용물)
    }

    const response = await fetch( "/board" , option );
    const data = await response.json();

    if(data == true ){
        alert('수정 성공');
        location.href=`/board/view.jsp?bno=${bno}`
    }else {
        alert('수정 실패');
    }

}
