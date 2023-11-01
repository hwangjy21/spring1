package com.ezen.myproject.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Delete;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.myproject.domain.CommentVO;
import com.ezen.myproject.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/comment/*")
@RestController
public class CommentController {
@Inject
private CommentService csv;

//ResponseEntity 객체 사용

//@RequestBody :body값 추출
//public ResponseEntity<list<CommentVO>>
//value="mappling name" consumes : 가져오는 데이터의 형태
//produces : 보내는 데이터의 형식// 나가는 데이터 타입 :MediaType
//json : application/json text: text_plain 
@PostMapping(value = "/post", consumes ="application/json",produces = MediaType.TEXT_PLAIN_VALUE
) 
public ResponseEntity<String> post(@RequestBody CommentVO cvo){
	//DB 연결
	int isok = csv.post(cvo);
	//리턴식 respose 의 통신상태를 같으 리턴
	return isok>0? new ResponseEntity<String>("1", HttpStatus.OK)
			: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
}










@GetMapping(value="/{bno}",produces = MediaType.APPLICATION_JSON_VALUE) 
public ResponseEntity<List<CommentVO>> spead(@PathVariable("bno") int bno){
	log.info(">>>>comment List bno>>"+bno);
	//디비요청
	
	List<CommentVO> list = csv.getlist(bno);
	
	return new ResponseEntity<List<CommentVO>>(list,HttpStatus.OK);
	
}

@PutMapping(value ="/{cno}", consumes = "application/json",
produces = MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String> edit(@PathVariable("cno")int cno,
		@RequestBody CommentVO cvo){

	log.info(">>>>>>cno /  cvo"+cno+"////"+cvo);
	int isOk =csv.edit(cvo);
	
	return isOk>0?new ResponseEntity<String>("1", HttpStatus.OK) : new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR); 
}

@DeleteMapping(value ="/{cno}", consumes = "application/json",
produces = MediaType.TEXT_PLAIN_VALUE)
public ResponseEntity<String> delete(@PathVariable("cno") int cno) {

	int isOK = csv.getdelete(cno);
	log.info(">>>>> 삭제 들어옴" + (isOK > 0 ? "ok" : "실패"));
	

	return isOK>0?new ResponseEntity<String>("1", HttpStatus.OK) : new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR); 

}












}
