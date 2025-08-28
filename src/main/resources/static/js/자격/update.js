console.log("update.js open");


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

// [2] 개별회원정보조회
