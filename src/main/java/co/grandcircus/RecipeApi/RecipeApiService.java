package co.grandcircus.RecipeApi;

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
	
	public RecipeResponse findRecipe(String food ) {
		
		String id ="8ad75853";
		String key = "63b976796710fec2131492b3d8e4f9a3";
		String url = "https://api.edamam.com/search?app_id="+id+"&app_key="+key+"&q="+food;
		
		RecipeResponse response = rt.getForObject(url, RecipeResponse.class);
		return response;
	
	}
}
