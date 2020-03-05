package co.grandcircus.RecipeApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView showHome(@RequestParam(value="food") String food) {
		
		RecipeResponse res = apiServ.findRecipe(food);
		
		ModelAndView mav = new ModelAndView ("request");
		mav.addObject("recipes", res.getHits());
		return mav;
		
	}
}
