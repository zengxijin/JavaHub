package com.jack.design.pattern.filter;

public interface Condition<T> {
	boolean test(T t);
}
