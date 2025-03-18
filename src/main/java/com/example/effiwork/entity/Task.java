package com.example.effiwork.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * タスクエンティティ
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

	/** タスクID */
	@Id
	private String taskId;

	/** ユーザーID */
	@Column(name="user_id",columnDefinition = "CHAR(4)")
	private String userId;

	/** 分類ID */
	private Integer categoryId;

	/** タイトル */
	private String title;

	/** タスク詳細 */
	private String details;

	/** タスク開始日 */
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate  startOn;

	/** タスク終了日 */
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate  endOn;

	/** 完了フラグ */
	private Integer completed;

	/** 作成日時 */
	private LocalDateTime createdAt;

	/** 作成者 */
	private String createdUser;

	/** 更新日時 */
	private LocalDateTime updatedAt;

	/** 更新者 */
	private String updatedUser;
}
