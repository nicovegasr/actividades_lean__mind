package org.example;

import com.spencerwi.either.Either;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


public class CreateFeatureTest {
    /**
     * Usecases:
     * 1.- create_feature(TEST, BABY_STEP, REFACTOR) -> should return a 0
     * 2.- create_feature(BABY_STEP, TEST, REFACTOR) -> should return a FeatureError.MAKING_CODE_FIRST
     * 3.- create_feature(REFACTOR, BABY_STEP, TEST) -> should return a FeatureError.NONSENSE_REFACTOR
     * 4.-  create_feature(TEST, REFACTOR, BABY_STEP) -> should return a FeatureError.NONSENSE_REFACTOR
     */

    /**
     *  GIVEN
     *
     *  WHEN
     *
     *  THEN
     */
    @Test
    public void should_create_my_feature_with_tdd() {
        CreateFeature feature = new CreateFeature();
        Either<FeatureError, Integer> response = feature.start(Actions.TEST, Actions.BABY_STEP, Actions.REFACTOR);
        assertEquals(response.getRight().intValue(), 0);
    }
}