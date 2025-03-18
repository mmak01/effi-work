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
 * メモエンティティ
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "memos")
public class Memo {

	/** メモID */
	@Id
	private String memoId;

	/** ユーザーID */
	@Column(name="user_id",columnDefinition = "CHAR(4)")
	private String userId;

	/** 分類ID */
	private Integer categoryId;

	/** タイトル */
	private String title;

	/** メモ詳細 */
	private String details;

	/** 作成日時 */
	private LocalDateTime createdAt;

	/** 作成者 */
	private String createdUser;

	/** 更新日時 */
	private LocalDateTime updatedAt;

	/** 更新者 */
	private String updatedUser;
}
