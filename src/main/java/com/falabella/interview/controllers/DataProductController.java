package com.falabella.interview.controllers;

import com.falabella.interview.products.Product;
import com.falabella.interview.response.Response;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Jorge Godoy (JG)
 */
@RestController
@Slf4j
public class DataProductController {

    @Autowired
    private Response response;

    private List<Product> products;

    @PostMapping(value = "/getProduct", consumes = "application/json")
    public ResponseEntity<Object> getProduct(@RequestBody String request) {
        log.info("request:"+request);
        getProducts().add(new Gson().fromJson(request,Product.class));
        response.setValue(new Gson().toJson(products));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private List<Product> getProducts(){
        if(products == null){
            products = new ArrayList<>();
        }
        return products;
    }

}
