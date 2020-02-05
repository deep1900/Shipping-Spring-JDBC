package com.northwind.shipping.controller;

import com.northwind.shipping.model.PackingSlip;
import com.northwind.shipping.repository.RepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class IRestController {

   private RepositoryImpl repository;

    public IRestController(RepositoryImpl repository) {
        this.repository = repository;
    }


    @GetMapping("/123")
    public String test(){
        return "Hello";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PackingSlip>> getAllShippingDetails() throws SQLException {
            List<PackingSlip> list = repository.getPackingSlipDetails();
            return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/getbyId/{id}")
    public ResponseEntity<PackingSlip> getById(@PathVariable long id) throws SQLException {
        PackingSlip ps = repository.getPackingSlipById(id);
        return new ResponseEntity<>(ps, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePackingDetails(@PathVariable long id) throws SQLException {
        String s = repository.deletePackingSlipDetails(id);
        ResponseEntity<String> response = null;
        if(s=="404") response =  new ResponseEntity<>("DATA NOT FOUND", HttpStatus.NOT_FOUND);
        if(s=="200")
            return response =  new ResponseEntity<>("DATA IS DELETED" + id + ".", HttpStatus.OK);
        if (s=="500")
            response =  new ResponseEntity<>("SQL Error",HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
