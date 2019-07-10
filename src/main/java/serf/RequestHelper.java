package serf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.UserWebService;

public class RequestHelper {

	public static void Process(HttpServletRequest request, HttpServletResponse response) {
			
			String uri = request.getRequestURI();
			
			switch(uri) {
			
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
			}
	}
}
