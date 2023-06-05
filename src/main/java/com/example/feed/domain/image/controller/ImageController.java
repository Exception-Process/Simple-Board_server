package com.example.feed.domain.image.controller;

import com.example.feed.domain.image.controller.dto.response.ImageUrlResponse;
import com.example.feed.domain.image.service.UpLoadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/image")
@RestController
public class ImageController {

    private final UpLoadImageService upLoadImageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ImageUrlResponse upload(@RequestPart List<MultipartFile> images) {
        return upLoadImageService.execute(images);
    }
}
