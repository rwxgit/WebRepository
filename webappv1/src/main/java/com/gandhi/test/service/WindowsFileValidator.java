package com.gandhi.test.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
* to be created in validation package
*
*/

public class WindowsFileValidator implements ConstraintValidator<WindowsFile, String>{

	/* (non-Javadoc)
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
		
	public void initialize(WindowsFile arg0) {
		
	}
	
	public boolean isValid(String fileName, ConstraintValidatorContext constraintContext) {
		// TODO Auto-generated method stub
		boolean result = true;
		
		if(fileName == null) {
			result = false;
			constraintContext.disableDefaultConstraintViolation();
			constraintContext.buildConstraintViolationWithTemplate("{constraints.filename1}").addConstraintViolation();
		}
		
		if(fileName.matches(".*\\.txt")) {// sample testing for not having a text file.
			result = false;
			constraintContext.disableDefaultConstraintViolation();
			constraintContext.buildConstraintViolationWithTemplate("{constraints.filename2}").addConstraintViolation();
		}
		
		return result;
	}
	
}
