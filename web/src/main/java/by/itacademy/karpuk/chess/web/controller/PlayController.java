package by.itacademy.karpuk.chess.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/play")
public class PlayController extends AbstractController {

	@RequestMapping(method = RequestMethod.GET)
	public String createBoard() {
		return "board";
	}

}
