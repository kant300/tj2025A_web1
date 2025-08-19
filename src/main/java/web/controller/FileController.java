package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController // 스프링 컨테이너의 빈 등록
@RequestMapping("/file")
public class FileController {
    @Autowired // 스프링 컨테이너에서 빈 꺼내오기
    private FileService fileService;
    // [1] 업로드

    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile){
        System.out.println("FileController.fileUpload");
        System.out.println("multipartFile = " + multipartFile);
        String result = fileService.fileUpload(multipartFile);
        return result;
    }

    // [2] 다운로드
    @GetMapping("/download")
    // GET , http://localhost:8080/file/download?fileName=d4d84bac-88ba-423a-99d9-14a6580324d4_blog.png
    public void fileDownload(@RequestParam String fileName , HttpServletResponse response ){
        fileService.fileDownload( fileName, response );
    }

    // [3] 파일삭제
    @GetMapping("/delete")
    public boolean fileDelet( @RequestParam String fileName ){
        boolean result = fileService.fileDelete( fileName );
        return result;
    }
}// class e
