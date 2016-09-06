package com.jack.design_pattern.filter;

public interface Condition<T> {
	boolean test(T t);
}
