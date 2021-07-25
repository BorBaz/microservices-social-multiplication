package microservices.bool.gamification.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class BadgeCard {

    @Id
    @GeneratedValue
    @Column(name = "BADGE_ID")
    private final Long badgeId;

    private final Long userID;
    private final long bagdeTimestamp;
    private final Badge badge;

    public BadgeCard() {
        // Constructor vacío para JSON / JPA
        this(null, null, 0, null);
    }

    public BadgeCard(final Long userID, final Badge badge) {
        this(null, userID, System.currentTimeMillis(), badge);
    }
}