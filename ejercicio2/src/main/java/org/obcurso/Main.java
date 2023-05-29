package org.obcurso;

import org.obcurso.clases.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService service = context.getBean(UserService.class);

        System.out.println("Enviando saludos desde múltiples beans: \n" + service.getNotificacionServicio().imprimirSaludo());
    }
}