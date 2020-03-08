package co.grandcircus.RecipeApi;

import java.net.URLEncoder;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.RecipeApi.Entity.RecipeResponse;

@Component
public class RecipeApiService {

	private RestTemplate rt;

	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "ooeeee!");
			return execution.execute(request, body);
		};
		rt = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}

	private static String id = "8ad75853";
	private static String key = "63b976796710fec2131492b3d8e4f9a3";

	// Only queries
	public RecipeResponse findRecipe(String food) {

		String url = findUrl(food);

		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);
		return response;

	}

	// Queries and diet
	public RecipeResponse findRecipe(String food, List<String> diet) {

		String url = findUrl(food, diet);

		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);
		return response;
	}

	// Queries, diet and calories
	public RecipeResponse findRecipe(String food, List<String> diet, Integer min, Integer max) {

		String url = findUrl(food, diet, min, max);
		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);  // error or this line of every method if didnt find anything (api's fault)
		return response;
	}

	// Queries and calories
	public RecipeResponse findRecipe(String food, Integer min, Integer max) {

		String url = findUrl(food, min, max);

		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);
		return response;
	}

	public RecipeResponse findRecipe(String food, String label) { // do i need it?

		String url = findUrl(food, label);

		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);
		return response;
	}

	public String findUrl(String food) {

		String url = "https://api.edamam.com/search?app_id=" + id + "&app_key=" + key + "&q=" + food;
		return url;
	}

	public String findUrl(String food, List<String> diet) {

		String url = "https://api.edamam.com/search?app_id=" + id + "&app_key=" + key + "&q=" + food;

		for (int i = 0; i < diet.size(); i++) {
			url += "&diet=" + diet.get(i);
		}
		return url;
	}

	public String findUrl(String food, List<String> diet, Integer min, Integer max) {

		String url = "https://api.edamam.com/search?app_id=" + id + "&app_key=" + key + "&q=" + food;

		for (int i = 0; i < diet.size(); i++) {
			url += "&diet=" + diet.get(i);
		}

		url += "&calories=" + min + "-" + max;
		return url;
	}

	public String findUrl(String food, Integer min, Integer max) {

		String url = "https://api.edamam.com/search?app_id=" + id + "&app_key=" + key + "&q=" + food;

//		if (min == null) {
//			url += "&calories=" + max;
//		} else if (max == null) {
//			url += "&calories=" + URLEncoder.encode(min+"+");
//			//url += "&calories=" + min + "%2B";
//		} else {
			url += "&calories=" + min + "-" + max;
//		}
		return url;
	}

	public String findUrl(String food, String label) {

		String url = "https://api.edamam.com/search?app_id=" + id + "&app_key=" + key + "&q=" + food;

		url += "&label=" + label;

		return url;
	}

	public RecipeResponse findRecipeWitUrl(String theUrl) {
		RecipeResponse response = rt.getForObject(theUrl, RecipeResponse.class);
		return response;
	}

}
