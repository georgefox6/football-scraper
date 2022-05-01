import Models.SimilarPlayers;

import javax.persistence.EntityManager;
import java.util.Optional;

public class SimilarPlayersRepository {
    private final EntityManager entityManager;
    public SimilarPlayersRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<SimilarPlayers> save(SimilarPlayers similarPlayers) {
        if(similarPlayers.getPlayerId().getId() == 0){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(similarPlayers);
                entityManager.getTransaction().commit();
                return Optional.of(similarPlayers);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(similarPlayers);
                entityManager.getTransaction().commit();
                return Optional.of(similarPlayers);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void remove(SimilarPlayers similarPlayers){
        entityManager.getTransaction().begin();
        entityManager.remove(similarPlayers);
        entityManager.getTransaction().commit();
    }
}
