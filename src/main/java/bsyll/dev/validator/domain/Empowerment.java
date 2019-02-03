package bsyll.dev.validator.domain;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bsyll
 */
@Slf4j
public enum Empowerment {

    ANNONYMOUS("", 1) {
        @Override
        public void execute(Object value) {
            log.info("process value {} for {} user ...", value.toString(), ANNONYMOUS.name());
        }
    },
    USER_L1("", 1) {
        @Override
        public void execute(Object value) {
            log.info("process value {} for {} user ...", value.toString(), USER_L1.name());
        }
    },
    USER_L2("", 1) {
        @Override
        public void execute(Object value) {
            log.info("process value {} for {} user ...", value.toString(), USER_L2.name());
        }
    },
    ROOT("", 1) {
        @Override
        public void execute(Object value) {
            log.info("process value {} for {} user ...", value.toString(), ROOT.name());
        }
    };

    private String desc;
    private int weight;

    Empowerment(String desc, int weight){
        String desc1 = desc;
        this.weight = weight;
    }

    public abstract <T> void execute(T value);

}
