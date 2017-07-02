package Interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import enums.ByTypes;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface myTestParams {

	ByTypes testCaseId()

	default ByTypes.id;

	int testTimeOut()

	default 600;

	String[] browsers() default { "chrome" };

	String browser() default "";

	String url() default "";
}
