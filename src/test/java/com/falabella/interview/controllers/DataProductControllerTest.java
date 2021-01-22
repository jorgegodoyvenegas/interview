package com.falabella.interview.controllers;

import com.falabella.interview.products.Product;
import com.falabella.interview.response.Response;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author: Jorge Godoy (JG)
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataProductController.class, Response.class})
@WebMvcTest
@AutoConfigureMockMvc
@Slf4j
public class DataProductControllerTest {

    @Autowired
    DataProductController dataProductController;

    @Autowired
    private MockMvc mockMvc;

    String request = "";

    @Before
    public void setUp(){
        request = new Gson().toJson(getZapatilla());
    }

    @Test
    public void getProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/getProduct")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    public Product getZapatilla(){
        Product zapatilla = new Product();
        zapatilla.setSku("8406270");
        zapatilla.setName("500 Zapatilla Urbana Mujer");
        zapatilla.setBrand("NEW BALANCE");
        zapatilla.setSize(37);
        zapatilla.setPrice(42990L);
        zapatilla.setImageUrl("https://falabella.scene7.com/is/image/Falabella/8406270_1");
        return zapatilla;

    }


}