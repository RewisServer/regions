package dev.volix.lib.regions;

/**
 * @author Tobias Büser
 */
public enum RegionPriority {

    HIGHEST(0),
    VERY_HIGH(1),
    HIGH(2),
    HIGH_MEDIUM(3),
    MEDIUM(4),
    LOW_MEDIUM(5),
    LOW(6),
    VERY_LOW(7),
    LOWEST(8);

    private int val;

    RegionPriority(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

}
