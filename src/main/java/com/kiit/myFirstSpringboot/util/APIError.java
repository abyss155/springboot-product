package com.kiit.myFirstSpringboot.util;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class APIError {

	private String message;
	private String field;
	private Object rejectedValue;
}
