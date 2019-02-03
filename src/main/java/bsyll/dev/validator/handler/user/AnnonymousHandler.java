package bsyll.dev.validator.handler.user;

import bsyll.dev.validator.AbstractHandler;
import bsyll.dev.validator.domain.Empowerment;
import lombok.extern.slf4j.Slf4j;
import bsyll.dev.validator.domain.User;

@Slf4j
public class AnnonymousHandler extends AbstractHandler<User> {

    @Override
    public boolean processToImpl(User user) {
        if(Empowerment.ANNONYMOUS.equals(user.getEmpowerment())){
            Empowerment.ANNONYMOUS.execute(user.getValueToExecute());
            return true;
        }
        log.warn("{} cannot process input", this.getClass().getSimpleName());

        return false;
    }
}