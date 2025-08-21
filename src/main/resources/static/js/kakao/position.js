//
const myPositon = async()=> {

    const position = await new Promise( ( resolve , reject )=>{
        // new Promise : 비동기객체
        // resolve : 성공했을때 ,  reject : 실패했을때
        // navigator.geolocation.getCurrentPosition( 성공객체, 실패객체, {옵션}) : 현재 브라우저가 ip기반으로 위도/경도 조회
        navigator.geolocation.getCurrentPosition( resolve , reject , {
            enableHighAccuracy : true, // 가능한 정확한 위치(속도느리고, 전기소모 크다.)
            timeout : 5000, // 밀리초단위, 5초안에 못가져오면 실패(reject) 반환
            maximumAge : 0 // 캐시(임시) 정보는 사용안함( 항상 새로고침)
        }); // navigator.geolocation end
    }); // 동기함수 end
    console.log(position);
    console.log(`위도 : ${position.coords.latitude}`);
    console.log(`경도 : ${position.coords.longitude}`);
    return position;
}