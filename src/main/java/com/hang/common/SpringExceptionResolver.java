package com.hang.common;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hang
 */
public class SpringExceptionResolver implements HandlerExceptionResolver {

    private final static String JSON_SUF = ".json";

    private final static String PAGE_SUF = ".page";

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        ModelAndView modelAndView;
        String defaultMsg = "System error";
        if(url.endsWith(JSON_SUF)){
            if(ex instanceof PermissionException){
                JsonData jsonData = JsonData.fail(ex.getMessage());
                modelAndView = new ModelAndView("jsonView",jsonData.toMap());

            }
        }else if(url.endsWith(PAGE_SUF)) {

        }
        return null;
    }
}
