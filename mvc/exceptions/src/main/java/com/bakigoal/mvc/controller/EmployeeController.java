package com.bakigoal.mvc.controller;

import com.bakigoal.mvc.exceptions.EmployeeNotFoundException;
import com.bakigoal.mvc.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String getEmployee(@PathVariable("id") int id, Model model) throws Exception {
        switch (id) {
            case 1:
                throw new EmployeeNotFoundException(id);
            case 2:
                throw new SQLException("SQLException, id=" + id);
            case 3:
                throw new IOException("IOException, id=" + id);
            case 10:
                Employee emp = new Employee();
                emp.setName("Bakigoal");
                emp.setId(id);
                model.addAttribute("employee", emp);
                return "home";
            default:
                throw new Exception("Generic Exception, id=" + id);
        }
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {
        System.err.println("Requested URL=" + request.getRequestURL());
        System.err.println("Exception Raised=" + ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }

}
