console.log( 'view.js open' );

// [1] 개별조회
const waitingView = async()=>{ console.log( 'waitingView exe' );
    // 1. (URL)경로상의 쿼리스트링 가져오기, 클릭한 wno 가져오기 
        // (1) 경로상의 웹주소 가져오기 , http://localhost:8080/waiting5/view.jsp?bno=3
    const url = new URLSearchParams( location.search );
        // (2) 웹주소에서 쿼리스트링 값 가져오기 , ?wno=3
    const wno = url.get('wno');
    // 2. 클릭한 bno를 fetch로 통신하기 , 백틱` 이용한 쿼리스트링 사용 
    const response = await fetch( `/waiting/view?wno=${wno}` );
    const data = await response.json();
    // 3. 어디에
    const phoneBox = document.querySelector('.phoneBox');
    const countBox = document.querySelector('.countBox');
    // 4. 무엇을 
    const phone = data.phone;
    const count = data.count;
    // 5. 출력 
    phoneBox.innerHTML = phone;
    countBox.innerHTML = count;
}
waitingView(); // 최초 1번 실행 

// [2] 삭제 
const waitingDelete = async ()=>{ console.log('waitingDelete exe')
    // 1. 현재 삭제할 게시물 번호 주소에서 가져오기
    const wno = new URLSearchParams( location.search ).get('wno');
    // 2. 확인 
    let check = confirm('정말 삭제 할까요?');
    if( check == true ){
        // 3. fetch 
        const option = { method : "DELETE" }
        const response = await fetch( `/waiting/view?wno=${wno}` , option );
        const data = await response.json();
        // 4. 
        if( data == true ){ 
            alert('삭제 성공'); 
            location.href="/waiting5/list.jsp"
        }else{
            alert('삭제 실패');
        }
    }
}

// [3] 수정페이지로 이동 
const waitingUpdate = ()=>{
    // 1. 현재 수정할 게시물 번호 가져오기 
    const wno = new URLSearchParams( location.search ).get('wno');
    // 2. 수정페이지에게 bno 전달하기 
    location.href=`/waiting5/update.jsp?wno=${ wno }`;
}