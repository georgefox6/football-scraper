import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import Models.Player;

public class PlayerRepository {
    private final EntityManager entityManager;
    public PlayerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Player> findById(Integer id) {
        Player player = entityManager.find(Player.class, id);
        return player != null ? Optional.of(player) : Optional.empty();
    }

    public List<Player> findAll() {
        return entityManager.createQuery("from Player Player", Player.class).getResultList();
    }

    public Optional<Player> findByName(String name) {
        try{
            Player player = (Player)entityManager.createNativeQuery("SELECT * FROM players players where players.playerName = ?1 collate utf8mb4_0900_ai_ci", Player.class)
                .setParameter(1, name)
                .getSingleResult();
            return player != null ? Optional.of(player) : Optional.empty();
        } catch (Exception e){
            return Optional.empty();
        }
    }

    public Optional<Player> save(Player player) {
        if(player.getId() == 0){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(player);
                entityManager.getTransaction().commit();
                return Optional.of(player);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(player);
                entityManager.getTransaction().commit();
                return Optional.of(player);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void remove(Player player){
        entityManager.getTransaction().begin();
        entityManager.remove(player);
        entityManager.getTransaction().commit();
    }
}
