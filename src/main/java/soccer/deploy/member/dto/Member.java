package soccer.deploy.member.dto;

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
public class Member {
	private Integer num;
	@Id
	@Column(name="member_id")
	private String id;
	private String password;
	private String name;
	private Integer age;
	private LocalDateTime regdate;
	
	public Member(Integer num, String id, String password, String name, Integer age, LocalDateTime regdate) {
		super();
		this.num = num;
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.regdate = regdate;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	
	

}

/*
CREATE TABLE member (
    member_id    VARCHAR2(10),
    password     VARCHAR2(10) NOT NULL,
    name         VARCHAR2(20) NOT NULL,
    age          NUMBER(3)    NOT NULL,
    regdate      DATE DEFAULT SYSDATE
);

ALTER TABLE member
    ADD ( CONSTRAINT member_id_pk PRIMARY KEY(member_id));
*/

