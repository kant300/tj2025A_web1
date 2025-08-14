console.log('info.js open');

// [1] 내정보 조회
const onInfo = async () => {
    try{ // fetch실행
        const option = {method : "GET"}
        const response = await fetch("/member/info" , option);
        const data = await response.json(); // 비로그인상태이면 null이므로 예외/오류발생
        // fetch 결과 : 로그인 상태
        document.querySelector('.mno').innerHTML = data.mno;
        document.querySelector('.mid').innerHTML = data.mid;
        document.querySelector('.mname').innerHTML = data.mname;
        document.querySelector('.mphone').innerHTML = data.mphone;
        document.querySelector('.mdate').innerHTML = data.mdate;
    }catch(error){ console.log(error); // 비로그인상태이면 catch  이동
        location.href="/member/login.jsp"; // 로그인페이지로
    }
}// func e
onInfo();

// [2] 회원탈퇴 : alert(): 확인 알람창, prompt() : 입력상자 알람창 , confirm : 확인/취소 알람창
const onDelete = async () => {
    // 1. 삭제확인
    let result = confirm('정말 탈퇴할까요? ');
    if( result == false ){ return; } // [취소}버튼 클릭하면 함수종료
    // 2. 삭제하기 위한 기존 패스워드 확인
    let oldpwd = prompt('현재 비밀번호 입력해주세요. ');
    try{ // 3. fetch 실행
        const option = { method : "DELETE" }
        const response = await fetch( `/member/delete?oldpwd=${oldpwd}`, option );
        const data = await response.json()
        if( data == true ){
            alert('탈퇴성공'); location.href="/index.jsp"
        }else{
            alert('탈퇴실패 : 현재 비밀번호가 일치하지 않는다.');
        }
    }catch(error){ console.log(error);}
}