package org.example;

import com.spencerwi.either.Either;

public class CreateFeature {
    public CreateFeature() {}

    public Either<FeatureError, Integer> start(Actions firstAction, Actions secondAction, Actions thirdAction) {
        Either<FeatureError, Integer> response = Either.right(0);
        return response;
    }
}
