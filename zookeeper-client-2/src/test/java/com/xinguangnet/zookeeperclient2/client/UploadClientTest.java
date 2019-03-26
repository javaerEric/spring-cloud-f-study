package com.xinguangnet.zookeeperclient2.client;

import com.xinguangnet.zookeeperclient2.ZookeeperClient2ApplicationTests;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: duozl
 * @Date: 2018/3/28 16:06
 */
public class UploadClientTest extends ZookeeperClient2ApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadClientTest.class);

    @Autowired
    private UploadClient uploadClient;

    @Test
    public void uploadFile() {
        File file = new File("pom.xml");
        DiskFileItem diskFileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE, true, file.getName());

        try(InputStream is = new FileInputStream(file); OutputStream os = diskFileItem.getOutputStream() ){
            IOUtils.copy(is, os);
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multipartFile = new CommonsMultipartFile(diskFileItem);
        String result = uploadClient.uploadFile(multipartFile);
        LOGGER.info("上传成功，文件名：{}", result);
    }
}