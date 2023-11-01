package com.ezen.myproject.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.myproject.domain.BoardVO;

import com.ezen.myproject.domain.PagingVO;
import com.ezen.myproject.handler.PagingHandler;
import com.ezen.myproject.service.BoardService;
import com.ezen.myproject.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board/*")
@Controller
public class BoardController {
	@Inject
	private BoardService bsv;
	private CommentService csv;
	@GetMapping("/register")
	public String boardRegisterGet() {
		return "/board/register";
	}

	/*
	 * @PostMapping("/register") public String register(BoardVO bvo) {
	 * log.info(">>>>>" + bvo.toString()); int isOK = bsv.register(bvo);
	 * log.info(">>>>> register 들어옴" + (isOK > 0 ? "ok" : "실패")); return
	 * "redirect:/board/list"; }
	 */
	//required(필수 여부)=false : 해당파라미터가 없어도 예외가 발생하지 않음.
	@PostMapping("/register")
	public String register(BoardVO bvo, @RequestParam(name="files", required = false)MultipartFile[] files) {
		log.info(">>>>>" + bvo.toString());
		log.info(">>>>files >>"+files);
		/*
		 * int isOK = bsv.register(bvo); log.info(">>>>> register 들어옴" + (isOK > 0 ?
		 * "ok" : "실패"));
		 */
		return "redirect:/board/list";
	}


	@GetMapping("/list")
	public String list(Model model, PagingVO pgvo) {

		log.info("pagingVO>>>" + pgvo);
		// getList(pgvo); 수정
		List<BoardVO> list = bsv.getList(pgvo);
		log.info("getlist 들어옴");
		model.addAttribute("list", list);

		int totalCount = bsv.getTotalCount(pgvo);// 등록
		/* list = bsv.getPageList(pgvo); */
		PagingHandler ph = new PagingHandler(pgvo, totalCount);

		model.addAttribute("ph", ph);
		return "/board/list";
	}

	@GetMapping({ "/detail", "/modify" })
	public void detail(Model model, @RequestParam("bno") int bno) {

		log.info(">>>> 디테일 bno" + bno);
		BoardVO bvo = bsv.getDetail(bno);
		model.addAttribute("bvo", bvo);
	}


	/*
	 * public void boardmodifyGet(Model model, @RequestParam("bno") int bno) {
	 * log.info(">>>> 수정 bno" + bno); BoardVO bvo = bsv.getDetail(bno);
	 * model.addAttribute("bvo", bvo);
	 * 
	 * }
	 */

	@PostMapping("/modify")
	public String getBoardDetail(BoardVO bvo, RedirectAttributes reAtr) {

		int isOK = bsv.getModify(bvo);
		log.info(">>>>> 수정 들어옴" + (isOK > 0 ? "ok" : "실패"));

		return "redirect:/board/detail?bno=" + bvo.getBno();

	}

	@GetMapping("/delete")
	public String getBoardDetail(@RequestParam("bno") int bno, RedirectAttributes reAtr) {

		int isOK = bsv.getdelete(bno);
		log.info(">>>>> 삭제 들어옴" + (isOK > 0 ? "ok" : "실패"));
		reAtr.addFlashAttribute("isOK", isOK);

		return "redirect:/board/list";

	}

}
