console.log('view.js open');

// [1] 개별조회
const boardFind = async () => {
    console.log('boardFind exe')
    // 1. 주소(URL)상 경로상의 쿼리스트링 가져오기
    // + 클릭한 bno 가져오기
    const url = new URLSearchParams(location.search);

    const bno = url.get('bno');

    const response = await fetch(`/board/find?bno=${bno}` );
    const data = await response.json();
// 3. 어디에
const bcontentBox = document.querySelector('.bcontentBox');
const bwriterBox = document.querySelector('.bwriterBox');

const bcontent = data.bcontent;
const bwriter = data.bwriter;

bcontentBox.innerHTML= bcontent;
bwriterBox.innerHTML = bwriter;

  
    
}
boardFind(); // 최초 1번 실행

// [2] 삭제
const boardDelete = async () => {
    console.log('boardDelete exe');

    const bno = new URLSearchParams( location.search ).get('bno');
    // 
    let check = confirm('정말 삭제 할까요?');
    if( check == true ){
        //
        const option = { method : "DELETE" }
        const response = await fetch(`/board?bno=${bno}` , option );
        const data = await response.json();

        if(data == true ){
            alert('삭제성공');
            location.href="/board/list.jsp"
        }

    }else{
        alert('삭제 실패');
    }

}


// [3] 수정페이지로 이동
const boardUpdateView = () => {
    // 1. 현재 수정할 게시물 번호 가져오기
    const bno = new URLSearchParams( location.search ).get('bno');
    // 2. 수정페이지에게 bno 전달하기
    location.href=`/board/update.jsp?bno=${bno}`;
}
