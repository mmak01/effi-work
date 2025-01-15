package com.example.effiwork.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ユーザーエンティティ
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	/** ユーザーID */
	@Id
	private String userId;

	/** ユーザーネーム */
	private String username;

	/** メールアドレス */
	private String email;

	/** パスワード */
	private String password;

	/** 権限 */
	private String role;

	/** 削除済みフラグ */
	private Boolean isDeleted;

	/** 作成日時 */
	private LocalDateTime createdAt;

	/** 更新日時 */
	private LocalDateTime updatedAt;

	/** 削除日時 */
	private LocalDateTime deleted_at;
}
