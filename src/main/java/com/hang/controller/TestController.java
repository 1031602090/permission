package com.hang.controller;

import com.hang.common.JsonData;
import com.hang.exception.PermissionException;
import com.hang.model.User;
import com.hang.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hang
 */
@RestController
@Slf4j
public class TestController {
    @GetMapping("/hello.json")
    public JsonData test(){
        throw new PermissionException("asd");
    }

	@RequestMapping("/user.json")
	public JsonData user(User user){
		BeanValidator.check(user);
        return JsonData.success("User");
	}
}
