package com.com.blog.service;

import com.com.blog.model.Post;
import com.com.blog.service.dto.CMRespDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface PostService {

    @GET("/init/post")
    Call<CMRespDto> findAll();

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.100.202.2:8080")
            .build();

    PostService service = retrofit.create(PostService.class);
}
