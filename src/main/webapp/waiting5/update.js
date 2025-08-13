
console.log('update.js open');

// [1] 개별 조회( 수정하기 전 내용물 확인용 )
const waitingView = async ( ) => { console.log( "waitingView exe")
    // 1. 현재 게시물 번호 가져오기 
    const wno = new URLSearchParams(location.search).get('wno');
    // 2. fetch 이용한 wno의 게시물정보 요청
    const response = await fetch( `/waiting/view?wno=${ wno }`);
    const data = await response.json();
    // 3. 현재 게시물의 수정하기 전 게시물 연락처와 인원수 출력
    document.querySelector('.phone').innerHTML = data.phone;
    document.querySelector('.count').value = data.count;
}
waitingView(); // JS 실행시 1번 실행 < 버튼 없으므로 >

// [2] 개별 수정 
const waitingUpdate = async ( ) => { console.log( "waitingUpdate exe");
    // 1. 현재 수정할 게시물 번호 가져오기 
    const wno = new URLSearchParams( location.search ).get('wno');
    // 2. 수정할 입력받은 값 가져오기 
    const phone = document.querySelector('.phone').value;
    const count = document.querySelector('.count').value;
    // 3. 객체화 
    const obj = { "wno" : wno , "phone" : phone , "count" : count };
    // 4. fetch 옵션 
    const option = {
        method : "PUT",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( obj )
    }
    // 5. fetch 실행 
    const response = await fetch( "/waiting/update" , option );
    const data = await response.json();
    // 6. fetch 결과
    if( data == true ){
        alert('수정 성공');
        location.href=`/waiting5/view.jsp?wno=${ wno }`
    }else{
        alert('수정 실패');
    }
}