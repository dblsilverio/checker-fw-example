package net.diogosilverio.checker.nullcheck;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashMap;
import java.util.Map;

public class NullChecker {

    private Map<Long, Parameter> successMap;
    private Map<Long, @Nullable Parameter> errorMap;

    public NullChecker() {
        this.successMap = new HashMap<>();
        this.errorMap = new HashMap<>();
    }

    public void start(final Parameter param) {

        Parameter processedParameter = processParameter(param);

        if (processedParameter != null) {
            System.out.println("Parameter is good");
            this.successMap.put(System.currentTimeMillis(), processedParameter);
        } else {
            this.errorMap.put(System.currentTimeMillis(), processedParameter);
            throw new IllegalArgumentException("Bad parameter!");
        }
    }

    public void finish() {
        this.successMap.clear();
    }

    private @Nullable Parameter processParameter(Parameter parameter) {
        Boolean condition = Boolean.FALSE;
        // Business rules & etc

        if (condition) {
            return new Parameter();
        }

        return null;
    }

}

class Parameter {

}