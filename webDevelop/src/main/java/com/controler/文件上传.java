package com.controler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

public class 文件上传 {
    public void uploadFileSystemResource () {
        // 构建请求头
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/file/upload";

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(new File("path/to/your/file")));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
    }

    public void importEquipmentAccounts(@RequestPart(value = "file") MultipartFile file,
            HttpServletResponse resp) {
        File tempFile = null;
        try {
            //设置请求头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpHeaders fileHeader= new HttpHeaders();
            fileHeader.setContentType(MediaType.parseMediaType(file.getContentType()));
            fileHeader.setContentDispositionFormData("file", file.getOriginalFilename());
            //设置请求体，注意是LinkedMultiValueMap
            HttpEntity fileEntity = new HttpEntity<>(new ByteArrayResource(file.getBytes()),fileHeader);
            MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
            form.add("file", fileEntity);
            //用HttpEntity封装整个请求报文
            HttpEntity files = new HttpEntity<>(form, headers);
            ResponseEntity<ResponseObjectResult> entity = restTemplate.postForEntity(hosBaseUrl + WebConfig.IMPORT_EQUIPMENT_ACCOUNTS, files, ResponseObjectResult.class);
            ResponseObjectResult responseObjectResult = entity.getBody();
            return responseObjectResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseObjectResult(new ResponseStatus(ResultCode.FAIL));
        }
    }
}
