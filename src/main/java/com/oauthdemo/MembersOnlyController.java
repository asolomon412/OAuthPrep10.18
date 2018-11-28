package com.oauthdemo;

import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oauthdemo.entity.GithubUser;

@Controller
public class MembersOnlyController {
	
	@RequestMapping("/secrets")
	public ModelAndView index(@SessionAttribute(name="user", required=false) GithubUser user, RedirectAttributes redir) {
		// For this URL, make sure there is a user on the session.
		if (user == null) {
			// if not, send them back to the login page with a message.
			redir.addFlashAttribute("message", "Wait! Please log in.");
			return new ModelAndView("redirect:/login");
		}
		
		// if the user is logged in, proceed as normal.
		ModelAndView mv = new ModelAndView("secrets");
		mv.addObject("joke", Arrays.asList("Chuck Norris can kill two stones with one bird.",
				"Giraffes were created when Chuck Norris uppercutted a horse.",
				"Chuck Norris beat the sun in a staring contest.",
				"Chuck Norris is the reason Waldo is hiding.",
				"Chuck Norris makes onions cry.",
				"Chuck Norris can rub two pieces of fire together and make wood.")
		.get(new Random().nextInt(6)));
		
		
		return mv;
	}

}