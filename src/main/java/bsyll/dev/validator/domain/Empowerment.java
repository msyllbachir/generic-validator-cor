package bsyll.dev.validator.domain;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bsyll
 */
@Slf4j
public enum Empowerment {

    ANONYMOUS() {
        @Override
        public void execute(Object value) {
            log.info("process value {} for {} user ...", value.toString(), ANONYMOUS.name());
        }
    },
    USER_LEVEL1() {
        @Override
        public void execute(Object value) {
            log.info("process value {} for user {}", value.toString(), USER_LEVEL1.name());
        }
    },
    USER_LEVEL2() {
        @Override
        public void execute(Object value) {
            log.info("process value {} for user {}", value.toString(), USER_LEVEL2.name());
        }
    },
    ROOT() {
        @Override
        public void execute(Object value) {
            log.info("process value {} for user {}", value.toString(), ROOT.name());
        }
    };


    public abstract <T> void execute(T value);

}
