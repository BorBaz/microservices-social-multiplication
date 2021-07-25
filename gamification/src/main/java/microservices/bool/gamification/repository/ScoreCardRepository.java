package microservices.bool.gamification.repository;

import microservices.bool.gamification.domain.LeaderBoardRow;
import microservices.bool.gamification.domain.ScoreCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreCardRepository extends CrudRepository<ScoreCard, Long> {

    /**
     * Obtiene la puntuación total para un usuario dado
     */

    @Query("SELECT SUM(s.score) FROM ScoreCard s WHERE s.userId = :userId GROUP BY s.userId")
    int getTotalScoreForUser(@Param("userId") final Long userID);

    /**
     * Retrieves a list of {@link LeaderBoardRow}s representing
     * the Leader Board of users and their total score.
     *
     * @return the leader board, sorted by highest score first.
     */
    @Query("SELECT NEW LeaderBoardRow(s.userId, SUM(s.score)) FROM ScoreCard s GROUP BY s.userId ORDER BY SUM(s.score) DESC")
    List<LeaderBoardRow> findFirst10();

    /**
     * Encuentra todas las puntuaciones dado un usuario
     *
     * @param userId
     * @return
     */
    List<LeaderBoardRow> findByUserIdOrderByScoreTimestampScoreDesc(final Long userId);

}


// me quedo pag 153 the bussiness logic