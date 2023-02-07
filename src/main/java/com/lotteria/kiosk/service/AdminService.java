package com.lotteria.kiosk.service;

import com.lotteria.kiosk.dto.AdminDTO;
import com.lotteria.kiosk.dto.BurgerDTO;
import com.lotteria.kiosk.dto.DrinkDTO;
import com.lotteria.kiosk.dto.FoodDTO;
import com.lotteria.kiosk.dto.RecipeDTO;
import com.lotteria.kiosk.dto.SideDTO;

public interface AdminService {
	Integer singup(AdminDTO dto);
	AdminDTO login(AdminDTO dto);
	Integer addBurger(BurgerDTO dto);
	Integer deleteBurger(Integer id);
	Integer updateBurger(BurgerDTO dto);
	BurgerDTO findOneBurger(Integer id);
	Integer addDrink(DrinkDTO dto);
	Integer addSide(SideDTO dto);
	Integer deleteDrink(Integer id);
	Integer deleteSide(Integer id);
	Integer updateDrink(DrinkDTO dto);
	Integer updateSide(SideDTO dto);
	DrinkDTO findOneDrink(Integer id);
	SideDTO findOneSide(Integer id);
	Integer addFood(FoodDTO dto);
	Integer updateFood(FoodDTO dto);
	Integer addRecipe(RecipeDTO dto);
	FoodDTO findOneFood(Integer id);
}
