package bsyll.dev.validator.handler.user;

import bsyll.dev.validator.AbstractHandler;
import bsyll.dev.validator.domain.Empowerment;
import bsyll.dev.validator.domain.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author bsyll
 */
@Slf4j
public class UserLevelTwoHandler extends AbstractHandler<User> {

    @Override
    public boolean processToImpl(User user) {
        if(Empowerment.USER_L2.equals(user.getEmpowerment())){
            Empowerment.USER_L2.execute(user.getValueToExecute());
            return true;
        }
        log.warn("{} cannot process input", this.getClass().getSimpleName());

        return false;
    }
}