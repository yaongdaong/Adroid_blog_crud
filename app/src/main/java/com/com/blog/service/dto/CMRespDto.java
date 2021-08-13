package com.com.blog.service.dto;

import com.com.blog.model.Post;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDto<T>{
    private int code;
    private String msg;
    private T data;
}
