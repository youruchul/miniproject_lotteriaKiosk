package com.lotteria.kiosk.service;

import java.util.List;

import com.lotteria.kiosk.dto.BurgerDTO;
import com.lotteria.kiosk.dto.ChoiceDTO;
import com.lotteria.kiosk.dto.CouponDTO;
import com.lotteria.kiosk.dto.DrinkDTO;
import com.lotteria.kiosk.dto.FoodDTO;
import com.lotteria.kiosk.dto.OrdersDTO;
import com.lotteria.kiosk.dto.RecipeDTO;
import com.lotteria.kiosk.dto.SideDTO;

public interface OrderService {
	List<BurgerDTO> findAllBurgerList();
	BurgerDTO findOneById(Integer burgerId);
	List<DrinkDTO> findAllDrinkList();
	List<SideDTO> findAllSideList();
	Integer choiceFood(ChoiceDTO dto);
	List<ChoiceDTO> findAllChoiceList();
	CouponDTO findOneByCode(String code);
	Integer deleteChoice();
	OrdersDTO findLastOrderNumber();
	Integer insertOrder(OrdersDTO dto);
	List<FoodDTO> findAllFoodList();
	Integer updateFoodCount(FoodDTO dto);
	List<RecipeDTO> findListByitemId(Integer itemId);
}
