import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import Models.PlayerAttackingPercentile;

public class PlayerAttackingPercentileRepository {
    private final EntityManager entityManager;
    public PlayerAttackingPercentileRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<PlayerAttackingPercentile> findById(Integer id) {
        PlayerAttackingPercentile playerPercentile = entityManager.find(PlayerAttackingPercentile.class, id);
        return playerPercentile != null ? Optional.of(playerPercentile) : Optional.empty();
    }

    public List<PlayerAttackingPercentile> findAll() {
        return entityManager.createQuery("from PlayerPercentile player_percentile", PlayerAttackingPercentile.class).getResultList();
    }

    public Optional<PlayerAttackingPercentile> findByName(String name) {
        try{
            PlayerAttackingPercentile playerPercentile = (PlayerAttackingPercentile)entityManager.createNativeQuery("SELECT * FROM playerPercentile playerPercentile where playerPercentiles.playerPercentileName = ?1 collate utf8mb4_0900_ai_ci", PlayerAttackingPercentile.class)
                    .setParameter(1, name)
                    .getSingleResult();
            return playerPercentile != null ? Optional.of(playerPercentile) : Optional.empty();
        } catch (NoResultException e){
            return Optional.empty();
        }                     
    }

    public Optional<PlayerAttackingPercentile> save(PlayerAttackingPercentile playerPercentile) {
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

    public void remove(PlayerAttackingPercentile playerPercentile){
        entityManager.getTransaction().begin();
        entityManager.remove(playerPercentile);
        entityManager.getTransaction().commit();
    }
}
