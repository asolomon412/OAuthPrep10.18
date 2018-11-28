package com.oauthdemo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oauthdemo.entity.GithubService;
import com.oauthdemo.entity.GithubUser;
import com.oauthdemo.repo.UserRepository;

@Controller
public class AuthController {

	@Autowired
	UserRepository userRepo;
	@Autowired
	GithubService githubService;
	@Autowired
	HttpSession session;

	@RequestMapping("/login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("login");
	}

	@PostMapping("/login")
	// get the username and password from the form when it's submitted.
	public ModelAndView submitLoginForm(@RequestParam("username") String username, @RequestParam("password") String password,
			RedirectAttributes redir) {
		// Find the matching user.
		GithubUser user = userRepo.findByLogin(username);
		if (user == null) {
			// If the user or password don't match, display an error message.
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Incorrect username or password.");
			return mav;
//		} else if (user.getLogin()!= null && user.getPassword() == null) {
//			ModelAndView mav = new ModelAndView("login");
//			mav.addObject("message", "Need to set a password.");
//			return mav;
		}
		
		// On successful login, add the user to the session.
		session.setAttribute("user", user);
		
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Logged in.");
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/logout")
	public ModelAndView logout(RedirectAttributes redir) {
		// invalidate clears the current user session and starts a new one.
		session.invalidate();
		
		// A flash message will only show on the very next page. Then it will go away.
		// It is useful with redirects since you can't add attributes to the mav.
		redir.addFlashAttribute("message", "Logged out.");
		return new ModelAndView("redirect:/");
	}

	// This is the second step in OAuth. After the user approves the login on the github site, it redirects back
	// to our site with a temporary code.
	@RequestMapping("/result")
	public ModelAndView handleGithubCallback(@RequestParam("code") String code) {
		// First we must exchange that code for an access token.
		String accessToken = githubService.getGithubAccessToken(code);
		// Then we can use that access token to get information about the user and other things.
		GithubUser githubUser = githubService.getUserFromGithubApi(accessToken);

		// Check to see if the user is already in our database.
		GithubUser user = userRepo.findById(githubUser.getId()).orElse(null);
		if (user == null) {
			// if not, add them.
			user = githubUser;
			userRepo.save(user);
		}

		// Set the user on the session, just like the other type of login.
		session.setAttribute("user", user);
		// In some apps, you need the access token later, so throw that on the session, too.
		session.setAttribute("githubAccessToken", accessToken);

		return new ModelAndView("redirect:/");
	}

	

}