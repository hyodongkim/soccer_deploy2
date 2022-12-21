package soccer.deploy.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.notice.dto.Notice;

@Mapper
public interface NoticeDAO {

	List<Notice> selectID(String id);

}
