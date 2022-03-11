package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String handleException() {
		System.out.println("컨트롤러어드바이스:");
		Exception e = null;
		e.printStackTrace();
		return "error/errorForm";
	}
}
