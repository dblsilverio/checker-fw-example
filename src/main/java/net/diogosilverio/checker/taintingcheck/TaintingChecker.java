package net.diogosilverio.checker.taintingcheck;

import org.checkerframework.checker.tainting.qual.Tainted;
import org.checkerframework.checker.tainting.qual.Untainted;

public class TaintingChecker {

    public void processData(@Tainted Object data) {
        this.sendUntrustedData(data);

        final Object trustedData = this.sanitizeData(data);
        this.sendTrustedData(trustedData);
    }

    private void sendTrustedData(@Untainted Object data) {
        System.out.println("Sending trusted data: " + data.toString());
    }

    private void sendUntrustedData(Object data) {
        System.out.println("Sending possible untrusted data: " + data.toString());
    }

    @Untainted
    @SuppressWarnings("tainting")
    private Object sanitizeData(Object data) {
        // Data cleansing logic
        if (data != null) {
            return data;
        }

        throw new IllegalArgumentException("Invalid data sent");
    }

}