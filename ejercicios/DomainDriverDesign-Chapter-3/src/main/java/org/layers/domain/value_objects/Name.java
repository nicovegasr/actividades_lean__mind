package org.layers.domain.value_objects;


import io.vavr.control.Either;
import org.layers.domain.warnings.NameWarning;

public class Name {
    private final String name;
    private Name(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static Either<NameWarning, Name> createName(String name) {
        if (name.isEmpty()) {
            return Either.left(NameWarning.NAME_CANNOT_BE_EMPTY);
        }
        return Either.right(new Name(name));
    }
}
