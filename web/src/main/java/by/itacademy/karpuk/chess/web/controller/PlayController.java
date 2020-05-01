package by.itacademy.karpuk.chess.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/play")
public class PlayController extends AbstractController {

	@RequestMapping(value = "/live_chess", method = RequestMethod.GET)
	public ModelAndView playLiveChess(@RequestParam(name = "game_id", required = true) final Integer gameId) {
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("gameId", gameId);
		return new ModelAndView("live_chess", hashMap);
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
