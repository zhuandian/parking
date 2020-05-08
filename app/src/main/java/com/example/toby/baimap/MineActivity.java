package com.example.toby.baimap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toby.baimap.entity.UserEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class MineActivity extends AppCompatActivity {

    @BindView(R.id.et_nick_name)
    EditText etNickName;
    @BindView(R.id.et_user_password)
    EditText etUserPassword;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    private UserEntity userEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        ButterKnife.bind(this);

        userEntity = BmobUser.getCurrentUser(UserEntity.class);
        etNickName.setText(userEntity.getNikeName() == null ? userEntity.getUsername() : userEntity.getNikeName());
        etUserPassword.setText(userEntity.getUserInfo() == null ? "" : userEntity.getUserInfo());
    }

    @OnClick(R.id.tv_submit)
    public void onViewClicked() {

        if (!TextUtils.isEmpty(etNickName.getText().toString()) || !TextUtils.isEmpty(etUserPassword.getText().toString())) {
            userEntity.setNikeName(etNickName.getText().toString());
            //用户输入密码长度大于1时才可修改密码，不输入密码则只修改用户昵称
            if (etUserPassword.getText().toString().length() > 1) {
                userEntity.setPassword(etUserPassword.getText().toString());
            }
            userEntity.update(new UpdateListener() {
                @Override
                public void done(BmobException e) {
                    if (e == null) {
                        finish();
                        Toast.makeText(MineActivity.this, "更新成功...", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

