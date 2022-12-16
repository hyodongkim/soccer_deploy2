package soccer.deploy;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.dto.Member;
import soccer.deploy.dto.Notice;
import soccer.deploy.service.MemberService;
import soccer.deploy.service.NoticeService;
import soccer.deploy.entity.LoginForm;
import soccer.deploy.entity.MemberForm;

@Controller
@Slf4j
public class MyController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private NoticeService noticeService;

	//시작(로그인)
	@RequestMapping("/")
	public String index() {

		return "index";
	}

	//채팅예시, 스와이퍼
	@RequestMapping("/main")
	public String main() {

		return "view/main";
	}

	//네개의 컬럼 보내기
	@RequestMapping("/contact")
	public String contact() {

		return "view/contact";
	}

	//대진표
	@RequestMapping("/matches")
	public String matches() {

		return "view/matches";
	}

	//선수에대한 정보(표)
	@RequestMapping("/players")
	public String players() {

		return "view/players";
	}

	//댓글
	@RequestMapping("/single")
	public String single() {

		return "view/single";
	}

	//블로그
	@RequestMapping("/blog")
	public String blog() {

		return "view/blog";
	}

	//옛날 내가만든거. 데이터 뿌리기용으로 쓰세요
	@RequestMapping("/mainPage")
	public String mainPage() {

		return "view/mainPage";
	}

	//로그인
	@RequestMapping("/login")
	public String login() {
		
		return "view/user/login";
	}

	//채팅과 로그인으로 들어가는 버튼
	@RequestMapping("/xMain")
	public String xMain() {

		return "view/xMain";
	}
	
	//회원가입
	@RequestMapping("/signup")
	public String signUp() {
		return "signup";
	}

	//경기장 그림
	@GetMapping("/test")
	public String lineUp() {
		return "view/lineUp/lineUp";
	}
	
//	@RequestMapping("/notice")
//	/* default page = 0, default size = 10 */
//	public String listBySearchAndPaging(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search, Model model) {
//		
//		Page<Member> page = memberService.findMembers(search, pageable);
//		    	
//		long totalElements = page.getTotalElements();
//		List<Member> list = page.getContent();	
//		int requestPage = page.getPageable().getPageNumber() + 1;
//		int totalPage = page.getTotalPages();
//		int startPage = Math.max(1, requestPage - 4);
//		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
//		boolean hasPrevious = page.hasPrevious();
//		boolean hasNext = page.hasNext();
//		
//		model.addAttribute("totalElements", totalElements);
//		model.addAttribute("list", list);
//		model.addAttribute("requestPage", requestPage);
//		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("hasPrevious", hasPrevious);
//		model.addAttribute("hasNext", hasNext);
//		
//		return "thymeleaf/notice";
//	}
//	@GetMapping("/notice")
//	public String Search(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search,  Model model, @RequestParam(required = false, defaultValue = "") String id) {
//	
//		Page<Member> page = memberService.findMembers(search, pageable);
//		
//		long totalElements = page.getTotalElements();	
//		int requestPage = page.getPageable().getPageNumber() + 1;
//		int totalPage = page.getTotalPages();
//		int startPage = Math.max(1, requestPage - 4);
//		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
//		boolean hasPrevious = page.hasPrevious();
//		boolean hasNext = page.hasNext();
//		
//		model.addAttribute("totalElements", totalElements);
//		model.addAttribute("list", memberService.findMembers(id,pageable));
//		model.addAttribute("requestPage", requestPage);
//		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("hasPrevious", hasPrevious);
//		model.addAttribute("hasNext", hasNext);
//		
//		return "thymeleaf/notice";
//	}
	
	@RequestMapping("/realNotice")
	/* default page = 0, default size = 10 */
	public String reallistBySearchAndPaging(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search, Model model) {
		
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
	@GetMapping("/realNotice")
	public String realSearch(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search,  Model model, @RequestParam(required = false, defaultValue = "") String id) {
	
		Page<Notice> page = noticeService.findNotices(search, pageable);
		
		long totalElements = page.getTotalElements();	
		int requestPage = page.getPageable().getPageNumber() + 1;
		int totalPage = page.getTotalPages();
		int startPage = Math.max(1, requestPage - 4);
		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
		boolean hasPrevious = page.hasPrevious();
		boolean hasNext = page.hasNext();
		
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("list", noticeService.findNotices(id,pageable));
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPrevious", hasPrevious);
		model.addAttribute("hasNext", hasNext);
		
		return "thymeleaf/realNotice";
	}
}
