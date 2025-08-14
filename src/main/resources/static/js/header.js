
// * JS 실행 확인
console.log("header.js open");

// [1] 내정보 요청해서 메뉴 나누기
const myinfo = async() =>{
    // 1. 어디에
    const logMenu = document.querySelector('#log-menu')
    // 2. 무엇을
    let html = ''
    try{
        // 1. fetch 실행
        const option = { method : "GET"}
        const response = await fetch( "/member/info" , option );
        const data = await response.json(); console.log(data);
        // 2. [로그인중}로그인 했을때 정상 통신 fetch
        html += ` <li> <sapn> ${ data.mid } 님 </sapn> </li>
            <li> <a href="/member/info.jsp"> 내정보 </a> </li>
            <li> <a href="#" onclick="logout()"> 로그아웃 </a> </li>`
    }catch{
        // [비로그인중}로그인 안했을때 비정상 통신 fetch
        html += `<li> <a href="/member/login.jsp"> 로그인 </a></li>
               <li> <a href="/member/signup.jsp"> 회원가입 </a></li>`
    }
    // 3. 출력
    logMenu.innerHTML = html;
} // func e
myinfo(); // header.jsp 열릴때마다 1번 최초 실행 


// [2] 로그아웃
const logout = async() =>{
    try{
        // 1. fetch 실행
        const option = { method : "GET"}
        const response = await fetch( "/member/logout" , option );
        const data = await response.json();
        // 2. fetch 통신결과
        if( data == true ){
            alert('로그아웃 했습니다.');
            // 로그아웃 성공시 메인페이지로 이동
            location.href="/index.jsp";
        }else{
            alert('비정상 요청 및 관리자에게 문의');
        }
    }catch{    }
} // func e

