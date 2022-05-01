import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import Models.PlayerAttackingPercentile;

public class PlayerAttackingPercentileRepository {
    private final EntityManager entityManager;
    public PlayerAttackingPercentileRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<PlayerAttackingPercentile> findById(Integer id) {
        PlayerAttackingPercentile playerAttackingPercentile = entityManager.find(PlayerAttackingPercentile.class, id);
        return playerAttackingPercentile != null ? Optional.of(playerAttackingPercentile) : Optional.empty();
    }

    public List<PlayerAttackingPercentile> findAll() {
        return entityManager.createQuery("from PlayerAttackingPercentile player_attacking_percentile", PlayerAttackingPercentile.class).getResultList();
    }

//    public Optional<PlayerAttackingPercentile> findByPlayerId(int playerId) {
//        var ppp = entityManager.createNativeQuery("SELECT * FROM player_attacking_percentile player_attacking_percentile where player_attacking_percentile.playerId = ?1", PlayerAttackingPercentile.class).setParameter(1, playerId).getResultList();
//        var p = (PlayerAttackingPercentile)ppp.get(0);
//        return p != null ? Optional.of((PlayerAttackingPercentile)p) : Optional.empty();
//    }
    public PlayerAttackingPercentile findByPlayerId(int playerId) {
        var ppp = entityManager.createNativeQuery("SELECT * FROM player_attacking_percentile player_attacking_percentile where player_attacking_percentile.playerId = ?1", PlayerAttackingPercentile.class).setParameter(1, playerId).getResultList();
        return (PlayerAttackingPercentile)ppp.get(0);
    }

    public Optional<PlayerAttackingPercentile> save(PlayerAttackingPercentile playerAttackingPercentile) {
        if(playerAttackingPercentile.getId() == 0){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(playerAttackingPercentile);
                entityManager.getTransaction().commit();
                return Optional.of(playerAttackingPercentile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(playerAttackingPercentile);
                entityManager.getTransaction().commit();
                return Optional.of(playerAttackingPercentile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void remove(PlayerAttackingPercentile playerAttackingPercentile){
        entityManager.getTransaction().begin();
        entityManager.remove(playerAttackingPercentile);
        entityManager.getTransaction().commit();
    }
}
