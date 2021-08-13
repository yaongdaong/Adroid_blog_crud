package com.com.blog.controller;

import android.util.Log;

import com.com.blog.model.Post;
import com.com.blog.service.PostService;
import com.com.blog.service.dto.CMRespDto;

import java.util.List;

import retrofit2.Call;

public class PostController {

    private static final String TAG = "PostController";
    private PostService postService = PostService.service;

    public Call<CMRespDto> findAll(){
        Log.d(TAG, "findAll: 1");
        return postService.findAll();
    }
}
