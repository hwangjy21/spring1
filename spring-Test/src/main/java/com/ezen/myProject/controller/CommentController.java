package com.ezen.myProject.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.myProject.domain.CommentVO;
import com.ezen.myProject.domain.MemberVO;
import com.ezen.myProject.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/comment/*")
@RestController
public class CommentController {

	@Inject
	private CommentService csv;
	
	//ResponseEntity 객체 사용
	//@RequestBody : body값 추출
	//value="mappling name" , consumes : 가져오는 데이터의 형태
	//produces : 보내는 데이터의 형식 / 나가는 데이터 타입 : MediaType.
	// json : application/json  text : text_plain
	@PostMapping(value = "/post", consumes ="application/json",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> post(@RequestBody CommentVO cvo){
		log.info(">>>> cvo >> "+cvo);
		//DB연결
		int isOk = csv.post(cvo);
		//리턴시 respose의 통신상태를 같이 리턴
		return isOk>0 ? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping(value="/{bno}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentVO>> spread(
			@PathVariable("bno") int bno){
		log.info(">>>>> comment List bno >> "+bno);
		//DB 요청
		List<CommentVO> list = csv.getList(bno);
		return new ResponseEntity<List<CommentVO>>(list, HttpStatus.OK);
	}
	
	@PutMapping(value="/{cno}", consumes = "application/json", 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> edit(@PathVariable("cno")int cno,
			@RequestBody CommentVO cvo, HttpServletRequest req ){
		log.info(" >>>> cno /: cvo >> "+cno+" / "+cvo);
		int isOk=0;
		HttpSession ses = req.getSession();
		if(ses != null) {
			MemberVO mvo = (MemberVO)ses.getAttribute("ses");
			if(mvo.getId().equals(cvo.getWriter())) {
				 isOk = csv.edit(cvo);
			}else {
				return new ResponseEntity<String>("2", HttpStatus.OK);
			}
			
		}
		return isOk > 0? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="/del/{cno}/{writer}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> delete(@PathVariable("cno") int cno, 
			@PathVariable("writer")String writer, HttpServletRequest req ){
		log.info(" >>>> cno / writer  >> "+cno+" / "+writer);
		
		int isOk = 0;
		HttpSession ses = req.getSession();
		if(ses != null) {
			MemberVO mvo = (MemberVO)ses.getAttribute("ses");
			if(mvo.getId().equals(writer)) {
				isOk = csv.remove(cno);
			}else {
				return new ResponseEntity<String>("2", HttpStatus.OK);
			}
		}
		return isOk > 0? new ResponseEntity<String>("1", HttpStatus.OK) 
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
}
