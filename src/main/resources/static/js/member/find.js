console.log('find.js open');

[1] 아이디찾기
const findId = async () => {
    try{ // 1. 마크업의 DOM객체 가져오기 
        const mnameInput = document.querySelector('.mname');
        const mphoneInput = document.querySelector('.mphone');
        // 2. DOM객체에서 입력받은 값 가져오기 
        const mname = mnameInput.value;
        const mphone = mphoneInput.value;
        // 2. 유효성검사
        if( !mname || !mphone ){
            alert( '이름과 연락처를 모두 입력해주세요. ');
            return;
        }
        // 3. 객체화
        const obj = { mname , mphone };

        // 4. fetch 실행, 서버에 POST 요청보내기
        const option = { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(obj) }
        const response = await fetch('/member/find', option);
        const data = await response.json(); // 응답을 JSON으로 변환
        // 5. fetch 결과
        if( result ){
            // 성공적으로 아이디를 찾았을경우
            alert("회원님의 아이디는 [ ${ result } ] 입니다.");
            location.href='/member/login.jsp'; // 로그인 페이지로 이동
        }else{ //일치하는 정보가 없을경우
            alert('일치하는 회원정보가 없습니다.');
        }
    }catch(error){ console.log(error); }
}

// // [1] 아이디찾기 ai에게 질문시 활용하는 방법
// const findId = async () => {
//     // 1. HTML로부터 사용자가 이름과 연락처를 입력받은 INPUT 마크업을 객체로 가져오기

//     // 2. 가져온 DOM객체내 입력받은 값 value 가져오기

//     // 선택] body가 아니므로 이름과 연락처를 객체화 선택

//     // 3. Fetch 이용하여 controller 매핑통신하기 "/member/findid?mname=&mphone="

//     // 4-1. 통신한 결과{ msg : 결과메시지 } 출력하기
    

// // [2]
// const findpwd = async () => {
//     // 1. html 로부터 아이디와 연락처를 입력받을 input 마크업 가져오기

//     // 2. 가져온 input 마크업에서 입력받은 값 가져오기

//     // 3. fetch 이용하여 controller와 통신, "/member/findpwd?mid=&mpone="

//     // 4. 통신결과 메시지 출력하기 , { msg : 결과메시지 }

// }