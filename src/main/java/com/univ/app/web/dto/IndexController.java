package com.univ.app.web.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.univ.app.model.board.Board;
import com.univ.app.model.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

//	private final 

	@Autowired
	BoardRepository boardRepository;

	@RequestMapping(value = "/mainpage.do")
	public String index(Model model) {

		try {
			List<Board> boardList = boardRepository.findAll();
			model.addAttribute("boardList",boardList);
			System.out.println("findAll");
			for (Board b : boardList) {
				System.out.println(b.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "mainpage";
	}

	@RequestMapping(value = "/chat.do")
	public String chat() {

		return "chat";
	}

	@RequestMapping(value = "/insertBoard.do", produces = "application/text; charset=utf8")
	public String updateFeed(String board_writer, String board_title, String board_content) {

		Board board = Board.builder().board_writer(board_writer).board_title(board_title).board_content(board_content)
				.build();
		System.out.println("updateFeed");
		System.out.println(board.toString());

		boardRepository.save(board);

		return "redirect:mainpage.do";
	}

}
