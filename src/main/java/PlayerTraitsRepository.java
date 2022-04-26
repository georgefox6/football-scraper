import Models.PlayerTraits;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PlayerTraitsRepository {
    private final EntityManager entityManager;
    public PlayerTraitsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<PlayerTraits> findById(Integer id) {
        PlayerTraits playerTraits = entityManager.find(PlayerTraits.class, id);
        return playerTraits != null ? Optional.of(playerTraits) : Optional.empty();
    }

    public List<PlayerTraits> findAll() {
        return entityManager.createQuery("from playerTraits player_traits", PlayerTraits.class).getResultList();
    }

    public Optional<PlayerTraits> save(PlayerTraits playerTraits) {
        if(playerTraits.getId() == 0){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(playerTraits);
                entityManager.getTransaction().commit();
                return Optional.of(playerTraits);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(playerTraits);
                entityManager.getTransaction().commit();
                return Optional.of(playerTraits);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void remove(PlayerTraits playerTraits){
        entityManager.getTransaction().begin();
        entityManager.remove(playerTraits);
        entityManager.getTransaction().commit();
    }
}
