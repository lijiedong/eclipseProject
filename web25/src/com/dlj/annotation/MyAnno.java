package com.dlj.annotation;

public @interface MyAnno {
	String name();

	int age() default 0;
}
