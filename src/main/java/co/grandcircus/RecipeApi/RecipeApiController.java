package co.grandcircus.RecipeApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.RecipeApi.Entity.Hit;
import co.grandcircus.RecipeApi.Entity.RecipeResponse;

@Controller
public class RecipeApiController {
	
	
	@Autowired
	private RecipeApiService apiServ;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView ("home");
	}
	
	@PostMapping("/")
	public ModelAndView showHome(@RequestParam(value="food") String food,
			@RequestParam(value="diet", required=false) List<String> diet,
			@RequestParam(value="mincal", required=false) Double min,
			@RequestParam(value="maxcal", required=false) Double max ){
		ModelAndView mav = new ModelAndView ("request");
		RecipeResponse res = null;
		if((diet == null || diet.isEmpty()) && (min == null || max == null)) {
			res = apiServ.findRecipe(food);	
		} else if (min == null || max == null){
			res = apiServ.findRecipe(food,diet);	
		} else if (diet == null || diet.isEmpty()){ 
			res = apiServ.findRecipe(food,min, max);
		} else {
			res = apiServ.findRecipe(food, diet, min, max);
		}
		mav.addObject("recipes", res.getHits());

		return mav;
		
	}
}
