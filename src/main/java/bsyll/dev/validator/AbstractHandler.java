package bsyll.dev.validator;

import lombok.Data;

import java.util.Objects;

/**
 * @author bsyll
 */
@Data
public abstract class AbstractHandler<T> {

    private AbstractHandler<T> next;

    boolean process(T value){
        return processToImpl(value) || hasNext() && next.process(value);
    }

    private boolean hasNext(){
        return Objects.nonNull(this.next);
    }

    public abstract boolean processToImpl(T value);

}