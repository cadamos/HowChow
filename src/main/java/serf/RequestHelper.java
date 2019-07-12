package serf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.DishWebService;
import webservice.ReviewWebService;
import webservice.UserWebService;

public class RequestHelper {

public static void Process(HttpServletRequest request, HttpServletResponse response) {
		
		String uri = request.getRequestURI();
		
		switch(uri) {
			case "/HowChow/selectDishById.do": {
				DishWebService.selectDishById(request, response);
				break;
			}
			case "/HowChow/selectDishesByTag.do": {
				DishWebService.selectDishesByTags(request, response);
				break;
			}
			case "/HowChow/selectAllDishes.do": {
				DishWebService.selectAllDishes(request, response);
				break;
			}
			case "/HowChow/insertDish.do": {
				DishWebService.insertDish(request, response);
				break;
			}
			case "/HowChow/updateDish.do": {
				DishWebService.updateDish(request, response);
				break;
			}
			case "/HowChow/deleteDishById.do": {
				DishWebService.deleteDishById(request, response);
				break;
			}
			case "/HowChow/getUser.do": {
				UserWebService.getUser(request, response);
				break;
			}
			case "/HowChow/registerUser.do": {
				UserWebService.registerUser(request, response);
				break;
			}
			case "/HowChow/loginUser.do": {
				UserWebService.loginUser(request, response);
				break;
			}
			case "/HowChow/addReview.do": {
				ReviewWebService.addReview(request, response);
				break;
			}
			case "/HowChow/upReview.do": {
				ReviewWebService.upReview(request, response);
				break;
			}
			case "/HowChow/downReview.do": {
				ReviewWebService.downReview(request, response);
				break;
			}
			case "/HowChow/deleteReview.do": {
				ReviewWebService.deleteReview(request, response);
				break;
			}
//			case "/HowChow/getTagById.do": {
//				TagWebService.getTagById(request, response);
//				break;
//			}
//			case "/HowChow/getTagByName.do": {
//				TagWebService.getTagByName(request, response);
//				break;
//			}
//			case "/HowChow/deleteTagById.do": {
//				TagWebService.deleteTagById(request, response);
//				break;
//			}
//			case "/HowChow/updateTag.do": {
//				TagWebService.updateTag(request, response);
//				break;
//			}
//			case "/HowChow/insertTag.do": {
//				TagWebService.insertTag(request, response);
//				break;
//			}
		}
	}
}
