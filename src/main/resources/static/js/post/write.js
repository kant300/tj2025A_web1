// [*] 썸머노트 실행
// $ : jquery (js 확장 라이브러리 ) 문법
$(document).ready(function() {
    $('#summernote').summernote({
    lang: 'ko-KR', // 썸머노트 메뉴들을 한글화속성
    minHeight : 300 , // 썸머노트 구역 최소높이
    placeholder : '여기에 내용 입력해주세요' , // 가이드라인
    });
});

console.log("write.js open");

// [1] 글쓰기 요청
const onWrite = async() => {
    // 1. 첨부파일 없는 게시물
    let cno = document.querySelector('.cno').value;
    let ptitle = document.querySelector('.ptitle').value;
    let pcontent = document.querySelector('.pcontent').value;
    let obj = {cno, ptitle, pcontent }; console.log( obj );
    let option = {
        method : "POST",
        headers : {"content-type" : "application/json"},
        body : JSON.stringify(obj)
    }
    try{
        const reponse= await fetch("/post" , option );
        const data = await reponse.json();
        if(data > 0 ){
            alert("등록성공");
        }else{
            alert("등록실패")
        }

    }catch(e){ console.log(e);}
}