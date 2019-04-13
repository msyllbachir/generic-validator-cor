package bsyll.dev.validator.handler.user;

import bsyll.dev.validator.AbstractHandler;
import lombok.extern.slf4j.Slf4j;
import bsyll.dev.validator.domain.Empowerment;
import bsyll.dev.validator.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author bsyll
 */
@Slf4j
@Component
public class UserLevelOneHandler extends AbstractHandler<User> {

    @Override
    public boolean processToImpl(User user) {
        if(Empowerment.USER_LEVEL1.equals(user.getEmpowerment())){
            Empowerment.USER_LEVEL1.execute(user.getValueToExecute());
            return true;
        }
        log.warn("{} cannot process input", this.getClass().getSimpleName());

        return false;
    }
}