package com.example.effiwork.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
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
public class Tasks {

	/** タスクID */
	@Id
	private String taskId;

	/** ユーザーID */
	private String userId;

	/** タイトル */
	private String title;

	/** タスク内容 */
	private String description;

	/** タスク開始日 */
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate  startOn;

	/** タスク終了日 */
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate  endOn;

	/** タスクステータス */
	private Integer status;

	/** 作成日時 */
	private LocalDateTime createdAt;

	/** 更新日時 */
	private LocalDateTime updatedAt;
}
