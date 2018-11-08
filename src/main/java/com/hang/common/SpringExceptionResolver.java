package com.hang.common;

import com.hang.exception.ParamException;
import com.hang.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hang
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {

    private final static String JSON_SUF = ".json";

    private final static String PAGE_SUF = ".page";

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        ModelAndView modelAndView = null;
        String defaultMsg = "System error";
        if(url.endsWith(JSON_SUF)){
            if(ex instanceof PermissionException || ex instanceof ParamException){
                JsonData jsonData = JsonData.fail(ex.getMessage());
                modelAndView = new ModelAndView("jsonView",jsonData.toMap());
            }else {
	            log.error("unknown json exception,url:{},ex:{}",url,ex.getStackTrace());
            }
        }else if(url.endsWith(PAGE_SUF)) {
            JsonData jsonData = JsonData.fail(defaultMsg);
            modelAndView = new ModelAndView("exception",jsonData.toMap());
        }else {
	        log.error("unknown page exception,url:{},ex:{}",url,ex.getStackTrace());
	        JsonData jsonData = JsonData.fail(ex.getMessage());
	        modelAndView = new ModelAndView("jsonView",jsonData.toMap());
        }
        return modelAndView;
    }
}
