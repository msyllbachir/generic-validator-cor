package bsyll.dev.validator.utils;

import java.util.stream.Stream;

/**
 * @author bsyll
 */
@FunctionalInterface
public interface TryExecute {

    void execute();

    static void combine(TryExecute... tryExecutes){
        Stream.of(tryExecutes).forEach(TryExecute::execute);
    }
}