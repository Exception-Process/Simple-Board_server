package com.example.feed.domain.image.service;

import com.example.feed.domain.image.controller.dto.response.ImageUrlResponse;
import com.example.feed.infrastructure.image.ImageUtil;
import com.example.feed.infrastructure.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UpLoadImageService {

    private final ImageUtil imageUtil;

    public ImageUrlResponse execute(List<MultipartFile> images) {
        List<String> imageUrl = images
                .stream()
                .map(imageUtil::uploadImage)
                .collect(Collectors.toList());
        
        return new ImageUrlResponse(imageUrl);
    }
}
