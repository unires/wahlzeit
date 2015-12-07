
package org.wahlzeit.utils;

public @interface Pattern {
	
	String name();
	String[] participants() default { };
	
}

/*
 * example:
 * 
@Pattern (
	name = "Abstract Factory",
	participants = {
		"AbstractProduct",
		"ConcreteProduct"
	}
)
*/
