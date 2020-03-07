package co.grandcircus.RecipeApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return new ModelAndView("home");
	}

	@RequestMapping("/search")
	public ModelAndView showHome(@RequestParam(value = "label", required = false) String label,
			@RequestParam(value = "url", required = false) String url,
			@RequestParam(value = "theUrl", required = false) String theUrl,
			@RequestParam(value = "food", required = false) String food,
			@RequestParam(value = "diet", required = false) List<String> diet,
			@RequestParam(value = "mincal", required = false) Integer min,
			@RequestParam(value = "maxcal", required = false) Integer max) {

		ModelAndView mav = new ModelAndView("request");
		RecipeResponse res = null;

		if (!theUrl.isBlank()) {
			Favorite fav = new Favorite();
			fav.setLabel(label);
			fav.setUrl(url);

			favRepo.save(fav);

			res = apiServ.findRecipeWitUrl(theUrl);
			mav.addObject("theUrl", theUrl);

		} else {
			String otherUrl = null;
			if ((diet == null || diet.isEmpty()) && (min == null || max == null)) {
				res = apiServ.findRecipe(food);
				otherUrl = apiServ.findUrl(food);
			} else if (min == null || max == null) {
				res = apiServ.findRecipe(food, diet);
				otherUrl = apiServ.findUrl(food, diet);
			} else if (diet == null || diet.isEmpty()) {
				res = apiServ.findRecipe(food, min, max);
				otherUrl = apiServ.findUrl(food, min, max);
			} else {
				res = apiServ.findRecipe(food, diet, min, max);
				otherUrl = apiServ.findUrl(food, diet, min, max);
				
			}
			mav.addObject("theUrl", otherUrl);
		}

		mav.addObject("recipes", res.getHits());
		mav.addObject("q", res.getQ());

		return mav;

	}

	@RequestMapping("/one-recipe")
	public ModelAndView showOne(@RequestParam("ingre") List<String> ingre) {

		ModelAndView mav = new ModelAndView("recipe-detail");

		mav.addObject("ones", ingre);
		return mav;
	}

	@RequestMapping("/favorite-list")
	public ModelAndView showFavorite() {
		
		List<Favorite> fav = favRepo.findAll();
		
		return new ModelAndView("favorite-list", "favorites", fav);
	}
	
	@RequestMapping("/favorite/remove")
	public ModelAndView showRemove(@RequestParam("id") Long id) {
		favRepo.deleteById(id);
		return new ModelAndView("redirect:/favorite-list");
	}

}
