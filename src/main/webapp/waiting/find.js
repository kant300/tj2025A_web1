console.log( "find.js open" )

// [1] 전체 조회 fetch
const find = async () => {
// async ( ) => {} : 동기화 함수
    // 1. 매개변수 준비[x]
    // 2. fetch option
    const option = {  method : "GET" }
     // 3. fetch 동기화실행
     // 통신응답이 올때까지 JS 기다려!!
     const response = await fetch("/waiting/find" , option )
     // 4. 응답객체를 json 변환
     const data = await response.json();
     // 1. 어디에 : waitingTbody에
     const waitingTbody = document.querySelector("#waitingTbody");
     // 2. 무엇을 : fetch로부터 받은 리스트를 HTML 구성
     let html="";
     // --반복문을 이용한 목록내 객체들을 HTML <tr> 로 구성하기
     for( let i = 0 ; i < data.length ; i++ ){
        const waiting = data[i];
        html += `<tr>
                    <td> ${ waiting.wno } </td>
                    <td> ${ waiting.phone } </td>
                    <td> ${ waiting.count } </td>
                </tr>`
     }
     // 3. 출력 : .innerHTML
     waitingTbody.innerHTML = html;

}
find(); // JS 실행시 최초 1번 자동 함수 호출 