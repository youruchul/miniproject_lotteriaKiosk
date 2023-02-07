package com.lotteria.kiosk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lotteria.kiosk.dto.AdminDTO;
import com.lotteria.kiosk.dto.BurgerDTO;
import com.lotteria.kiosk.dto.DrinkDTO;
import com.lotteria.kiosk.dto.FoodDTO;
import com.lotteria.kiosk.dto.RecipeDTO;
import com.lotteria.kiosk.dto.SideDTO;
import com.lotteria.kiosk.service.AdminServiceImpl;
import com.lotteria.kiosk.service.OrderService;
import com.lotteria.kiosk.service.OrderServiceImpl;

@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminServiceImpl adminService;
	
	@Autowired
	private OrderServiceImpl orderService;
	
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		// TODO : ��ü �������� ��
		List<BurgerDTO> allBurgers = orderService.findAllBurgerList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/home");
		mav.addObject("burgers", allBurgers);
		return mav;
	}
	
//	------------------------ ���� ���� ---------------------------------
	@RequestMapping(value="/admin/login", method = RequestMethod.GET)
	public String getLogin() {
		return "/admin/login";
	}
	@RequestMapping(value="/admin/login", method = RequestMethod.POST)
	public ModelAndView postLogin(
			@ModelAttribute AdminDTO dto,
			HttpServletRequest req
			) {
		ModelAndView mav = new ModelAndView();
		try {
			AdminDTO admin = adminService.login(dto);
			mav.setViewName("redirect:/admin/home");
			HttpSession session = req.getSession();
			session.setAttribute("adminName", admin.getName());
			session.setAttribute("adminId", admin.getAdminId());
		} catch(Exception e) {
			mav.setViewName("redirect:/admin/login");
			mav.addObject("code", e.getMessage());
		}

		return mav;
	}
	
	@RequestMapping(value="/admin/logout", method = RequestMethod.GET)
	public ModelAndView getLogout(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		session.removeAttribute("adminName");
		session.removeAttribute("adminId");
		mav.setViewName("redirect:/admin/home");
		return mav;
	}
	
	@RequestMapping(value="/admin/signup", method = RequestMethod.GET)
	public String getSignup() {
		return "/admin/signup";
	}
	@RequestMapping(value="/admin/signup", method = RequestMethod.POST)
	public ModelAndView postSignup(
			@ModelAttribute AdminDTO dto
			) {
		ModelAndView mav = new ModelAndView();
		try {			
			adminService.singup(dto);
			mav.setViewName("redirect:/admin/login");
			mav.addObject("code", "000002");
		} catch (Exception e) {
			mav.setViewName("redirect:/admin/signup");
			mav.addObject("code", "000001");			
		}
		return mav;
	}
	
//	------------------------ ���� ���� ---------------------------------
	@RequestMapping(value="/admin/addBurger", method = RequestMethod.GET)
	public String getAddBurger() {
		return "/admin/addBurger";
	}
	@RequestMapping(value="/admin/addBurger", method = RequestMethod.POST)
	public ModelAndView postAddBurger(
			@ModelAttribute BurgerDTO dto
			) {
		ModelAndView mav = new ModelAndView();
		try {
			adminService.addBurger(dto);
			mav.setViewName("redirect:/admin/food");
			mav.addObject("code", "000005");
			mav.addObject("burgerId", dto.getId());
		} catch (Exception e) {			
			mav.setViewName("redirect:/admin/addBurger");
			mav.addObject("code", "000004");
		}
		return mav;
	}
	
	@RequestMapping(value="/admin/burgerDetail", method = RequestMethod.GET)
	public ModelAndView burgerDetail(@RequestParam(required = false, value="burgerId") Integer id) {
		BurgerDTO burger = adminService.findOneBurger(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/burgerDetail");
		if(burger.getId()==null) mav.setViewName("redirect:/admin/home");
		mav.addObject("burger", burger);
		return mav;
	}

	@RequestMapping(value="/admin/updateBurger", method = RequestMethod.GET)
	public ModelAndView getUpdateBurger(
			@RequestParam("burgerId") Integer id
			) {
		ModelAndView mav = new ModelAndView();
		BurgerDTO dto = adminService.findOneBurger(id);
		logger.info(dto.toString());
		mav.setViewName("/admin/updateBurger");
		mav.addObject("burger", dto);
		return mav;
	}
	
	@RequestMapping(value="/admin/updateBurger", method = RequestMethod.POST)
	public ModelAndView postUpdateBurger(
			@ModelAttribute BurgerDTO dto
			) {
		ModelAndView mav = new ModelAndView();
		try {
			adminService.updateBurger(dto);
			mav.addObject("code", "000009");
			mav.setViewName("redirect:/admin/burgerDetail");
		} catch (Exception e) {
			mav.addObject("code", "000008");
			mav.setViewName("redirect:/admin/updateBurger");
		}
		mav.addObject("burgerId", dto.getId());
		return mav;
	}
	
	@RequestMapping(value="/admin/deleteBurger", method = RequestMethod.GET)
	public ModelAndView deleteBurger(@RequestParam("burgerId") Integer id) {
		ModelAndView mav = new ModelAndView();
		try {			
			adminService.deleteBurger(id);
			mav.addObject("code", "000007");
		} catch (Exception e) {			
			mav.addObject("code", "000006");
		}
		mav.setViewName("redirect:/admin/home");	
		return mav;
	}
	
//	------------------------ ���̵� ���� ---------------------------------
	@RequestMapping(value = "/admin/side", method = RequestMethod.GET)
	public ModelAndView adminSide() {
		// TODO : ��ü �������� ��
		List<SideDTO> allSides = orderService.findAllSideList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/side");
		mav.addObject("sides", allSides);
		return mav;
	}
	
	@RequestMapping(value="/admin/addSide", method = RequestMethod.GET)
	public String getAddSide() {
		return "/admin/addSide";
	}
	@RequestMapping(value="/admin/addSide", method = RequestMethod.POST)
	public ModelAndView postAddSide(
			@ModelAttribute SideDTO dto
			) {
		ModelAndView mav = new ModelAndView();
		try {
			adminService.addSide(dto);
			mav.setViewName("redirect:/admin/side");
			mav.addObject("code", "000005");
		} catch (Exception e) {			
			mav.setViewName("redirect:/admin/addSide");
			mav.addObject("code", "000004");
		}
		return mav;
	}
	
	@RequestMapping(value="/admin/sideDetail", method = RequestMethod.GET)
	public ModelAndView sideDetail(@RequestParam(required = false, value="sideId") Integer id) {
		SideDTO side = adminService.findOneSide(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/sideDetail");
		if(side.getId()==null) mav.setViewName("redirect:/admin/side");
		mav.addObject("side", side);
		return mav;
	}
	
	@RequestMapping(value="/admin/updateSide", method = RequestMethod.GET)
	public ModelAndView getUpdateSide(
			@RequestParam("sideId") Integer id
			) {
		ModelAndView mav = new ModelAndView();
		SideDTO dto = adminService.findOneSide(id);
		logger.info(dto.toString());
		mav.setViewName("/admin/updateSide");
		mav.addObject("side", dto);
		return mav;
	}
	
	@RequestMapping(value="/admin/updateSide", method = RequestMethod.POST)
	public ModelAndView postUpdateSide(
			@ModelAttribute SideDTO dto
			) {
		ModelAndView mav = new ModelAndView();
		try {
			adminService.updateSide(dto);
			mav.addObject("code", "000009");
			mav.setViewName("redirect:/admin/sideDetail");
		} catch (Exception e) {
			mav.addObject("code", "000008");
			mav.setViewName("redirect:/admin/updateSide");
		}
		mav.addObject("sideId", dto.getId());
		return mav;
	}
	
	@RequestMapping(value="/admin/deleteSide", method = RequestMethod.GET)
	public ModelAndView deleteSide(@RequestParam("sideId") Integer id) {
		ModelAndView mav = new ModelAndView();
		try {			
			adminService.deleteSide(id);
			mav.addObject("code", "000007");
		} catch (Exception e) {			
			mav.addObject("code", "000006");
		}
		mav.setViewName("redirect:/admin/side");	
		return mav;
	}
	
//	------------------------ ���� ���� ---------------------------------
	@RequestMapping(value = "/admin/drink", method = RequestMethod.GET)
	public ModelAndView adminDrink() {
		// TODO : ��ü �������� ��
		List<DrinkDTO> allDrinks = orderService.findAllDrinkList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/drink");
		mav.addObject("drinks", allDrinks);
		return mav;
	}
	
	@RequestMapping(value="/admin/addDrink", method = RequestMethod.GET)
	public String getAddDrink() {
		return "/admin/addDrink";
	}
	@RequestMapping(value="/admin/addDrink", method = RequestMethod.POST)
	public ModelAndView postAddDrink(
			@ModelAttribute DrinkDTO dto
			) {
		ModelAndView mav = new ModelAndView();
		try {
			adminService.addDrink(dto);
			mav.setViewName("redirect:/admin/drink");
			mav.addObject("code", "000005");
		} catch (Exception e) {			
			mav.setViewName("redirect:/admin/addDrink");
			mav.addObject("code", "000004");
		}
		return mav;
	}
	
	@RequestMapping(value="/admin/drinkDetail", method = RequestMethod.GET)
	public ModelAndView drinkDetail(@RequestParam(required = false, value="drinkId") Integer id) {
		DrinkDTO drink = adminService.findOneDrink(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/drinkDetail");
		if(drink.getId()==null) mav.setViewName("redirect:/admin/drink");
		mav.addObject("drink", drink);
		return mav;
	}
	
	@RequestMapping(value="/admin/updateDrink", method = RequestMethod.GET)
	public ModelAndView getUpdateDrink(
			@RequestParam("drinkId") Integer id
			) {
		ModelAndView mav = new ModelAndView();
		DrinkDTO dto = adminService.findOneDrink(id);
		logger.info(dto.toString());
		mav.setViewName("/admin/updateDrink");
		mav.addObject("drink", dto);
		return mav;
	}
	
	@RequestMapping(value="/admin/updateDrink", method = RequestMethod.POST)
	public ModelAndView postUpdateDrink(
			@ModelAttribute DrinkDTO dto
			) {
		ModelAndView mav = new ModelAndView();
		try {
			adminService.updateDrink(dto);
			mav.addObject("code", "000009");
			mav.setViewName("redirect:/admin/drinkDetail");
		} catch (Exception e) {
			mav.addObject("code", "000008");
			mav.setViewName("redirect:/admin/updateDrink");
		}
		mav.addObject("drinkId", dto.getId());
		return mav;
	}
	
	@RequestMapping(value="/admin/deleteDrink", method = RequestMethod.GET)
	public ModelAndView deleteDrink(@RequestParam("drinkId") Integer id) {
		ModelAndView mav = new ModelAndView();
		try {			
			adminService.deleteDrink(id);
			mav.addObject("code", "000007");
		} catch (Exception e) {			
			mav.addObject("code", "000006");
		}
		mav.setViewName("redirect:/admin/drink");	
		return mav;
	}
	
//	-----------------------------���-----------------------------
	@RequestMapping(value = "/admin/food", method = RequestMethod.GET)
	public ModelAndView getFood(
			@RequestParam("burgerId") Integer burgerId
			) {
		// TODO : ��ü �������� ��
		List<FoodDTO> allFoods = orderService.findAllFoodList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/food");
		mav.addObject("foods", allFoods);
		mav.addObject("burgerId", burgerId);
		return mav;
	}
	
	@RequestMapping(value = "/admin/food", method = RequestMethod.POST)
	public ModelAndView postFood(
			@ModelAttribute FoodDTO dto,
			@RequestParam(required = false, value="name") List<String> name,
			@RequestParam(required = false, value="id") List<Integer> id,
			@RequestParam(required = false, value="count") List<Integer> count,
			@RequestParam("burgerId") Integer burgerId
			) {
		// TODO : ��ü �������� ��
		ModelAndView mav = new ModelAndView();
		try {
			for (int i = 0; i < id.size(); i++) {
				RecipeDTO recipeDto = new RecipeDTO(burgerId, id.get(i), name.get(id.get(i)-1), count.get(id.get(i)-1));
				int aa = adminService.addRecipe(recipeDto);
			}			
			mav.addObject("code", "000005");
			mav.setViewName("redirect:/admin/home");
		} catch (Exception e) {
			mav.addObject("code", "000004");
			mav.addObject("burgerId", burgerId);
			mav.setViewName("redirect:/admin/food");
		}
		return mav;
	}
	
	@RequestMapping(value = "/admin/foodList", method = RequestMethod.GET)
	public ModelAndView getFoodList(
			@RequestParam("id") Integer id
			) {
		List<FoodDTO> allFoods = orderService.findAllFoodList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/foodList");
		mav.addObject("foods", allFoods);
		mav.addObject("id", id);
		return mav;
	}

	@RequestMapping(value="/admin/addFood", method = RequestMethod.GET)
	public String getAddFood() {
		return "/admin/addFood";
	}
	@RequestMapping(value="/admin/addFood", method = RequestMethod.POST)
	public ModelAndView postAddFood(
			@ModelAttribute FoodDTO dto,
			@RequestParam("id") Integer id
			) {
		ModelAndView mav = new ModelAndView();
		try {
			adminService.addFood(dto);
			if(id != null) {
				mav.setViewName("redirect:/admin/food");
				mav.addObject("code", "000005");
				mav.addObject("burgerId", id);				
			}else {
				mav.setViewName("redirect:/admin/foodList?id=");
				mav.addObject("code", "000005");
			}
		} catch (Exception e) {			
			mav.setViewName("redirect:/admin/addFood");
			mav.addObject("code", "000004");
		}
		return mav;
	}
	
	@RequestMapping(value="/admin/updateFood", method = RequestMethod.GET)
	public ModelAndView getUpdateFood(
			@RequestParam("foodId") Integer id
			) {
		ModelAndView mav = new ModelAndView();
		FoodDTO food = adminService.findOneFood(id);
		mav.setViewName("/admin/updateFood");
		mav.addObject("food", food);
		return mav;
	}
	
	@RequestMapping(value="/admin/updateFood", method = RequestMethod.POST)
	public ModelAndView postUpdateFood(
			@ModelAttribute FoodDTO dto,
			@RequestParam("pid") Integer pid
			) {
		ModelAndView mav = new ModelAndView();
		try {
			adminService.updateFood(dto);
			if(pid != null) {
				mav.setViewName("redirect:/admin/food");
				mav.addObject("code", "000009");
				mav.addObject("burgerId", pid);				
			}else {
				mav.setViewName("redirect:/admin/foodList?id=");
				mav.addObject("code", "000009");
			}
		} catch (Exception e) {
			mav.setViewName("redirect:/admin/updateFood?id"+pid);
			mav.addObject("code", "000008");
			mav.addObject("burgerId", pid);
		}
		return mav;
	}
	
}
