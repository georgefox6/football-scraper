import Models.PlayerDefendingPercentile;
import Models.PlayerPossessionPercentile;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class PlayerPossessionPercentileRepository {
    private final EntityManager entityManager;
    public PlayerPossessionPercentileRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<PlayerPossessionPercentile> findById(Integer id) {
        PlayerPossessionPercentile playerPossessionPercentile = entityManager.find(PlayerPossessionPercentile.class, id);
        return playerPossessionPercentile != null ? Optional.of(playerPossessionPercentile) : Optional.empty();
    }

    public List<PlayerPossessionPercentile> findAll() {
        return entityManager.createQuery("from PlayerPossessionPercentile player_possession_percentile", PlayerPossessionPercentile.class).getResultList();
    }

//    public Optional<PlayerPossessionPercentile> findByPlayerId(int playerId) {
//        var ppp = entityManager.createNativeQuery("SELECT * FROM player_possession_percentile player_possession_percentile where player_possession_percentile.playerId = ?1", PlayerPossessionPercentile.class).setParameter(1, playerId).getResultList();
//        var p = (PlayerPossessionPercentile)ppp.get(0);
//        return p != null ? Optional.of((PlayerPossessionPercentile)p) : Optional.empty();
//    }

    public PlayerPossessionPercentile findByPlayerId(int playerId) {
        var ppp = entityManager.createNativeQuery("SELECT * FROM player_possession_percentile player_possession_percentile where player_possession_percentile.playerId = ?1", PlayerPossessionPercentile.class).setParameter(1, playerId).getResultList();
        return (PlayerPossessionPercentile)ppp.get(0);
    }

    public Optional<PlayerPossessionPercentile> save(PlayerPossessionPercentile playerPossessionPercentile) {
        if(playerPossessionPercentile.getId() == 0){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(playerPossessionPercentile);
                entityManager.getTransaction().commit();
                return Optional.of(playerPossessionPercentile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(playerPossessionPercentile);
                entityManager.getTransaction().commit();
                return Optional.of(playerPossessionPercentile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void remove(PlayerPossessionPercentile playerPossessionPercentile){
        entityManager.getTransaction().begin();
        entityManager.remove(playerPossessionPercentile);
        entityManager.getTransaction().commit();
    }
}
