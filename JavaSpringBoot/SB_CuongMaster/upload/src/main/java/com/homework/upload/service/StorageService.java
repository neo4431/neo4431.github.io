package com.homework.upload.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.homework.upload.exception.ResourceNotFoundException;
import com.homework.upload.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String path;
    @Autowired
    private PersonServiceI personRepo;

    public void uploadFile(MultipartFile file, Long id) {

        if (file.isEmpty()) {
            throw new ResourceNotFoundException("Failed to store empty file");
        }

        String fileName = file.getOriginalFilename();
        try {
            InputStream is = file.getInputStream();
            Files.copy(is, Paths.get(path + id + ".jpg"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            String msg = String.format("Failed to store file %s", fileName);
            throw new ResourceNotFoundException(msg);
        }
    }

    public void deleteFile(Long id) {
        Person person = personRepo.findById(id);
        String fileName = person.getFile().getOriginalFilename();
        try {
            Files.deleteIfExists(Paths.get(path + id + ".jpg"));
        } catch (Exception e) {
            String msg = String.format("Failed to delete file %s", fileName);
            throw new ResourceNotFoundException(msg);
        }
    }
}