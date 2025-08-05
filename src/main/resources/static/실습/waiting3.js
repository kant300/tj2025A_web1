// 2. 함수 연동 확인
// 일반 함수 선언 : function 함수명(){ }
// 람다식 함수 선언 : const 함수명 = ( ) => { }
const waitingWrite = ( ) => {
    console.log("waitingWrite() exe");
    // 3. 함수 기능 구현 - fetch
    // 대비 번호 등록
    // (1) 보낼 데이터 객체 준비 - 샘플
    let data = { "phone" : "010-1234-5678" , "count" : "3"}
    // (2) fetch 옵션 : 3가지 ( method , header , body )
    let option = {
        method : "POST" , // 1) method
        headers : { "Content-Type" : "application/json"} , // 2) headers
        body : JSON.stringify( data ) // 3) body
    } // option end
    // (3) fetch( url , option )
    //      .then( response => response.json() ) // 응답자료를 타입변환
    //      .then( data => { } )                 // 타입변환된 자료
    //      .catch( error => { } )              // 통신간의 예외발생
    fetch( "/waiting" , option )
        .then( response => response.json() )
        .then( data => { console.log(data)  } )
        .catch( error => { console.log(error ) } )
}
    // 대기 전체 조회
    const waitingPrint = () => {
        console.log("waitingPrint() exe")
        // (1) 보낼 데이터 - 없음
    // (2) fetch option , GET생략가능
    let option = { method : "GET" }
    // (3) fetch 실행
    fetch( "/waiting" , option )
        .then( response => response.json() )
        .then( data => { console.log(data)  } )
        .catch( error => { console.log(error ) } )
    }

    // 대기 취소/삭제
    const waitingDelete = ( ) => {
    console.log("waitingDelete() exe")
    // (1) 보낼 데이터 준비 - 샘플
    let wno = 1; // 존재하는 bno 아무거나
    // (2) fetch option
    let option = { method : "DELETE" }
    // (3) fetch 실행 , `백틱
    fetch( `/waiting?wno=${wno}` , option )
        .then( response => response.json() )
        .then( data => { console.log(data) } )
        .catch( error => { console.log(error ) })
}


    // 대기 수정
    const waitingUpdate = () => {
        console.log("waitingUpdate() exe");
        // (1) 보낼 데이터 - 샘플
    let data = { "wno" : 2 , "count" : 5 }

    /// (2) fetch option = { method : , headers : , body : }
    let option = {
        method : "PUT" , // (1) http 메소드
        headers : { "Content-Type" : "application/json" } , // (2) 보낼 자료의 타입
        body : JSON.stringify( data )// (3) 보낼 자료
    } // option end

    // (3) fetch 실행
    fetch( "/waiting" , option )
        .then( response => response.json() )
        .then( data => { console.log(data ) } )
        .catch( error => { console.log( error) } )

} // fun end


