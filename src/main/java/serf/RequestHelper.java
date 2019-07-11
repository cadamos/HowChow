package serf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.DishWebService;

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
		case "/HowChow/updateRequest.do": {
			break;
		}
		case "/HowChow/getUserRequests.do": {
			break;
		}
		case "/HowChow/getApprovedRequests.do": {
			break;
		}
		case "/HowChow/getCourse.do": {
			break;
		}
		case "/HowChow/addCourse.do": {
			break;
		}
		case "/HowChow/getDepHeadId.do": {
			break;
		}
		}
	}
}
