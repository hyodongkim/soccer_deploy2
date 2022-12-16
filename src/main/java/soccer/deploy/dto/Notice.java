package soccer.deploy.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Notice {
	@Id
	@Column(name="member_id")
	private String id;
	@Column(name="notice_title")
	private String title;
	@Column(name="notice_content")
	private String content;
	@Column(name="notice_date")
	private LocalDateTime notice_date;
	
}


//create table notice(
//	    member_id varchar2(20),
//		notice_title varchar2(100), 
//		notice_content varchar2(1000), 
//		notice_date date default sysdate
//	);