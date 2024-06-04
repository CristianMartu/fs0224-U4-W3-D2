package cristianmartucci.dao;

import cristianmartucci.entities.Event;
import cristianmartucci.exceptions.EventException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventDAO {
    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("L'evento: '" + event + "' è stato salvato correttamente");
    }

    public Event getById(long eventId) {
        Event event = em.find(Event.class, eventId);
        if (event == null) throw new EventException(eventId);
        return event;
    }

    public void delete(long eventId) {
        Event event = this.getById(eventId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(event);
        transaction.commit();
        System.out.println("L'evento: '" + event + "' è stato eliminato correttamente");
    }
}
