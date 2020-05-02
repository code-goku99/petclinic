package com.petclinic.exception.global;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ResourcesNotFound {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView resourceNotFoundHandler(Exception exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exceptionMessage", exception.getMessage());
		mav.setViewName("notImplemented");
		return mav;
	}
}
