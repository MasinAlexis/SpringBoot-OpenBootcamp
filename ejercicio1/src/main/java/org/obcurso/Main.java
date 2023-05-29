package org.obcurso;

import org.obcurso.clases.Saludo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Saludo saludo = context.getBean(Saludo.class);

        System.out.println("Imprimiendo saludo desde Bean.xml: \n" + saludo.imprimirSaludo());
    }
}