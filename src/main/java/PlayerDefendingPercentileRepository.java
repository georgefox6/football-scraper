import Models.PlayerDefendingPercentile;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PlayerDefendingPercentileRepository {
    private final EntityManager entityManager;
    public PlayerDefendingPercentileRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<PlayerDefendingPercentile> findById(Integer id) {
        PlayerDefendingPercentile playerDefendingPercentile = entityManager.find(PlayerDefendingPercentile.class, id);
        return playerDefendingPercentile != null ? Optional.of(playerDefendingPercentile) : Optional.empty();
    }

    public List<PlayerDefendingPercentile> findAll() {
        return entityManager.createQuery("from PlayerDefendingPercentile player_defending_percentile", PlayerDefendingPercentile.class).getResultList();
    }

//    public Optional<PlayerDefendingPercentile> findByPlayerId(int playerId) {
//        var pdp = entityManager.createNativeQuery("SELECT * FROM player_defending_percentile player_defending_percentile where player_defending_percentile.playerId = ?1", PlayerDefendingPercentile.class).setParameter(1, playerId).getResultList();
//        var p = (PlayerDefendingPercentile)pdp.get(0);
//        return p != null ? Optional.of((PlayerDefendingPercentile)p) : Optional.empty();
//    }

    public PlayerDefendingPercentile findByPlayerId(int playerId) {
        var pdp = entityManager.createNativeQuery("SELECT * FROM player_defending_percentile player_defending_percentile where player_defending_percentile.playerId = ?1", PlayerDefendingPercentile.class).setParameter(1, playerId).getResultList();
        return (PlayerDefendingPercentile)pdp.get(0);
    }

    public Optional<PlayerDefendingPercentile> save(PlayerDefendingPercentile playerDefendingPercentile) {
        if(playerDefendingPercentile.getId() == 0){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(playerDefendingPercentile);
                entityManager.getTransaction().commit();
                return Optional.of(playerDefendingPercentile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(playerDefendingPercentile);
                entityManager.getTransaction().commit();
                return Optional.of(playerDefendingPercentile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void remove(PlayerDefendingPercentile playerDefendingPercentile){
        entityManager.getTransaction().begin();
        entityManager.remove(playerDefendingPercentile);
        entityManager.getTransaction().commit();
    }
}
