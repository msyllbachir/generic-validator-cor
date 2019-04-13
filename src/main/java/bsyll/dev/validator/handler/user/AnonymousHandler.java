package bsyll.dev.validator.handler.user;

import bsyll.dev.validator.AbstractHandler;
import bsyll.dev.validator.domain.Empowerment;
import lombok.extern.slf4j.Slf4j;
import bsyll.dev.validator.domain.User;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnonymousHandler extends AbstractHandler<User> {

    @Override
    public boolean processToImpl(User user) {
        if(Empowerment.ANONYMOUS.equals(user.getEmpowerment())){
            Empowerment.ANONYMOUS.execute(user.getValueToExecute());
            return true;
        }
        log.warn("{} cannot process input", this.getClass().getSimpleName());

        return false;
    }
}