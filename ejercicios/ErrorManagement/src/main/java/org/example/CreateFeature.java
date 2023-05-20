package org.example;

import com.spencerwi.either.Either;

public class CreateFeature {
    public CreateFeature() {}

    public Either<FeatureError, Integer> start(Actions firstAction, Actions secondAction, Actions thirdAction) {
        if ( validate(firstAction, secondAction, thirdAction) != null) {
            return validate(firstAction, secondAction, thirdAction);
        }
        return Either.right(0);
    }

    private Either<FeatureError, Integer> validate(Actions firstAction, Actions secondAction, Actions thirdAction) {
        if (firstAction == Actions.BABY_STEP) {
            return Either.left(FeatureError.MAKING_CODE_FIRST);
        }
        return null;
    }
}
