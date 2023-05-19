package org.algorithms.interview.epam;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.stream.Collectors.reducing;

@Getter
@Setter
class Product {
    private String category;
    private Integer price;
}

@Getter
@Setter
class GreatestProduct {
    private String category;
    private Integer price;
}

class Solution{
    private GreatestProduct findGreatestProductOf(List<Product> products, String category){
        return  products.stream()
                .filter(product -> product.getCategory().equals(category))
                .map(convertToGreatestProduct)
                .collect(reducing(maxProduct)).get();
    }

    private Function<Product, GreatestProduct> convertToGreatestProduct = product -> {
        GreatestProduct greatestProduct = new GreatestProduct();
        greatestProduct.setCategory(product.getCategory());
        greatestProduct.setPrice(product.getPrice());

        return greatestProduct;
    };

    private BinaryOperator<GreatestProduct> maxProduct = (GP1, GP2) -> (GP1.getPrice() > GP2.getPrice()) ? GP1 : GP2;
}

//region Test
class TemplateTest{
    private Solution template = new Solution();

    public static void main(String[] args){
        TemplateTest test = new TemplateTest();
        test.test1();
    }

    private void test1(){
        template.toString();
    }
}
//endregion
