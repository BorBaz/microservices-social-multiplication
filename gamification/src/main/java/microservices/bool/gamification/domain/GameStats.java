package microservices.bool.gamification.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class GameStats {

    private final Long userId;
    private final int score;
    private final List<Badge> badges;

    // Empty constructor for JSON / JPA
    public GameStats() {
        this.userId = 0L;
        this.score = 0;
        this.badges = new ArrayList<>();
    }

    /**
     * Factory method to build an empty instance (zero points
     * and no badges)
     *
     * @param userId the user's id
     * @return a {@link GameStats} object with zero score and
     * no badges
     * Chapter 4 Starting with Microservices
     * 140
     */
    public static GameStats emptyStats(final Long userId) {
        return new GameStats(userId, 0, Collections.emptyList());
    }

    /**
     * @return an unmodifiable view of the badge cards list
     */
    public List<Badge> getBadges() {
        return Collections.unmodifiableList(badges);
    }
}
