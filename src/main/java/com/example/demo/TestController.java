package com.example.demo;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author songjianping
 * @ClassName TestController
 * @date 2021-10-13
 * @time 14:18
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(@RequestParam String param){
        return "input param ："+param;
    }
    @PostMapping("/pic")
    public String pic(@RequestParam MultipartFile file) throws IOException {
        Thumbnails.of(file.getInputStream()).scale(1f).outputQuality(0.5f).toFile("/"+ LocalDateTime.now().toString()+".jpg");
        return "over";
    }
}
