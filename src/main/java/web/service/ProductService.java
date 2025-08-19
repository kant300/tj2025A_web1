package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.ProductDao;
import web.model.dto.ProductDto;

import java.util.List;

@Service
public class ProductService {
    @Autowired private ProductDao productDao;

    // [1-1]  제품등록
    public int createProduct(ProductDto productDto ){
        return productDao.createProduct(productDto); // DB에 제품정보 저장
    }

    // [1-2] 제품이미지 등록
    public boolean createProductImage( int pno, String fileNmae ){
        return productDao.createProductImage(pno, fileNmae ); // DB에 제품이미지 저장
    }

    // [2] 제품 전체 정보*이미지 포함 조회 getAllProduct()
    public List<ProductDto> getAllProduct(){
        // 1. 모든 제품의 정보 조회
        List<ProductDto> productDtoList = productDao.getAllProduct();
        // 2.모든 제품의 이미지 조회
        for( ProductDto productDto : productDtoList ){//조회된 모든 제품 dto를 반복
            List<String> images =
            productDao.getProductImages(productDto.getPno()); // 특정한 제품의 pno를 이용하여 모든 제품이미지명 조회
            productDto.setImages(images); //조회한 모든 이미지명을 특정한 제품의 dto포함

        }
        // 반환
        return productDtoList;
    }
    // [3] 제품 상세 조회
    public ProductDto getProduct(int pno){
        // 1. 특정한 제품 조회
        ProductDto productDto = productDao.getProduct(pno);
        // 2. 만약에 조회했으면 제품의 이미지명 조회
        if( productDto !=null ){
            List<String > images =
            productDao.getProductImages( productDto.getPno());
            productDto.setImages(images);
        }
        return productDto;

    }

}// class e
