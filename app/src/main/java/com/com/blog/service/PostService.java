package com.com.blog.service;

import com.com.blog.controller.dto.CMRespDto;
import com.com.blog.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

// 인증이 필요 없는 주소 /auth
// 인증이 필요한 주소 /user, /post
public interface PostService {

    // 변수 바인딩 어떻게 하는지?
    @Headers({"Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJpZCI6MSwiZXhwIjoxNjI4ODI2MTg3fQ.ke2Cwo70q_Fho1wE3X6UWWeBhDSfrPf7G3nA8ND4Hwbqtq6xvcG6RwfcnYuEpp9kZXF36-2nLYIAn_wuMi98-A"})
    @GET("/post/{id}")
    Call<CMRespDto<Post>> findById(@Path("id") int id);

    @Headers({"Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjb3PthqDtgbAiLCJpZCI6MSwiZXhwIjoxNjI4ODI2MTg3fQ.ke2Cwo70q_Fho1wE3X6UWWeBhDSfrPf7G3nA8ND4Hwbqtq6xvcG6RwfcnYuEpp9kZXF36-2nLYIAn_wuMi98-A"})
    @GET("/post") // 추후 주소 변경 필요 : /post
    Call<CMRespDto<List<Post>>> findAll();

    // test
    @GET("/init/post")
    Call<CMRespDto<List<Post>>> initPost();

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.100.202.2:8080")
            .build();

    PostService service = retrofit.create(PostService.class);
}
