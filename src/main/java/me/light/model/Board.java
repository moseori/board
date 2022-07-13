package me.light.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {

	private Long bno;
	private String title;
	private String contents;
	private String writer;
	private int replyCnt;
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	private int viewCount;
	
	private List<BoardAttachVO> attachList;
}
