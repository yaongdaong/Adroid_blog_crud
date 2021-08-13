package com.com.blog.view.post;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.com.blog.R;
import com.com.blog.controller.PostController;
import com.com.blog.controller.dto.CMRespDto;
import com.com.blog.model.Post;
import com.com.blog.view.CustomAppBarActivity;
import com.com.blog.view.InitActivity;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostDetailActivity extends CustomAppBarActivity implements InitActivity {

    private static final String TAG = "PostDetailActivity";
    // 애플리케이션이 처음부터 끝까지 관리하는 어떤 클래스에 엑티비티 컨텍스트 전달하면 망함.
    private PostDetailActivity mContext = PostDetailActivity.this;

    private MaterialButton btnDelete, btnUpdateForm;
    private TextView tvBox;

    private PostController postController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        init();
        initLr();
        initSetting();
        initData();
    }

    @Override
    public void init() {
        postController = new PostController();
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdateForm = findViewById(R.id.btnUpdateForm);
        tvBox = findViewById(R.id.tvBox);
    }

    @Override
    public void initLr() {
        btnUpdateForm.setOnClickListener(v -> {});
        btnDelete.setOnClickListener(v -> {});
    }

    @Override
    public void initSetting() {
        onAppBarSettings(true, "Detail");
    }

    @Override
    public void initData() {
        // 트럭 데이터 받기
        Intent getIntent = getIntent();
        int postId = getIntent.getIntExtra("postId", 0);
        if(postId == 0) finish();

        // 데이터 초기화 하기
        postController.findById(postId).enqueue(new Callback<CMRespDto<Post>>() {
            @Override
            public void onResponse(Call<CMRespDto<Post>> call, Response<CMRespDto<Post>> response) {
                CMRespDto<Post> cm = response.body();
                if(cm.getCode() == 1){
                    tvBox.append("id : "+cm.getData().getId()+"\n");
                    tvBox.append("title : "+cm.getData().getTitle()+"\n");
                    tvBox.append("content : "+cm.getData().getContent()+"\n");
                    tvBox.append("username : "+cm.getData().getUser().getUsername()+"\n");
                    tvBox.append("created : "+cm.getData().getCreated()+"\n");
                }
            }

            @Override
            public void onFailure(Call<CMRespDto<Post>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}