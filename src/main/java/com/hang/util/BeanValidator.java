package com.hang.util;

import com.google.common.collect.Maps;
import com.hang.exception.ParamException;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.*;

public class BeanValidator {
	private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

	private static <T> Map<String, Object> validate(T t, Class... groups) {
		Set<ConstraintViolation<T>> errors = validatorFactory.getValidator().validate(t, groups);
		LinkedHashMap<String, Object> validateResult = Maps.newLinkedHashMap();
		if (!CollectionUtils.isEmpty(errors)) {
			errors.forEach(error -> validateResult.put(error.getPropertyPath().toString(), error.getMessage()));
		}
		return validateResult;
	}

/*	public static <T> Map<String, Object> validateList(Collection<T> collection) {
		Map<String, Object> result = Maps.newLinkedHashMap();
		for(T t:collection){
			result = validate(t);
			if(!result.isEmpty()){
				return result;
			}
		}
		return result;
	}*/

	/*public static Map<String, String> validateObject(Object first, Object... objects) {

		return null;
	}*/
	public static void check(Object param) {
		Map<String,Object> rs = validate(param);
		if(!CollectionUtils.isEmpty(rs)){
			throw new ParamException(rs.toString());
		}
	}

}