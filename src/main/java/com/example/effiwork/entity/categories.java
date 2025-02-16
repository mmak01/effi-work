package com.example.effiwork.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分類エンティティ
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class categories {

	/** 分類ID */
	private Integer categoryId;

	/** ユーザーID */
	private String userId;

	/** 分類名称 */
	private String categoryName;

	/** 分類色 */
	private String color;

	/** 作成日時 */
	private LocalDateTime createdAt;

	/** 作成者 */
	private String createdUser;

	/** 更新日時 */
	private LocalDateTime updatedAt;

	/** 更新者 */
	private String updatedUser;
}
