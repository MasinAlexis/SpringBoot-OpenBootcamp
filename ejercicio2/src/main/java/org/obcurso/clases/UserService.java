package org.obcurso.clases;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    NotificationService notificacionServicio;

    public NotificationService getNotificacionServicio() {
        return notificacionServicio;
    }

    public UserService(NotificationService notificacionServicio){
        System.out.println("Ejecutando constructor de UserService");
        this.notificacionServicio=notificacionServicio;
    }
}
