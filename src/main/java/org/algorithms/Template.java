package org.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Template {

}

//region Test
class TemplateTest{
    private Template template = new Template();

    public static void main(String[] args){
        TemplateTest test = new TemplateTest();
        test.test1();
    }

    private void test1(){
        template.toString();
    }
}
//endregion
