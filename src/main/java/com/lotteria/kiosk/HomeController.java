package com.lotteria.kiosk;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lotteria.kiosk.dto.BurgerDTO;
import com.lotteria.kiosk.dto.ChoiceDTO;
import com.lotteria.kiosk.dto.DrinkDTO;
import com.lotteria.kiosk.dto.SideDTO;
import com.lotteria.kiosk.service.OrderServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private OrderServiceImpl orderService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
//		session.setMaxInactiveInterval(500);
		if (orderService.findLastOrderNumber()==null) {
			session.setAttribute("orderNumber",1);
		} else {
			session.setAttribute("orderNumber", orderService.findLastOrderNumber().getId()+1);			
		}
		orderService.deleteChoice();
		mav.setViewName("/home");
		return mav;
	}
	
}