package bsyll.dev.validator.domain;

import lombok.Builder;
import lombok.Value;

/**
 * @author bsyll
 */
@Value
@Builder()
public class User<T> {
    private Identity identity;
    private Empowerment empowerment ;
    private T valueToExecute;
}
