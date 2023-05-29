package org.obcurso.clases;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public NotificationService(){
        System.out.println("Ejecutando constructor de NotificacionService");
    }

    public String imprimirSaludo(){
        return "Saludos desde Spring-Component para OpenBootcamp";
    }
}
