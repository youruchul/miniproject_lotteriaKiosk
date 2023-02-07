package com.lotteria.kiosk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lotteria.kiosk.dto.BurgerDTO;
import com.lotteria.kiosk.dto.ChoiceDTO;
import com.lotteria.kiosk.dto.CouponDTO;
import com.lotteria.kiosk.dto.DrinkDTO;
import com.lotteria.kiosk.dto.FoodDTO;
import com.lotteria.kiosk.dto.OrdersDTO;
import com.lotteria.kiosk.dto.RecipeDTO;
import com.lotteria.kiosk.dto.SideDTO;
import com.lotteria.kiosk.service.AdminServiceImpl;
import com.lotteria.kiosk.service.OrderServiceImpl;

@Controller
public class KioskController {
	private static final Logger logger = LoggerFactory.getLogger(KioskController.class);
	
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private AdminServiceImpl adminService;
	
	@RequestMapping(value = "/kiosk/home", method = RequestMethod.GET)
	public ModelAndView home() {
		// TODO : 전체 가져오는 거
			List<BurgerDTO> ableBurgers = new ArrayList<BurgerDTO>();
			List<BurgerDTO> allBurgers = orderService.findAllBurgerList();
			for (BurgerDTO burger : allBurgers) {
				List<RecipeDTO> recipes = orderService.findListByitemId(burger.getId());
				Integer ableCheck = 0;
				for (RecipeDTO recipe : recipes) {
					if(adminService.findOneFood(recipe.getFoodId()).getCount()<=0) {
						ableCheck++;
					}
				}
				if(ableCheck==0) {
					ableBurgers.add(burger);
				}
			}
			List<ChoiceDTO> allChoose = orderService.findAllChoiceList();
			List<DrinkDTO> allDrinks = orderService.findAllDrinkList();
			List<SideDTO> allSides = orderService.findAllSideList();								
			ModelAndView mav = new ModelAndView();
			mav.addObject("choose", allChoose);
			mav.addObject("burgers", allBurgers);
			mav.addObject("drinks", allDrinks);
			mav.addObject("sides", allSides);
			mav.addObject("ableBurgers", ableBurgers);
			mav.setViewName("/kiosk/home");
			return mav;
	}
	
	@RequestMapping(value = "/kiosk/selectSet", method = RequestMethod.GET)
	public ModelAndView getSelectSet(
			@RequestParam("burgerId") Integer burgerId
			) {
				BurgerDTO burger = orderService.findOneById(burgerId);
				List<BurgerDTO> allBurgers = orderService.findAllBurgerList();
				List<ChoiceDTO> allChoose = orderService.findAllChoiceList();
				List<DrinkDTO> allDrinks = orderService.findAllDrinkList();
				List<SideDTO> allSides = orderService.findAllSideList();								
				ModelAndView mav = new ModelAndView();
				mav.addObject("choose", allChoose);
				mav.addObject("burgers", allBurgers);
				mav.addObject("drinks", allDrinks);
				mav.addObject("sides", allSides);		
				mav.setViewName("/kiosk/selectSet");
				mav.addObject("burger", burger);
				return mav;
	}
	
	@RequestMapping(value = "/kiosk/selectDrink", method = RequestMethod.GET)
	public ModelAndView getSelectDrink(
			) {
		// TODO : 전체 가져오는 거
				List<BurgerDTO> allBurgers = orderService.findAllBurgerList();
				List<ChoiceDTO> allChoose = orderService.findAllChoiceList();
				List<DrinkDTO> allDrinks = orderService.findAllDrinkList();
				List<SideDTO> allSides = orderService.findAllSideList();								
				ModelAndView mav = new ModelAndView();
				mav.addObject("choose", allChoose);
				mav.addObject("burgers", allBurgers);
				mav.addObject("drinks", allDrinks);
				mav.addObject("sides", allSides);
				mav.setViewName("/kiosk/selectDrink");
				return mav;
	}
	
	@RequestMapping(value = "/kiosk/selectSide", method = RequestMethod.GET)
	public ModelAndView getSelectSide(
			) {
		// TODO : 전체 가져오는 거
				List<BurgerDTO> allBurgers = orderService.findAllBurgerList();
				List<ChoiceDTO> allChoose = orderService.findAllChoiceList();
				List<DrinkDTO> allDrinks = orderService.findAllDrinkList();
				List<SideDTO> allSides = orderService.findAllSideList();								
				ModelAndView mav = new ModelAndView();
				mav.addObject("choose", allChoose);
				mav.addObject("burgers", allBurgers);
				mav.addObject("drinks", allDrinks);
				mav.addObject("sides", allSides);
				mav.setViewName("/kiosk/selectSide");
				return mav;
	}
	
	@RequestMapping(value = "/kiosk/coupon", method = RequestMethod.GET)
	public ModelAndView getCoupon(
			) {
		// TODO : 전체 가져오는 거
				ModelAndView mav = new ModelAndView();
				mav.setViewName("/kiosk/coupon");
				return mav;
	}
	
	@RequestMapping(value = "/kiosk/payment", method = RequestMethod.GET)
	public ModelAndView getPayment(
			@RequestParam("couponCode") String couponCode
			) {
		// TODO : 전체 가져오는 거
		List<BurgerDTO> allBurgers = orderService.findAllBurgerList();
		List<ChoiceDTO> allChoose = orderService.findAllChoiceList();
		List<DrinkDTO> allDrinks = orderService.findAllDrinkList();
		List<SideDTO> allSides = orderService.findAllSideList();
		CouponDTO coupon = orderService.findOneByCode(couponCode);
		if (coupon == null) {
			coupon = orderService.findOneByCode("00");
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("choose", allChoose);
		mav.addObject("burgers", allBurgers);
		mav.addObject("drinks", allDrinks);
		mav.addObject("sides", allSides);
		mav.addObject("coupon",coupon);
		mav.setViewName("/kiosk/payment");
		mav.addObject("couponCode",couponCode);
		return mav;
	}
	
	@RequestMapping(value = "/kiosk/insertBurger", method = RequestMethod.GET)
	public ModelAndView getinsertBurger(
			@RequestParam("burgerId") Integer burgerId
			) {
		// TODO : 전체 가져오는 거
		ChoiceDTO choiceFood = new ChoiceDTO();
		choiceFood.setCategoryId(1);
		choiceFood.setItemId(burgerId);
		logger.info(choiceFood.toString());
		orderService.choiceFood(choiceFood);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/kiosk/selectSet");
		mav.addObject("burgerId",burgerId);
		return mav;
	}
	
	@RequestMapping(value = "/kiosk/insertSetDiscount", method = RequestMethod.GET)
	public ModelAndView getinsertSetDiscount() {
		// TODO : 전체 가져오는 거
		ChoiceDTO choiceFood = new ChoiceDTO();
		choiceFood.setCategoryId(0);
		choiceFood.setItemId(0);
		logger.info(choiceFood.toString());
		orderService.choiceFood(choiceFood);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/kiosk/selectDrink");
		return mav;
	}
	
	@RequestMapping(value = "/kiosk/insertDrink", method = RequestMethod.GET)
	public ModelAndView getinsertDrink(
			@RequestParam("drinkId") Integer drinkId
			) {
		// TODO : 전체 가져오는 거
		ChoiceDTO choiceFood = new ChoiceDTO();
		choiceFood.setCategoryId(2);
		choiceFood.setItemId(drinkId);
		logger.info(choiceFood.toString());
		orderService.choiceFood(choiceFood);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/kiosk/selectSide");
		return mav;
	}
	
	@RequestMapping(value = "/kiosk/insertSide", method = RequestMethod.GET)
	public ModelAndView getinsertSide(
			@RequestParam("sideId") Integer sideId
			) {
		// TODO : 전체 가져오는 거
		ChoiceDTO choiceFood = new ChoiceDTO();
		choiceFood.setCategoryId(3);
		choiceFood.setItemId(sideId);
		logger.info(choiceFood.toString());
		orderService.choiceFood(choiceFood);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/kiosk/home");
		return mav;
	}
	
	@RequestMapping(value = "/kiosk/insertOrder", method = RequestMethod.GET)
	public ModelAndView getInsertOrder(
			@RequestParam("orderNumber") Integer orderNumber,
			@RequestParam("totalCount") Integer totalCount,
			@RequestParam("totalPrice") Integer totalPrice
			) {
		// TODO : 전체 가져오는 거
		OrdersDTO order = new OrdersDTO(orderNumber,totalCount,totalPrice);
		logger.info(order.toString());
		orderService.insertOrder(order);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/kiosk/updateFoodCount");
		return mav;
	}
	
	@RequestMapping(value = "/kiosk/updateFoodCount", method = RequestMethod.GET)
	public ModelAndView getUpdateFoodCount(HttpServletRequest req) {
		// TODO : 전체 가져오는 거
		List<ChoiceDTO> allChoose = orderService.findAllChoiceList();
		for (ChoiceDTO choice : allChoose) {
			if (choice.getCategoryId()==1) {
				for (int i = 0; i < choice.getCount(); i++) {
					List<RecipeDTO> recipes = orderService.findListByitemId(choice.getItemId());
					for (RecipeDTO recipe : recipes) {
						FoodDTO food = adminService.findOneFood(recipe.getFoodId());
						orderService.updateFoodCount(food);
					}					
				}
			}
		}
		HttpSession session = req.getSession();
		if (orderService.findLastOrderNumber()==null) {
			session.setAttribute("orderNumber",1);
		} else {
			session.setAttribute("orderNumber", orderService.findLastOrderNumber().getId()+1);			
		}
		orderService.deleteChoice();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/kiosk/home");
		return mav;
	}
}