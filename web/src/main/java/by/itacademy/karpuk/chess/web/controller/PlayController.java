package by.itacademy.karpuk.chess.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/play")
public class PlayController extends AbstractController {

	@RequestMapping(value = "/live_chess", method = RequestMethod.GET)
	public String playLiveChess() {
		return "live_chess";
	}

	@RequestMapping(value = "/board_editor", method = RequestMethod.GET)
	public String playBoardEditor() {
		return "board_editor";
	}
	@RequestMapping(value = "/random_computer", method = RequestMethod.GET)
	public String playRandomComputer() {
		return "random_computer";
	}

}
