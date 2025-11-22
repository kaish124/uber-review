package com.kaish.uber.uberReview.domain.embeddable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Name {
    private String firstName;
    private String lastName;
    private String preferredName;
}
