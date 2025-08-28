console.log("total.js open");


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

// [2] 합계출력함수
const moneyRead =async()=> {
    const option = { method : "GET" }
    const reponseesponse = await fetch("/moneyprint" , option)
    const data = await response.json()

    const totalTbody = document.querySelector("#totalTbody")
    let html = ""

    for (let i = 0; i< data.length ; i++ ){
        const grade = convertGrade(data[i].grade)

        html += `<tr>
                    <td>${ data[i].custno }</td>
                    <td>${ data[i].custname }</td>
                    <td>${ grade }</td>
                    <td>${ data[i].totalPrice }</td>
                </tr>`
    }
    totalTbody.innerHTML = html;
}
moneyRead();