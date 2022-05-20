package com.example.springbootapiassignment.controller;

import com.example.springbootapiassignment.entity.Part;
import com.example.springbootapiassignment.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.ParameterizedType;
import java.util.List;

//This is to allow calls from React... NOT IMPORTANT RIGHT NOW
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class PartController {

    private final PartService partService;

    //Constructor Injection: this is telling the spring framework to wire up your
    //dependencies for the partService.
    @Autowired
    public PartController(@Qualifier("partServiceIMPL")PartService partService) {
        this.partService = partService;
    }

    //This is a GET request that will read a list of all the employees.
    //http://localhost:8080/retrieveAllParts
    @GetMapping("/retrieveAllParts")
    public List<Part> findAll() {
        return partService.findAll();
    }

    //MM - This is a GET request that will retrieve a part based on the id.
    //http://localhost:8080/retrievePart/2
    @GetMapping("/retrievePart/{partId}")
    public Object retrievePart(@PathVariable int partId) {
        //This will execute the findByID.
        Object myPart = partService.findById(partId);
        return "The requested part:\n" +myPart; //
    }


    //This is a POST request to add a new employee.
    //http://localhost:8080/addPart
    @PostMapping("/addPart")
    public Part addPart(@RequestBody Part thePart) {
        //also, just in case they pass an id in JSON .... set id to 0
        //this is to force a save of new item .... instead of update
        thePart.setId(0);

        //This will call the partDqoImpl.save method to save a new part
        //through the employeeService
        partService.saveOrUpdate(thePart);
        return thePart;//return thePart makes the added part show in the Postman results window
    }

    //This is a PUT request to update an existing part.
    //http://localhost:8080/updatePart
    @PutMapping("/updatePart")
    public Part updatePart(@RequestBody Part updatePart) {
        //Notice thePart.setId(0); this will execute an update instead of a create
        partService.saveOrUpdate(updatePart);
        return updatePart;
    }

    //This is a DELETE request to delete an existing part.
    //http://localhost:8080/deletePart/1
    @DeleteMapping("/deletePart/{partId}")
    public String deletePart(@PathVariable int partId) {
        //This will execute the deleteByID.
        partService.deleteById(partId);
        return "Deleted part id : " + partId;
    }

}
