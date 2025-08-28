console.log("create.js open");

// [1] 고객등급 변환함수
const convertGrade =( grade )=>{
    if( grade == "A" ){
        return "VIP"
    }else if( grade == "B" ){
        return "일반"
    }else if( grade == "C" ){
        return "직원"
    }else if( grade == "VIP"){
        return "A"
    }else if( grade = "일반"){
        return "B"
    }else if( grade == "직원"){
        return "C"
    }
}// fund e

// [2] 회원번호 자동 발생
const maxCustno =async()=>{
    console.log("maxCustno exe");
    const option = { method : "GET" }
    const reponse = await fetch("/member/custno", option)
    const data = await reponse.json()
    console.log(data)

    document.querySelector(".custno").value = data
}
maxCustno();

// [3] 회원정보 등록
const mCreate = async()=>{
    console.log( "mCreate exe");
    const custname = document.querySelector(".custname").value
    const phone = document.querySelector(".phone").value
    const address = document.querySelector(".address").value
    const joindate = document.querySelector("joindate").value
    const grade = document.querySelector(".grade").value
    const city = document.querySelector(".city").value
    // 유효성검사
    if( custname == "" ){
        alert("회원성명이 입력되지 않았습니다.")
        return;
    }
    if( phone == "" ){
        alert("회원 전화가 입력되지 않았습니다.")
        return;
    }
    if ( address == "" ){
        alert("회원주소가 입력되지 않았습니다.")
        return;
    }
    if( joindate == ""){
        alert("가입일자가 입력되지 않았습니다.")
        return;
    }
    if( grade == "" ){
        alert("고객등급이 입력되지 않았습니다.")
        return;
    }
    if( city == "" ){
        alert( "도시코드가 입력되지 않았습니다.")
        return;
    }

    const data = {
        "custname" : custname,
        "phone" : phone,
        "address" : address,
        "joindate" : joindate,
        "grade" : grade,
        "city" : city
    }
    const option = { method : "POST" ,
        Headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( data )
    }
    const reponse = await fetch("/member" , option )
    const m = await Response.json()

    if( m = true ){
        alert("회원등록이 완료되었습니다.")
    }else{
        alert("회원등록을 실패하였습니다.")
    } 
    const mList = () =>{
        location.href = "/자격/list."
    }
}// func e

const mCreate = async()=>{
    console.log( "mCreate exe");
    const custname = document.querySelector(".custname").value
    const phone = document.querySelector(".phone").value
    const address = document.querySelector(".address").value
    const joindate = document.querySelector("joindate").value
    const grade = document.querySelector(".grade").value
    const city = document.querySelector(".city").value
    // 유효성검사
    if( custname == "" ){
        alert("회원성명이 입력되지 않았습니다.")
        return;
    }
    if( phone == "" ){
        alert("회원 전화가 입력되지 않았습니다.")
        return;
    }
    if ( address == "" ){
        alert("회원주소가 입력되지 않았습니다.")
        return;
    }
    if( joindate == ""){
        alert("가입일자가 입력되지 않았습니다.")
        return;
    }
    if( grade == "" ){
        alert("고객등급이 입력되지 않았습니다.")
        return;
    }
    if( city == "" ){
        alert( "도시코드가 입력되지 않았습니다.")
        return;
    }

    const data = {
        "custname" : custname,
        "phone" : phone,
        "address" : address,
        "joindate" : joindate,
        "grade" : grade,
        "city" : city
    }
    const option = { method : "POST" ,
        Headers : { "Content-Type" : "application/json"},
        body : JSON.stringify( data )
    }
    const reponse = await fetch("/member" , option )
    const m = await Response.json()

    if( m = true ){
        alert("회원등록이 완료되었습니다.")
    }else{
        alert("회원등록을 실패하였습니다.")
    } 
     
}// func e
const mList =()=>{
    location.href ="/자격/list.jsp"
}
