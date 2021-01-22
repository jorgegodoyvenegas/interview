package com.falabella.interview.products;

import lombok.Data;

/**
 * @author: Jorge Godoy (JG)
 */
@Data
public class Product {
    String sku;
    String name;
    String brand;
    Integer size;
    Long price;
    String imageUrl;
}
