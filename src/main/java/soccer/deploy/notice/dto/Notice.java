package soccer.deploy.notice.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
@NoArgsConstructor
@Table(name="Notice")
@SequenceGenerator( name= "num_gen",
		sequenceName = "num",
		initialValue = 1,
		allocationSize = 1)
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_gen")
	private Integer num;

	@Column(name="member_id")
	private String id;
	@Column(name="notice_title")
	private String title;
	@Column(name="notice_content")
	private String content;
	@Column(name="notice_date")
	
	private LocalDateTime notice_date;
	public Notice() {
	}
	public Notice(Integer num, String id, String title, String content, LocalDateTime notice_date) {
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.notice_date = notice_date;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		
		this.content = content;
	}
	public LocalDateTime getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(LocalDateTime notice_date) {
		this.notice_date = notice_date;
	}
	
	
	
	
}


//create table notice(
//	    member_id varchar2(20),
//		notice_title varchar2(100), 
//		notice_content varchar2(1000), 
//		notice_date date default sysdate
//	);