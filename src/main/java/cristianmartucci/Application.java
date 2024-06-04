package cristianmartucci;

import cristianmartucci.dao.EventDAO;
import cristianmartucci.entities.Event;
import cristianmartucci.entities.EventType;
import cristianmartucci.exceptions.EventException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);

        LocalDate date = LocalDate.of(2024, 5, 7);
        Event event = new Event("Eurovision Song Contest 2024", date, "L'Eurovision Song Contest 2024 è stata la 68ª edizione dell'annuale concorso canoro, vinta dal cantante svizzero Nemo con la canzone The Code.", EventType.PRIVATO, 13700);
        LocalDate date2 = LocalDate.of(2024, 2, 6);
        Event event2 = new Event("Festival di Sanremo 2024", date2, "Il settantaquattresimo Festival di Sanremo si è svolto al Teatro Ariston di Sanremo. L'edizione è stata vinta da Angelina Mango con il brano La noia.", EventType.PRIVATO, 3000);
        LocalDate date3 = LocalDate.of(2024, 2, 18);
        Event event3 = new Event("Karetera", date3, "Evento pubblico", EventType.PUBBLICO, 2000);
        LocalDate date4 = LocalDate.of(2024, 6, 6);
        Event event4 = new Event("Run 5.30", date3, "Evento pubblico", EventType.PUBBLICO, 3000);

//        Faker faker = new Faker();
//        faker.chuckNorris().fact();

//        ed.save(event);
//        ed.save(event2);
//        ed.save(event3);
//        ed.save(event4);

        try {
            Event eventType = ed.getById(2);
            System.out.println(eventType);
        } catch (EventException error) {
            System.out.println(error.getMessage());
        }

        try {
            ed.delete(1);
        } catch (EventException error) {
            System.out.println(error.getMessage());
        }

        em.close();
        emf.close();
    }
}
