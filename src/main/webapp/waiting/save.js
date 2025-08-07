console.log('save.js open');

// [1] 등록 fetch , 동기식
// const save = () =>{ }
// function save() { }
const save = async() => {
     // 1. 입력받은 값 가져오기
     const phoneInput = document.querySelector('.phone');
     const countInput = document.querySelector('.count');
     const phone = phoneInput.value;
     const count= countInput.value;
    // 2. 입력받은 값을 객체화  , 속성명과 속성값변수명이 같으면 *둘중 하나 생략*가능
     const object = { phone , count }
     // 3. fetch option , get/delete vs post/put
      const option = {
        method : "POST",
        headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( object )
    }
    // 4. fetch 동기 실행
    const response = await fetch("/waiting/save" , option );
    const data = await response.json();
    // 5. 만약에 결과가 true이면
    if( data == true ){
        alert('등록성공');
        location.href="/student/find.jsp";
    }else{
        alert('등록실패');
    }


}