console.log("post.js open");

// [1] 사용자 요청한 URL 에서 cno(카테고리) /page(현재페이지번호) 가져오기
//  URL( location.href ).searchParams; 현재 페이지의 URL에서 매개변수(?) 값 반환
const params = new URL( location.href ).searchParams;
const cno = params.get('cno');  console.log(cno);
const page = params.get('page') || 1;   // 만약에 page가 존재하지 않으면 1
const key = params.get('key') || '';    //
const keyword = params.get('keyword') || '';

// [2] 
const findAll = async () => { console.log('findAll open'); 
    // 2-1 : try{}catch{}
    try{
        // 
        const url = `/post?cno=${ cno }&page=${ page }&key=${ key}&keyword=${ keyword }`;
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

        // 3. 페이징버튼 출력함수 호출
        viewPageButtons(data);
    }catch(e){ console.log(e);}
}

// [3] 페이징 버튼 출력 함수 , findAll() 안에서 실행
const viewPageButtons = async ( data )=>{

    let currentPage = parseInt( data.currentPage ); // parseInt(자료) : 자료를 int타입으로 변환
    let totalPage = data.totalPage;
    let startBtn = data.startBtn;
    let endBtn = data.endBtn;

     // *************** 페이징 처리시 검색 유지 ************** //
     const searchURL = `&key=${ key }&keyword=${ keyword }`;

    const pageBtnBox = document.querySelector('.pageBtnBox');
    let html = ``;
    
    // *************** 이전버튼 : 만약에 현재페이지가 1보다 작으면 1 고정 ************** //
    html += `<li>
                <a href="post.jsp?cno=${ cno }&page=${ currentPage<= 1 ? 1 : currentPage -1 }${searchURL}"> 이전 </a>
            </li>`
    // *************** 페이지버튼 : startBtn 부터 endBtn 까지 1씩 증가 반복 ************** //
    for( let i = startBtn ; i <= endBtn ; i++ ){
        html += `<li>
                    <a href="post.jsp?cno=${ cno }&page=${ i }${searchURL}" style="${ i  == currentPage ? 'color:red' :'' }"> ${i} </a> 
                </li>`
    }

    // *************** 다음버튼 : 만약에 다음페이지가 전체페이지수보다 커지면 전체페이지수로 고정 ************** //
    html += `<li>
                <a href="post.jsp?cno=${ cno }&page=${currentPage+1 >= totalPage ? totalPage : currentPage + 1 }${searchURL}"> 다음 </a>
            </li>`
    pageBtnBox.innerHTML = html;

}

// [4] 검색버튼을 클릭했을때
const onSearch = async () => {
    //
    const newKey = document.querySelector('.key').value // <select>
    const newKeyword = document.querySelector('.keyword').value // <input />

    //
    location.href = `post.jsp?cno=${ cno }&page=${ 1 }&key=${ newKey }&keyword=${ newKeyword}`;
}
findAll();//