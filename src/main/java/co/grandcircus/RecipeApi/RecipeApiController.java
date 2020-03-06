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
			@RequestParam(value="mincal", required=false) Integer min,
			@RequestParam(value="maxcal", required=false) Integer max ){
		ModelAndView mav = new ModelAndView ("request");
		
		RecipeResponse res = null;
		if((diet == null || diet.isEmpty()) && (min == null || max == null)) {
			System.out.println("one");
			res = apiServ.findRecipe(food);	
		} else if (min == null || max == null){
			System.out.println("two");
			res = apiServ.findRecipe(food,diet);	
		} else if (diet == null || diet.isEmpty()){  //problems
			System.out.println("three");
			res = apiServ.findRecipe(food,min, max);
		} else {
			System.out.println("four");
			res = apiServ.findRecipe(food, diet, min, max);
		}
		mav.addObject("recipes", res.getHits());
		mav.addObject("q", res.getQ());

		return mav;
		
	}
	
	@RequestMapping("/recipe-detail")
	public ModelAndView recipeDetail(@RequestParam ("label") String label) {
		RecipeResponse res = apiServ.findRecipe(label);
		return new ModelAndView("recipe-detail", "recipes", res.getHits());
	}
	
	@RequestMapping("/one-recipe")
	public ModelAndView showOne(@RequestParam("one") List<String> one) {
		
		ModelAndView mav = new ModelAndView ("recipe-detail");
//		RecipeResponse recipe = apiServ.
		mav.addObject("ones", one);
		return mav;
	}
}
