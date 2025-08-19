package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service // 해당 클래스를 스프링 컨테이너의 빈 등록
public class FileService {
    // [*] 업로드 경로
    // 방법1) 프로젝트 src : 개발자가 코드를 작성하는 폴더
    // 방법2) 프로젝트내 build : 서버를 실행했을때 컴파일된 코드 즉] 내장서버(24시간)의 갖는 실행된 폴더

    // 1. 현재 프로젝트의 최상위 디렉토리(폴더) 경로 찾기
    private String baseDir = System.getProperty("user.dir");
    // 2. 방법2 처럼 개발자폴더가 아닌 실행된 서버의 폴더로 업로드 경로 지정하기 , *개방환경*에 따라 달라진다.
    private String uploadPath = baseDir + "/build/resources/main/static/upload/";

    // [1] 파일 업로드 : 스프링에서는 MutipartFile 인터페이스 지원( 대용량 바이트 조작 )
    public String fileUpload(MultipartFile multipartFile) {
       // 1. 업로드한 파일명이 중복일때, 다른 파일이지만 파일명은 같을수 있다.
       // 방법1) 파일명 앞에 PK번호를 붙인다.
       // 방법2) 파일명 앞에 업로드된 날짜/시간 붙인다.
       // 방법3) UUID(네트워크식별번호) 라이브러리 사용한다. UUID란 ? 난수 문자열 생성(고유성 보장)
            // (1) 방법3처럼 UUID를 생성한다.
       String uuid = UUID.randomUUID().toString();
            // (2) 업로드된 파일명과 합치기 , .getOriginalFilename() : 업로드된 파일명
            // - 업로드된 파일명뒤에 _언더바가 존재하면 모두 -하이픈 변경, 예] 짱구_사진.jpg -> 짱구-사진.jpg
            // 이유 : uuid와 파일명 구분을 _언더바 사용하기 위한 내부적인 규칙
            // 예상 :
            // .replaceAll("기존문자" , "새로운문자") : 기존문자를 새로운문자로 변환메소드
        String fileName = uuid +"_" + multipartFile.getOriginalFilename().replaceAll("_","_");
        // 2. 업로드 경로와 파일명 합치기 ,
        String uploadFilePath = uploadPath + fileName;
        // 3. 만약에 업로드한 경로가 upload 폴더가 존재하지 않으면 폴더생성
        File pathFile = new File(uploadPath); // File 클래스 : 다양한 파일/폴더 함수를 제공
        if( !pathFile.exists() ){ //.exists() : 지정한 경로가 존재하면 true 존재하지 않으면 false
            pathFile.mkdir(); // .mkdir() : 지정한 경로 생성 메소드
        }
        // 4. 업로드 할 파일의 경로를 file 클래스 생성
        File uploadFile = new File( uploadFilePath );
        // 5. 업로드(파일/바이트 이동)하기 , .transferTo( file객체 ) : 지정한 file객체의 경로로 업로드 파일을 이동
        try{
            multipartFile.transferTo( uploadFile ); // 일반예외발생
        } catch (Exception e) {
            System.out.println(e); return null; // 업로드 실패시 null 반환
        }
        // 6. 만일 업로드 성공시 파일이름 반환하기
        return fileName;

    }


    // [2] 파일 다운로드

    // [3] 파일 삭제

}// func e
