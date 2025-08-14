console.log('find.js open');

// [1] 아이디찾기
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