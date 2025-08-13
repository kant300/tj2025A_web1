console.log('list.js exe');

// [1] 전체조회
const waitingPrint = async () => { console.log('waitingPrint exe');

     // 1. fetch option 중 GET 은 생략가능 
    const response = await fetch("/waiting/list" );
    // 2. 응답자료 타입변환
    const data = await response.json();

    // 3. 어디에 , id=# , class=.
        // - table 마크업내 tbody 선택자
    const waitingTbody = document.querySelector('#waitingTbody')

    // 4. 무엇을 
    let html = ``; // 처음에는 빈칸 
    for( let i = 0 ; i<data.length ; i++ ){
        const waiting = data[i]; // i번째 dto(객체/게시물)꺼낸다.
        html += `<tr>
                    <td> ${ waiting.wno } </td>
                    <td>
                        <a href="/waiting5/view.jsp?wno=${ waiting.wno }"> 
                            ${ waiting.phone } 
                        </a>
                    </td>
                    <td> ${ waiting.count } </td>
                    <td> ${ waiting.date } </td>
                </tr>`
    }

    // 5. 출력 , innerHTML 속성은 마크업 사이에 요소를 대입/호출
    waitingTbody.innerHTML = html;

} // func end 

waitingPrint(); // 전체조회 함수 1번  

