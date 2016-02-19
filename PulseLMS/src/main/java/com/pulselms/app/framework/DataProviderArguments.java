package com.pulselms.app.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
/**
* Annotation for feeding arguments to methods conforming to the
* "@DataProvider" annotation type.
* @author Cognizant
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataProviderArguments
{
  /**
  * Excel work book name
  */
	public String data_Folder() default "";
	
	public String data_File_Name() default "";
	
	public String sheetname() default "";
	
	public String tablename() default "";
}