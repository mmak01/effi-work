package com.example.effiwork.service;

import com.example.effiwork.entity.User;
import com.example.effiwork.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * ユーザーサービスの実装クラス
 * ユーザーの登録・管理を実装
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * コンストラクタでリポジトリとパスワードエンコーダを注入
     * 
     * @param userRepository  ユーザーリポジトリ
     * @param passwordEncoder パスワードのエンコーダ（ハッシュ化のため）
     */
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * 新規ユーザーを登録
     * メールアドレスが既に登録されている場合は例外をスロー
     * 
     * @param email    ユーザーのメールアドレス
     * @param username ユーザー名
     * @param password 平文のパスワード（ハッシュ化される）
     * @return 登録された User オブジェクト
     * @throws RuntimeException メールアドレスが既に登録済みの場合
     */
    public User registerUser(String email, String username, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("This email is already registered.");
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password)); // パスワードをハッシュ化
        newUser.setRole("USER");

        return userRepository.save(newUser);
    }

    /**
     * メールアドレスでユーザー情報を取得
     * ユーザーが見つからない場合は empty の Optional を返却
     * 
     * @param email 検索するユーザーのメールアドレス
     * @return Optional<User>（見つかった場合はユーザー情報）
     */
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * すべてのユーザーを取得
     * 
     * @return ユーザー一覧
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * 指定されたメールアドレスのユーザーを削除
     * ユーザーが存在しない場合、何も起こらない。
     * 
     * @param email 削除するユーザーのメールアドレス
     */
    @Override
    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }
}