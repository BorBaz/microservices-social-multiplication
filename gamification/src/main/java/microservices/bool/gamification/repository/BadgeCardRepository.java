package microservices.bool.gamification.repository;

import microservices.bool.gamification.domain.BadgeCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BadgeCardRepository extends CrudRepository<BadgeCard, Long> {

    List<BadgeCard> findByUserIDOrderByBagdeTimestampDesc(final Long userId);
}
