package com.huan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by ptmind on 2016/5/21.
 */
@Configuration
public class FileUploadConfiguration {

    /**
     * 文件上传
     *
     * @return
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }
}
