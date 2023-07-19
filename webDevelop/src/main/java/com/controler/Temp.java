package com.controler;

import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class Temp {

    public ResponseObjectResult importEquipmentAccounts(@RequestPart(value = "file") MultipartFile file,
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
