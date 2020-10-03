package com.murad.events.event.listener;

import com.murad.events.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationEventListener {

    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("EventListener -> " + reservationCreatedEvent.getSource().toString());
    }
}
