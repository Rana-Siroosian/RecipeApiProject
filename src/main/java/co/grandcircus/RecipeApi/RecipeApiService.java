package co.grandcircus.RecipeApi;

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
	
	// Only queries
	public RecipeResponse findRecipe(String food ) {
		
		String id ="8ad75853";
		String key = "63b976796710fec2131492b3d8e4f9a3";
		String url = "https://api.edamam.com/search?app_id="+id+"&app_key="+key+"&q="+food;
		
		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);
		return response;
	
	}
	
	// Queries and diet
	public RecipeResponse findRecipe(String food, List<String> diet) {
		
		String id ="8ad75853";
		String key = "63b976796710fec2131492b3d8e4f9a3";
		String url = "https://api.edamam.com/search?app_id="+id+"&app_key="+key+"&q="+food;
		
		for(int i=0; i< diet.size(); i++) {
			url += "&diet="+diet.get(i);
		}
		
		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);
		System.out.println(response);
		return response;
	}
	
	// Queries, diet and calories
	public RecipeResponse findRecipe(String food, List<String> diet, Double min, Double max) {
		
		String id ="8ad75853";
		String key = "63b976796710fec2131492b3d8e4f9a3";
		String url = "https://api.edamam.com/search?app_id="+id+"&app_key="+key+"&q="+food;
		
		for(int i=0; i< diet.size(); i++) {
			url += "&diet="+diet.get(i);
		}
		
		url += "&calories="+min+"-"+max;
		
		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);
		System.out.println(response);
		return response;
	}
	
	// Queries and calories
	public RecipeResponse findRecipe(String food, Double min, Double max) {
		
		String id ="8ad75853";
		String key = "63b976796710fec2131492b3d8e4f9a3";
		String url = "https://api.edamam.com/search?app_id="+id+"&app_key="+key+"&q="+food;
		
		url += "&calories="+min+"-"+max;
		
		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);
		System.out.println(response);
		return response;
	}
	
	
}

