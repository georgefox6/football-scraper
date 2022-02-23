import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import Models.PlayerPercentile;

public class PlayerPercentileRepository {
    private final EntityManager entityManager;
    public PlayerPercentileRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<PlayerPercentile> findById(Integer id) {
        PlayerPercentile playerPercentile = entityManager.find(PlayerPercentile.class, id);
        return playerPercentile != null ? Optional.of(playerPercentile) : Optional.empty();
    }

    public List<PlayerPercentile> findAll() {
        return entityManager.createQuery("from PlayerPercentile player_percentile", PlayerPercentile.class).getResultList();
    }

    public Optional<PlayerPercentile> findByName(String name) {
        try{
            PlayerPercentile playerPercentile = (PlayerPercentile)entityManager.createNativeQuery("SELECT * FROM playerPercentile playerPercentile where playerPercentiles.playerPercentileName = ?1 collate utf8mb4_0900_ai_ci", PlayerPercentile.class)
                    .setParameter(1, name)
                    .getSingleResult();
            return playerPercentile != null ? Optional.of(playerPercentile) : Optional.empty();
        } catch (NoResultException e){
            return Optional.empty();
        }                     
    }

    public Optional<PlayerPercentile> save(PlayerPercentile playerPercentile) {
        if(playerPercentile.getId() == 0){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(playerPercentile);
                entityManager.getTransaction().commit();
                return Optional.of(playerPercentile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(playerPercentile);
                entityManager.getTransaction().commit();
                return Optional.of(playerPercentile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void remove(PlayerPercentile playerPercentile){
        entityManager.getTransaction().begin();
        entityManager.remove(playerPercentile);
        entityManager.getTransaction().commit();
    }
}
