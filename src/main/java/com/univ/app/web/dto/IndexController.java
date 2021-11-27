package com.univ.app.web.dto;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.univ.app.model.board.Board;
import com.univ.app.model.board.BoardRepository;
import com.univ.app.model.user.User;
import com.univ.app.model.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

//	private final 

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@RequestMapping(value = "/mainpage.do")
	public String mainpage(Model model) {

		List<Board> boardList = boardRepository.findAll();
		
		if(boardList==null) {
			String notice = "저장된 게시글이 없습니다.";
			model.addAttribute("notice", notice);
		}else {
			model.addAttribute("boardList",boardList);
			System.out.println("findAll");
			for (Board b : boardList) {
				System.out.println(b.toString());
			}
		}
		return "mainpage";
	}

	@RequestMapping(value = "/chat.do")
	public String chat() {

		return "chat";
	}

	@RequestMapping(value = "/insertBoard.do", produces = "application/text; charset=utf8")
	public String insertBoard(Board board) {

		System.out.println(board.toString());
		boardRepository.save(board);
//		Board board = Board.builder().board_writer(board_writer).board_title(board_title).board_content(board_content)
//				.build();
		System.out.println("insertBoard");

		return "redirect:mainpage.do";
	}

	@RequestMapping(value = "/login.do")
	public String login(HttpSession session,String userId, String userPassword, Model model) {
		// 로그인
		Optional<User> optionalUser = userRepository.findByUserIdAndUserPassword(userId, userPassword);
		System.out.println("id : "+userId);
		System.out.println("pw : "+userPassword);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			System.out.println("로그인 성공");
			session.setAttribute("user", user);
			
			return "redirect:mainpage.do";
		}else {
			System.out.println("로그인 실패");
			model.addAttribute("notice", "loginfail");
			return "indexpage";
		}
	}
	
	@RequestMapping(value="/signup.do", produces = "application/text; charset=utf8")
	public String signup(User user, Model model) {
		// 회원가입
		
		System.out.println("signupuser : "+user);
		userRepository.save(user);
		model.addAttribute("notice", "signupsuccess");
		
		return "indexpage";
	}
}
