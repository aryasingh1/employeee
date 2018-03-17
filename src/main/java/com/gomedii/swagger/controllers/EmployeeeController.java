package com.gomedii.swagger.controllers;

import com.gomedii.swagger.domain.Employeee;
import com.gomedii.swagger.services.EmployeeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeee")
@Api(value="office", description="Operations pertaining to employee in office")
public class EmployeeeController {

    private EmployeeeService employeeeService;

    @Autowired
    public void setEmployeeeService(EmployeeeService employeeeService) {
        this.employeeeService = employeeeService;
    }

    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Employeee> list(Model model){
        Iterable<Employeee> employeeeList = employeeeService.listAllEmployeee();
        return employeeeList;
    }
    @ApiOperation(value = "Search a employeee with an ID",response = Employeee.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Employeee showEmployeee(@PathVariable Integer id, Model model){
    	Employeee employeee = employeeeService.getEmployeeeById(id);
        return employeee;
    }

    @ApiOperation(value = "Add a employeee")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveEmployeee(@RequestBody Employeee employeee){
    	employeeeService.saveEmployeee(employeee);
        return new ResponseEntity("employeee saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a employeee")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateEmployeee(@PathVariable Integer id, @RequestBody Employeee employeee){
    	Employeee storedEmployeee = employeeeService.getEmployeeeById(id);
        storedEmployeee.setDescription(employeee.getDescription());
        storedEmployeee.setImageUrl(employeee.getImageUrl());
        storedEmployeee.setSalary(employeee.getSalary());
        employeeeService.saveEmployeee(storedEmployeee);
        return new ResponseEntity("employeee updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a employeee")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id){
        employeeeService.deleteEmployeee(id);
        return new ResponseEntity("employeee deleted successfully", HttpStatus.OK);

    }

}
