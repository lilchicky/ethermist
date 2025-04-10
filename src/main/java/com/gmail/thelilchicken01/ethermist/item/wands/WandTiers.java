package com.gmail.thelilchicken01.ethermist.item.wands;

public enum WandTiers {

    WOODEN(
            "wooden",
            1,
            1,
            0,
            0,
            0
    ),
    IRON(
            "iron",
            2.1,
            1,
            0.5,
            40,
            5
    ),
    GOLDEN(
            "golden",
            0.4,
            2,
            4,
            0,
            0
    ),
    DIAMOND(
            "diamond",
            3.4,
            1.5,
            -2,
            -20,
            -5
    ),
    NETHERITE(
            "netherite",
            4.4,
            1,
            2,
            0,
            0
    );

    private final String description;
    private final double durabilityMult;
    private final double enchantabilityMult;
    private final double bonusWandDamage;
    private final int bonusCooldown;
    private final double bonusAccuracy;

    WandTiers(String description, double durabilityMult, double enchantabilityMult, double bonusWandDamage, int bonusCooldown, double bonusAccuracy) {

        this.description = description;
        this.durabilityMult = durabilityMult;
        this.enchantabilityMult = enchantabilityMult;
        this.bonusWandDamage = bonusWandDamage;
        this.bonusCooldown = bonusCooldown;
        this.bonusAccuracy = bonusAccuracy;

    }

    public String getDescription() {
        return description;
    }

    public double getTierDurabilityMult() {
        return durabilityMult;
    }

    public double getTierEnchantabilityMult() {
        return enchantabilityMult;
    }

    public double getBonusWandDamage() {
        return bonusWandDamage;
    }

    public int getBonusCooldownTicks() {
        return bonusCooldown;
    }

    public double getBonusAccuracy() {
        return bonusAccuracy;
    }

}
