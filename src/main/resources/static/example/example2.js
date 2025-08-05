console.log('example2.js open');// HTML에 JS파일 연동 확인 

// TalendAPI 대신에 실제로 통신 함수 만들어보기
// (1)  GET
const func1 = () => { console.log( 'func1 exe');
    // fecth 이용한 스프링 Controller와 통신하기  , GET 방식은 생략가능
    // fetch( " http://localhost:8080/day04/exam1" , , { method : "GET"} );
    fetch( "/day04/exam1" , { method : "GET"} );
}

// (2) POST
const func2 = () => {  console.log( 'func2 exe');
    fetch( "http://localhost:8080/day04/exam2" , { method : "POST" }  );
}
// (3) PUT
const func3 = () => { console.log('func3 exe');
    // + baseURL(localhost:8080) 은 생략이 가능하다.
    fetch( "/day04/exam3" , { method : "PUT"} );
}
// (4) DELETE
const func4 = ( ) => { console.log( 'func4 exe');
    fetch( "/day04/exam4" , { method : "DELETE"} );
}
// (5) GET
const func5 = () => { console.log ('func5 exe'); 
    const name = "유재석"; //샘플 임의값
    const age = 10;  //샘플 임의값
    // + fecth함수를 이용한 쿼리스트링 방식  , `백틱
    fetch(`/day04/exam5?name=${name}&age=${age}` , { method : "GET"} )
    .then( respose => respose.json() )          // 1) 응답자료를 매개변수로 받아 JSON 타입으로 변환
    .then( data => { console.log( data ); } )   // 2) 타입변환환 자료를 매개변수로 받아 실행문 처리
    .catch( error => { console.log( error ) } ) // 3) 만약에 fetch 통신간에 오류 발생시 실행문 처리
}// func e
// (6)
const func6 = () => { console.log ('func6 exe');
    const name = "유재석"; const age = 10;
    // + fetch 함수를 이용한 BODY본문 방식 ,
    const option = {
        method : "POST" ,
        headers : { "Content-Type" : "application/json" } ,// HTTP BODY 타입 설정
        body : JSON.stringify( { name : name , age : age } ) // JSON 타입으로 변환, 
        // JSON.stringify() : JSON객체 --> 문자열 타입변환
        // JSON.parse() :문자열 타입 --> JS객체 변환
    }// option e
    fetch( "/day04/exam6" , option )            // 1] URL   2] option { method : , headers : , body : }
        .then( response => response.json() )        // 3] 응답 자료 타입 변환, JSON
        .then( data => { console.log( data ) } )    // 4] 타입변환된 자료 , data
        .catch( error => { console.log( error ) } ) // 5] 예외발생시, error
}// func e
// (7) PUT
const func7 = () => {
    let sample = { name : "유재석" , age : 10 };
    let option = { 
        method : "PUT",
        headers : { "Content-Type" : "application/json" },
        body : JSON.stringify( sample),
    }

    fetch( "/day04/exam7" , option )
    .then( response => response.json() )
    .then( data => { console.log( data ) } )    
    .catch( error => { console.log( error ) } )

}

// (8) DELETE
const func8 =() => {
    let name = "유재석"; let age = 10;
    // + option 생략
    fetch( `/day04/exam8?name=${name}&age=${age}` , { method : "DELETE"} )
        .then( response => response.json() )        
        .then( data => { console.log( data ) } )   
        .catch( error => { console.log( error ) } ) 

}



// [FECTH] Talend 대신에 
//     - 외부주로소부터 요청과 응답을 *비동기통신*을 지원하는 함수 : fetch(JS내장) , ajax(JQUERY) , axios(React)
//     - 사용법
//         fetch( URL, HEADER ).then( response => response.json() ) .then(data =>
//             1) 통신할 URL 주소
//             2) 통신할 HEADER option : 주로 POST , PUT
//                 { 
//                     method : "GET or POST or DELETE" ,
//                     headers : { "Content-Type" : "application/json"},
//                     body : JSON.stringify( {} ) 
//                 }
//             3) then( response => response.json() ) : 응답 자료를 매개변수로 받아 JSON 타입으로 변환
//             4) then( data => { 실행문; }
//             5) catch( error => { 실행문; } )