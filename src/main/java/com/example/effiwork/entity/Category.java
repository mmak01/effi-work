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
 * 分類エンティティ
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

	/** 分類ID */
	@Id
	private Integer categoryId;

	/** ユーザーID */
	@Column(name="user_id",columnDefinition = "CHAR(4)")
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
