package com.example.effiwork.entity;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
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
public class memos {

	/** メモID */
	@Id
	private String memoId;

	/** ユーザーID */
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
