package com.teko.commercial.validator;



import com.teko.commercial.Entities.User;
import com.teko.commercial.services.UserDetailsServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator  {

	@Autowired
	private UserDetailsServiceImp userService;
	

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 3 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.user.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.user.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 3 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.user.password");
        }
        
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");
        }
        
    }
    

    public String validateForProfileUpdate(Object o) {
        User user = (User) o;
        String errors = "";
        if (user.getUsername().length() < 3 || user.getUsername().length() > 32) {
            errors += "Size must larger than 3 and smaller than 32 - ";
        }
        
        if (user.getClassNumber().length() > 15 || user.getClassNumber().length() <= 0) {
            errors += "Please Enter a Valid Class - ";
        }
        
        User us = userService.findByUsername(user.getUsername());
        if (us != null && us.getId() != user.getId()) {
            errors += "Username is already taken - ";
        }

        if (user.getPassword().length() < 3 || user.getPassword().length() > 32) {
            errors += "Password Should be larger than 3 and smaller than 32 - ";
        }
        
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors += "Passwords Does not match ! - ";
        }
        return errors;
    }
    
}






/*
 * 
 * package com.teko7.validator;



import com.teko7.config.Config;
import com.teko7.entities.User;
import com.teko7.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator  {

	private Service getService() {return new Service();}
	private Config getConfig() {return new Config();}
	
	private Config config = getConfig();
    private Service service = getService();

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", config.getSizeUserUsername());
        }
        if (service.getByUsername("user",user.getUsername()) != null) {
            errors.rejectValue("username", config.getDuplicateUserUsername());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", config.getSizeUserPassword());
            
        }
        

    }
    
}

 * 
 */

