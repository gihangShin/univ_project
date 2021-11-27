package com.univ.app.web.dto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.univ.app.model.board.Board;
import com.univ.app.model.board.BoardRepository;
import com.univ.app.model.comment.Comment;
import com.univ.app.model.comment.CommentRepository;
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

	@Autowired
	CommentRepository commentRepository;

	@RequestMapping(value = "/mainpage.do")
	public String mainpage(Model model) {

		List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardSeq"));
		List<User> userList = userRepository.findAll();

		for (Board board : boardList) {
			List<Comment> commentList = commentRepository.findAllByBoardSeq(board.getBoardSeq());
			if (!commentList.isEmpty()) {
				board.setComments(commentList);
			}
		}

		if (boardList == null) {
			String notice = "저장된 게시글이 없습니다.";
			model.addAttribute("notice", notice);
		} else {
			model.addAttribute("userList", userList);
			model.addAttribute("boardList", boardList);
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
	public String insertBoard(Board board, @RequestPart MultipartFile files) throws Exception {
		System.out.println("files : " + files.toString());
		if (!files.isEmpty()) { // 파일이 있을 경우
			String sourceFileName = files.getOriginalFilename();
			File destinationFile;
			String fileUrl = "C:/workspace/eclipse/springFramework/univ_project/src/main/webapp/images/";
			do {
				destinationFile = new File(fileUrl + sourceFileName);
			} while (destinationFile.exists());

			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);

			board.setFileOriName(sourceFileName);
			board.setFileUri(fileUrl);
		}
		System.out.println(board.toString());
		boardRepository.save(board);
//		Board board = Board.builder().board_writer(board_writer).board_title(board_title).board_content(board_content)
//				.build();
		System.out.println("insertBoard");

		return "redirect:mainpage.do";
	}

	@RequestMapping(value = "/login.do")
	public String login(HttpSession session, String userId, String userPassword, Model model) {
		// 로그인
		Optional<User> optionalUser = userRepository.findByUserIdAndUserPassword(userId, userPassword);
		System.out.println("id : " + userId);
		System.out.println("pw : " + userPassword);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			System.out.println("로그인 성공");
			session.setAttribute("user", user);

			return "redirect:mainpage.do";
		} else {
			System.out.println("로그인 실패");
			model.addAttribute("notice", "loginfail");
			return "indexpage";
		}
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session, Model model) {
		// 로그아웃
		session.invalidate();

		String notice = "logout";
		model.addAttribute("notice", notice);

		return "indexpage";
	}

	@RequestMapping(value = "/signup.do", produces = "application/text; charset=utf8")
	public String signup(User user, Model model) {
		// 회원가입

		System.out.println("signupuser : " + user);
		userRepository.save(user);
		model.addAttribute("notice", "signupsuccess");

		return "indexpage";
	}

	@RequestMapping(value = "/insertcomment.do", produces = "application/text; charset=utf8")
	public String insertCommet(Comment comment) {
		System.out.println("comment : " + comment);
		commentRepository.save(comment);
		return "redirect:mainpage.do";
	}

	@RequestMapping(value = "/boardlike.do", method = RequestMethod.GET)
	public String boardLike(@RequestParam String boardSeq) {

		Long num = (long) Integer.parseInt(boardSeq);

		boardRepository.updateBoardLike(num);

		return "redirect:mainpage.do";
	}

	@RequestMapping(value = "/commentlike.do", method = RequestMethod.GET)
	public String commentLike(@RequestParam Long commentSeq) {

		commentRepository.updateCommentLike(commentSeq);

		return "redirect:mainpage.do";
	}

}
