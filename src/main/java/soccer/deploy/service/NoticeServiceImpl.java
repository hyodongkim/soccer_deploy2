package soccer.deploy.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soccer.deploy.dto.Member;
import soccer.deploy.dto.Notice;
import soccer.deploy.dao.JpaMemberRepository;
import soccer.deploy.dao.JpaNoticeRepository;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private JpaNoticeRepository jpaNoticeRepository;
	
	@Override
	public String register(Notice notice) {
		Notice saveNotice = jpaNoticeRepository.save(notice);
		return saveNotice.getId();
	}

	@Override
	@Transactional(readOnly = true)
	public Notice isNotice(String id, String title) {
		return jpaNoticeRepository.findByIdAndTitle(id, title);
	}

	@Override
	public Optional<Notice> findNotice(int num) {
		return jpaNoticeRepository.findByNum(num);
	}
	
	@Override
	public List<Notice> findNotices() {
		return jpaNoticeRepository.findAll();
	}

	@Override
	public Page<Notice> findNotices(String searchValue, Pageable pageable) {
		return jpaNoticeRepository.findAllByIdOrTitleContaining(searchValue, searchValue, pageable);
	}
}
