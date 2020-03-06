package co.grandcircus.RecipeApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.RecipeApi.Entity.Favorite;
import co.grandcircus.RecipeApi.Entity.RecipeResponse;
import co.grandcircus.RecipeApi.Repo.FavoriteRepo;

@Controller
public class RecipeApiController {
	
	@Autowired
	private FavoriteRepo favRepo;
	
	@Autowired
	private RecipeApiService apiServ;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView ("home");
	}
	
	@RequestMapping("/search")
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
	public ModelAndView showOne(@RequestParam("ingre") List<String> ingre) {
	
		ModelAndView mav = new ModelAndView("recipe-detail");
//		RecipeResponse recipe = apiServ.
		mav.addObject("ones", ingre);
		return mav;
	}
	
	@RequestMapping("/favorite")
	public ModelAndView showFavorite(@RequestParam ("label") String label, @RequestParam("url") String url) {
		
		Favorite fav = new Favorite();
		fav.setLabel(label);
		fav.setUrl(url);
		
		favRepo.save(fav);
		return new ModelAndView ("redirect:/");
	}
}
