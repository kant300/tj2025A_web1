console.log("list.js open");

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

// [1] 회원정보 출력
const mRead = async ()=> {
    const memberTbody = document.querySelector("#memberTbody")
    const option = { method : "GET" }
    const reponse = await fetch("/member", option)
    const data = await reponse.json()

    html = ""
    for(let i = 0 ; i< data.length ; i++ ){
        const grade = changeGrade( data[i].grade )
        html += `<tr>
                    <td><a href="/자격/update.jsp?custno=${data[i].custno}">${ data[i].custno }</a></td>
                    <td>${ data[i].custname }</td>
                    <td>${ data[i].phone }</td>
                    <td>${ data[i].address }</td>
                    <td>${ data[i].joindate }</td>
                    <td>${ grade }</td>
                    <td>${ data[i].city }</td>
                </tr>`
    }
    memberTbody.innerHTML = html;
}
mRead();
