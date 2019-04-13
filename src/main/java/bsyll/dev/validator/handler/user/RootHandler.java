package bsyll.dev.validator.handler.user;

import bsyll.dev.validator.AbstractHandler;
import bsyll.dev.validator.domain.Empowerment;
import bsyll.dev.validator.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author bsyll
 */
@Slf4j
@Component
public class RootHandler extends AbstractHandler<User> {

    @Override
    public boolean processToImpl(User user) {
        if(Empowerment.ROOT.equals(user.getEmpowerment())){
            Empowerment.ROOT.execute(user.getValueToExecute());
            return true;
        }
        log.warn("{} cannot process input", this.getClass().getSimpleName());

        return false;
    }
}