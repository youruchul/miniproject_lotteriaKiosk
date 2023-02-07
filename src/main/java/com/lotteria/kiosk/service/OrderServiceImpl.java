package com.lotteria.kiosk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotteria.kiosk.dto.BurgerDTO;
import com.lotteria.kiosk.dto.ChoiceDTO;
import com.lotteria.kiosk.dto.CouponDTO;
import com.lotteria.kiosk.dto.DrinkDTO;
import com.lotteria.kiosk.dto.FoodDTO;
import com.lotteria.kiosk.dto.OrdersDTO;
import com.lotteria.kiosk.dto.RecipeDTO;
import com.lotteria.kiosk.dto.SideDTO;
import com.lotteria.kiosk.repository.BurgerRepository;
import com.lotteria.kiosk.repository.ChoiceRepository;
import com.lotteria.kiosk.repository.CouponRepository;
import com.lotteria.kiosk.repository.DrinkRepository;
import com.lotteria.kiosk.repository.FoodRepository;
import com.lotteria.kiosk.repository.OrdersRepository;
import com.lotteria.kiosk.repository.RecipeRepository;
import com.lotteria.kiosk.repository.SideRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private BurgerRepository burgerRepository;
	@Autowired
	private DrinkRepository drinkRepository;
	@Autowired
	private SideRepository sideRepository;
	@Autowired
	private ChoiceRepository choiceRepository;
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private FoodRepository foodRepository;
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Override
	public List<BurgerDTO> findAllBurgerList() {
		return burgerRepository.findAllBurgerList();
	}

	@Override
	public BurgerDTO findOneById(Integer burgerId) {
		return burgerRepository.findOneById(burgerId);
	}

	@Override
	public List<DrinkDTO> findAllDrinkList() {
		return drinkRepository.findAllDrinkList(); 
	}

	@Override
	public List<SideDTO> findAllSideList() {
		return sideRepository.findAllSideList();
	}

	@Override
	public Integer choiceFood(ChoiceDTO dto) {
		return choiceRepository.choiceFood(dto);
	}

	@Override
	public List<ChoiceDTO> findAllChoiceList() {
		return choiceRepository.findAllChoiceList();
	}

	@Override
	public CouponDTO findOneByCode(String code) {
		return couponRepository.findOneByCode(code);
	}

	@Override
	public Integer deleteChoice() {
		return choiceRepository.deleteChoice();
	}

	@Override
	public OrdersDTO findLastOrderNumber() {
		return ordersRepository.findLastOrderNumber();
	}

	@Override
	public Integer insertOrder(OrdersDTO dto) {
		return ordersRepository.insertOrder(dto);
	}
	
	@Override
	public List<FoodDTO> findAllFoodList() {
		return foodRepository.findAllFoodList();
	}
	@Override
	public Integer updateFoodCount(FoodDTO dto) {
		return foodRepository.updateFoodCount(dto);
	}

	@Override
	public List<RecipeDTO> findListByitemId(Integer itemId) {
		return recipeRepository.findListByitemId(itemId);
	}
}
