package com.example.effiwork.service;

import com.example.effiwork.entity.User;
import java.util.List;
import java.util.Optional;

/*
 * ユーザーサービスのインターフェース
 * ユーザーの登録、取得、一覧、削除の提供
 */
public interface UserService {

	/**
	 * 新規ユーザーを登録する。
	 * 
	 * @param email ユーザーのメールアドレス（ユニーク）
	 * @param username ユーザー名
	 * @param password 平文のパスワード（登録時にハッシュ化される）
	 * @return 登録された User エンティティ
	 * @throws RuntimeException メールアドレスが既に登録されている場合
	 */
	User registerUser(String email, String username, String password);

    /**
     * メールアドレスでユーザー情報を取得する。
     * 
     * @param email 検索するユーザーのメールアドレス
     * @return ユーザー情報を含む Optional (存在しない場合は empty)
     */
	Optional<User> getUserByEmail(String email);

    /**
     * 登録されているすべてのユーザーを取得する。
     * 
     * @return ユーザー一覧
     */
	List<User> getAllUsers();

    /**
     * メールアドレスを指定してユーザーを削除する。
     * 
     * @param email 削除するユーザーのメールアドレス
     */
	void deleteUser(String email);
}
