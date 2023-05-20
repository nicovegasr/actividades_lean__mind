package org.example;

import io.vavr.control.Either;


public class CreateFeature {
    public CreateFeature() {}

    public Either<FeatureError, Integer> start(Actions firstAction, Actions secondAction, Actions thirdAction) {
        if (validateFirstAction(firstAction) != null) {
            return validateFirstAction(firstAction);
        }
        if (validateSecondAction(secondAction) != null) {
            return validateSecondAction(secondAction);
        }
        return Either.right(0);
    }

    private Either<FeatureError, Integer> validateFirstAction(Actions firstAction) {
        if (firstAction == Actions.BABY_STEP) {
            return Either.left(FeatureError.MAKING_CODE_FIRST);
        } else if (firstAction == Actions.REFACTOR) {
            return Either.left(FeatureError.NONSENSE_REFACTOR);
        }
        return null;
    }
    private Either<FeatureError, Integer> validateSecondAction(Actions secondAction) {
        if (secondAction == Actions.TEST) {
            return Either.left(FeatureError.ALREADY_HAVE_TEST);
        } else if (secondAction == Actions.REFACTOR) {
            return Either.left(FeatureError.NONSENSE_REFACTOR);
        }
        return null;
    }
}
