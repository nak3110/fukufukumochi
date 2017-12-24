package com.fukufuku.home.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
    @RequestMapping(path = "/fileUpload", method = RequestMethod.GET)
    public String fileUpload() {
        return "fileUpload";
    }

    @RequestMapping(path = "/fileUpload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile upfile) {
        // ファイルが空の場合
        if (upfile.isEmpty()) {
            return "failure";
        }
        // ファイル名取得
        String fileName = upfile.getOriginalFilename();
        // 日付からファイルパスを作成
        String filePath = new StringBuilder()
                .append(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now())).append("/")
                .append(fileName).toString();
        // ディレクトリ作成
        File uploadDir = new File("c:\\file", filePath);
        uploadDir.mkdirs();
        System.out.println(uploadDir.getPath());

        // ファイル格納
        try {
            File uploadFile = new File(
                    new StringBuilder().append(uploadDir.getPath()).append("\\").append(fileName).toString());
            byte[] bytes = upfile.getBytes();

            BufferedOutputStream uploadFileStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
            uploadFileStream.write(bytes);
            uploadFileStream.close();

        } catch (IOException e) {
            return "failure";
        }
        return "success";
    }
}
