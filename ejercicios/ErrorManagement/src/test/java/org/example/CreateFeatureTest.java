package org.example;

import org.junit.Test;


import io.vavr.control.Either;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CreateFeatureTest {
    /**
     * Use cases:
     * 1.- create_feature(TEST, BABY_STEP, REFACTOR) -> should return a 0
     * 2.- create_feature(BABY_STEP, TEST, REFACTOR) -> should return a FeatureError.MAKING_CODE_FIRST
     * 3.- create_feature(REFACTOR, BABY_STEP, TEST) -> should return a FeatureError.NONSENSE_REFACTOR
     */
    @Test
    public void should_create_my_feature_with_tdd() {
        CreateFeature feature = new CreateFeature();

        Either<FeatureError, Integer> response = feature.start(Actions.TEST, Actions.BABY_STEP, Actions.REFACTOR);

        assertTrue(response.isRight());
    }
    @Test
    public void should_tell_me_to_not_make_code_first_because_first_action_is_incorrect() {
        CreateFeature feature = new CreateFeature();

        Either<FeatureError, Integer> response = feature.start(Actions.BABY_STEP, Actions.TEST, Actions.REFACTOR);

        assertEquals(response.getLeft(), FeatureError.SHOULD_NOT_MAKE_CODE_FIRST);
    }
    @Test
    public void should_tell_me_nonsense_refactor_because_first_action_is_incorrect() {
        CreateFeature feature = new CreateFeature();

        Either<FeatureError, Integer> response = feature.start(Actions.REFACTOR, Actions.TEST, Actions.BABY_STEP);

        assertEquals(response.getLeft(), FeatureError.NONSENSE_REFACTOR);
    }
    @Test
    public void should_tell_me_nonsense_refactor_because_second_action_is_incorrect() {
        CreateFeature feature = new CreateFeature();

        Either<FeatureError, Integer> response = feature.start(Actions.TEST, Actions.REFACTOR, Actions.BABY_STEP);

        assertEquals(response.getLeft(), FeatureError.NONSENSE_REFACTOR);
    }
    @Test
    public void should_tell_me_test_already_created_because_second_action_is_incorrect() {
        CreateFeature feature = new CreateFeature();

        Either<FeatureError, Integer> response = feature.start(Actions.TEST, Actions.TEST, Actions.BABY_STEP);

        assertEquals(response.getLeft(), FeatureError.ALREADY_HAVE_TEST);
    }
    @Test
    public void should_tell_me_test_already_created_because_third_action_is_incorrect() {
        CreateFeature feature = new CreateFeature();

        Either<FeatureError, Integer> response = feature.start(Actions.TEST, Actions.BABY_STEP, Actions.TEST);

        assertEquals(response.getLeft(), FeatureError.ALREADY_HAVE_TEST);
    }
    @Test
    public void should_tell_me_test_code_already_implemented_because_third_action_is_incorrect() {
        CreateFeature feature = new CreateFeature();

        Either<FeatureError, Integer> response = feature.start(Actions.TEST, Actions.BABY_STEP, Actions.BABY_STEP);

        assertEquals(response.getLeft(), FeatureError.CODE_ALREADY_IMPLEMENTED);
    }

}
