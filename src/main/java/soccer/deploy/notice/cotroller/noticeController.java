package soccer.deploy.notice.cotroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.notice.dao.NoticeDAO;
import soccer.deploy.notice.dto.Notice;
import soccer.deploy.notice.service.NoticeService;

@Controller
@Slf4j
public class noticeController {
	
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NoticeDAO noticeDAO;
	
	@GetMapping("/realNoticeAction")
	/* default page = 0, default size = 10 */
	public String reallistBySearchAndPaging(@PageableDefault(page = 0, size = 10, sort = "title", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search, Model model,  @RequestParam(required = false, defaultValue = "") String id) {
		
		Page<Notice> page = noticeService.findNotices(search, pageable);
		    	
		long totalElements = page.getTotalElements();
		int requestPage = page.getPageable().getPageNumber() + 1;
		int totalPage = page.getTotalPages();
		int startPage = Math.max(1, requestPage - 4);
		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
		boolean hasPrevious = page.hasPrevious();
		boolean hasNext = page.hasNext();
		
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("list",noticeService.findNotices(id,pageable));
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPrevious", hasPrevious);
		model.addAttribute("hasNext", hasNext);
		
		return "thymeleaf/realNotice";
	}
	@RequestMapping("/realNotice")
	public String realSearch(@PageableDefault(page = 0, size = 10, sort = "title", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search,  Model model, @RequestParam(required = false, defaultValue = "") String id) {
	
		Page<Notice> page = noticeService.findNotices(search, pageable);
		
		long totalElements = page.getTotalElements();	
		List<Notice> list = page.getContent();
		int requestPage = page.getPageable().getPageNumber() + 1;
		int totalPage = page.getTotalPages();
		int startPage = Math.max(1, requestPage - 4);
		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
		boolean hasPrevious = page.hasPrevious();
		boolean hasNext = page.hasNext();
		
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("list", list);
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPrevious", hasPrevious);
		model.addAttribute("hasNext", hasNext);
		
		return "thymeleaf/realNotice";
	}
	
	@GetMapping("/{num}")
	/* default page = 0, default size = 10 */
	public String view(@PathVariable int num, Model model) {
		Optional<Notice> optional = noticeService.findNotice(num);
		model.addAttribute("list", optional.get());
		return "thymeleaf/intoNotice";
	}
}
