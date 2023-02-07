package com.lotteria.kiosk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lotteria.kiosk.dto.AdminDTO;
import com.lotteria.kiosk.dto.BurgerDTO;
import com.lotteria.kiosk.dto.DrinkDTO;
import com.lotteria.kiosk.dto.FoodDTO;
import com.lotteria.kiosk.dto.RecipeDTO;
import com.lotteria.kiosk.dto.SideDTO;
import com.lotteria.kiosk.repository.AdminRepository;
import com.lotteria.kiosk.repository.BurgerRepository;
import com.lotteria.kiosk.repository.DrinkRepository;
import com.lotteria.kiosk.repository.FoodRepository;
import com.lotteria.kiosk.repository.RecipeRepository;
import com.lotteria.kiosk.repository.SideRepository;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepository repository;
	
	@Autowired
	private BurgerRepository burgerRepo;
	
	@Autowired
	private SideRepository sideRepository;
	
	@Autowired
	private DrinkRepository drinkRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public Integer singup(AdminDTO dto) {
		return repository.signup(dto);
	}

	@Override
	public AdminDTO login(AdminDTO dto) {
		AdminDTO admin = repository.login(dto);
		if(admin==null) {
			throw new NullPointerException("000003");
		}
		return admin;
	}

	@Override
	public Integer addBurger(BurgerDTO dto) {
		return burgerRepo.addBurger(dto);
	}

	@Override
	public Integer deleteBurger(Integer id) {
		return burgerRepo.deleteBurger(id);
	}

	@Override
	public Integer updateBurger(BurgerDTO dto) {
		return burgerRepo.updateBurger(dto);
	}

	@Override
	public BurgerDTO findOneBurger(Integer id) {
		return burgerRepo.findOneBurger(id);
	}
	
	@Override
	public Integer addDrink(DrinkDTO dto) {
		return drinkRepository.addDrink(dto);
	}

	@Override
	public Integer addSide(SideDTO dto) {
		return sideRepository.addSide(dto);
	}

	@Override
	public Integer deleteDrink(Integer id) {
		return drinkRepository.deleteDrink(id);
	}

	@Override
	public Integer deleteSide(Integer id) {
		return sideRepository.deleteSide(id);
	}

	@Override
	public Integer updateDrink(DrinkDTO dto) {
		return drinkRepository.updateDrink(dto);
	}

	@Override
	public Integer updateSide(SideDTO dto) {
		return sideRepository.updateSide(dto);
	}

	@Override
	public DrinkDTO findOneDrink(Integer id) {
		return drinkRepository.findOneDrink(id);
	}

	@Override
	public SideDTO findOneSide(Integer id) {
		return sideRepository.findOneSide(id);
	}

	@Override
	public Integer addFood(FoodDTO dto) {
		return foodRepository.addFood(dto);
	}
	
	@Override
	public Integer updateFood(FoodDTO dto) {
		return foodRepository.updateFood(dto);
	}

	@Override
	public Integer addRecipe(RecipeDTO dto) {
		return recipeRepository.addRecipe(dto);
	}

	@Override
	public FoodDTO findOneFood(Integer id) {
		return foodRepository.findOneFood(id);
	}



}
