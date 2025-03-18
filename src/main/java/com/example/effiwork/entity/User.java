package com.example.effiwork.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "users")
public class User {

	/** ユーザーID */
	@Id
	@Column(name="user_id",columnDefinition = "CHAR(4)")
	private String userId;

	@Column(unique = true, nullable = false)

	/** メールアドレス */
	private String email;

	/** ユーザーネーム */
    @Column(nullable = false)
	private String username;

	/** パスワード */
    @Column(nullable = false)
	private String password;

	/** 権限 */
	private String role;

	/** 削除済みフラグ */
	private Boolean isDeleted = false;

	/** 作成日時 */
    @Column(updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	/** 更新日時 */
	private LocalDateTime updatedAt = LocalDateTime.now();

	/** 削除日時 */
	private LocalDateTime deleted_at;
}
