package com.timcoville.counter;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
@Controller
@RequestMapping("/")
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
			return "index.jsp";
		}
		else {
			Integer count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
			return "index.jsp";
		}
		
	}
	
	@RequestMapping("/ninja")
	public String ninja(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 2);
			return "ninja.jsp";
		}
		else {
			Integer count = (Integer) session.getAttribute("count");
			count++;
			count++;
			session.setAttribute("count", count);
			return "ninja.jsp";
		}
		
	}
	
	@RequestMapping("/clear")
	public RedirectView clear(HttpSession session, RedirectAttributes attributes) {
		if (session.getAttribute("count") == null) {
			return new RedirectView("/");
		}
		else {
			session.removeAttribute("count");
			return new RedirectView("/");
		}
	}
	@RequestMapping("counter")
	public String counter(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		return "counter.jsp";
	}
}
