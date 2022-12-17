package soccer.deploy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.dto.Notice;

@Mapper
public interface NoticeDAO {

	List<Notice> selectID(String id);


}
