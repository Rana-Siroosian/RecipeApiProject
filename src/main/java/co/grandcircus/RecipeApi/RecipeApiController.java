package co.grandcircus.RecipeApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.RecipeApi.Entity.Favorite;
import co.grandcircus.RecipeApi.Entity.Hit;
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

//		System.out.println(theUrl.isEmpty());
//		System.out.println(theUrl);    //first search: blank    favorite: string   back: string
//		System.out.println(label);     //first search: null     favorite: string   back: null
//		System.out.println(url);       //first search: null     favorite: string   back: null
		

		// Adding a Favorite
		if (!theUrl.isBlank() && label != null && url != null) {
			Favorite fav = new Favorite();
			fav.setLabel(label);
			fav.setUrl(url);

			favRepo.save(fav);

			res = apiServ.findRecipeWitUrl(theUrl);
			mav.addObject("theUrl", theUrl);

			// Going back
		} else if (!theUrl.isBlank() && label == null && url == null) {
			res = apiServ.findRecipeWitUrl(theUrl);
			mav.addObject("theUrl", theUrl);

			// First search
		} else {
			
			String otherUrl = null;
			
			// Only query
			
			if (diet == null  && min == null && max == null) {
				
				res = apiServ.findRecipe(food);
				otherUrl = apiServ.findUrl(food);
				
			// Query and Diet	
				
			} else if (diet != null && min == null && max == null) {
				
				res = apiServ.findRecipe(food, diet);
				otherUrl = apiServ.findUrl(food, diet);
				
				
			// Query and Calories	
			} else if (diet == null && (min!=null || max!=null)) {

				res = apiServ.findRecipe(food, min, max);
				
				System.out.println(res);
				
				otherUrl = apiServ.findUrl(food, min, max);
				
				
			// Query and Diet and Calories	
			} else {

				if (food==null) {
					food = "chicken";
				}
				res = apiServ.findRecipe(food, diet, min, max);
				otherUrl = apiServ.findUrl(food, diet, min, max);

			}
			mav.addObject("theUrl", otherUrl);
		}
		
		List<Favorite> fav = favRepo.findAll();
		List<String> favorited = new ArrayList<>();
		for (Favorite f : fav) {
			favorited.add(null);
		}
		
		for (Hit h : res.getHits()) {
			
			for (Favorite f : fav) {	
				
			if (h.getRecipe().getLabel().equals(f.getLabel())) {
				
				int index = res.getHits().indexOf(h);
				
				favorited.add(index, "Favorited");
				break;
			}
		}	
		}
		
		mav.addObject("favorited", favorited);
		mav.addObject("recipes", res.getHits());
		mav.addObject("q", res.getQ());

		return mav;

	}

	@RequestMapping("/one-recipe")
	public ModelAndView showOne(@RequestParam("ingre") List<String> ingre, @RequestParam("theUrl") String theUrl) {

		ModelAndView mav = new ModelAndView("recipe-detail");

		mav.addObject("ones", ingre);
		mav.addObject("theUrl", theUrl);
		return mav;
	}

	@RequestMapping("/favorite-list")
	public ModelAndView showFavorite(@RequestParam("theUrl") String theUrl,
			@RequestParam(value = "id", required = false) Long id) {

		if (id != null) {
			favRepo.deleteById(id);
		}

		List<Favorite> fav = favRepo.findAll();

		ModelAndView mav = new ModelAndView("favorite-list");
		mav.addObject("favorites", fav);
		mav.addObject("theUrl", theUrl);
		return mav;

	}

}
