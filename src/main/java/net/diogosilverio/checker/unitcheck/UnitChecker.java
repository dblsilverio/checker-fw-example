package net.diogosilverio.checker.unitcheck;

import org.checkerframework.checker.units.UnitsTools;
import org.checkerframework.checker.units.qual.Length;
import org.checkerframework.checker.units.qual.Time;

public class UnitChecker {

    @Time
    private Long timeToLive = 5000L * UnitsTools.s;

    @Time
    private Long extraTime = 1500L * UnitsTools.s;

    @Length
    private Long maxSize = 204800L * UnitsTools.m;

    @Time
    public Long extraTTL() {
        return timeToLive + extraTime;
    }

    @Time
    public Long extraInlineTTLDoesNotWork() {
        return timeToLive + (1000L * UnitsTools.s);
    }

    @Time
    public Long extraLocalTTL() {
        @Time Long extraTimeLocal = 1000L * UnitsTools.s;
        return timeToLive + extraTimeLocal;
    }

    public Long works() {
        return maxSize + extraTime;
    }

    @Length
    public Long doesNotWork() {
        return maxSize + extraTime;
    }

}
