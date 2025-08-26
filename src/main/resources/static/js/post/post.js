console.log("post.js open");

// [1] 사용자 요청한 URL 에서 cno(카테고리) /page(현재페이지번호) 가져오기
//  URL( location.href ).searchParams; 현재 페이지의 URL에서 매개변수(?) 값 반환
const params = new URL( location.href ).searchParams;
const cno = params.get('cno');  console.log(cno);
const page = params.get('page') || 1;   // 만약에 page가 존재하지 않으면 1

// [2] 
const findAll = async () => { console.log('findAll open'); 
    // 2-1 : try{}catch{}
    try{
        // 
        const url = `/post?cno=${ cno }&page=${ page }`;
        const reponse = await fetch( url );
        const data = await reponse.json(); console.log(data); // data <--> pageDto{}
        // 
        const postBody = document.querySelector(".postBody");
        let html = '';
            // 
            data.data.forEach( (post) => { // data.data <--> pageDto{ data }
                // post <--> postDto{}
                html += `<tr>
                            <td> ${ post.pno } </td>
                            <td> ${ post.ptitle } </td>
                            <td> ${ post.mid } </td>
                            <td> ${ post.pdate } </td>
                            <td> ${ post.pview } </td>
                        </tr>`
            })
        postBody.innerHTML = html;
    }catch(e){ console.log(e);}
}
findAll();//