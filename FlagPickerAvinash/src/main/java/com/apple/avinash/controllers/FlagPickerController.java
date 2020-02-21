package com.apple.avinash.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apple.avinash.beans.Continent;
import com.apple.avinash.service.FlagPickerService;

import io.swagger.annotations.*;

@RestController
@RequestMapping("/api/flagpicker/v1")
public class FlagPickerController {
	
	private static final Logger logger = LoggerFactory.getLogger(FlagPickerController.class);
	
	@Autowired
	FlagPickerService flagPickerService;
     
    @GetMapping(path="/flags", produces = "application/json")
    @ApiOperation(value = "Get Flag", response = List.class, httpMethod = "GET")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Get Flag", response = List.class)})
    public  List<Continent> getContinents(@RequestParam(required = false) String continentName,
    		@RequestParam(required = false) String countryName) throws Exception 
    {
		logger.info("START: FlagPickerController::getContinents");

        List<Continent> continents =null;

        continents = flagPickerService.getContinentResponseAll(continentName,countryName);
		logger.info("END: FlagPickerController::getContinents");

        return continents;
    }
     
}
