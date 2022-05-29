package com.blog.services.impl;

import com.blog.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImages(String path, MultipartFile file) throws IOException {
        //File Name
        String name = file.getOriginalFilename();
        //abc.png

        //random name generate file
        String imageId = UUID.randomUUID().toString();
        String FName = imageId.concat(name.substring(name.lastIndexOf(".")));

        //Fullpath
        String filePath = path + File.separator + FName;
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath), new CopyOption[0]);
        return FName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath=path+File.separator+fileName;
        InputStream is=new FileInputStream(fullPath);
        //db logic to return inputstream
        return is;
    }
}
