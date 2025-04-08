package com.gmail.thelilchicken01.ethermist.item.wands;

public enum WandTiers {

    WOOD(
            1,
            1,
            0
    ),
    IRON(
            2.1,
            1,
            1
    ),
    GOLDEN(
            0.4,
            2,
            4
    ),
    DIAMOND(
            3.4,
            1.1,
            2
    ),
    NETHERITE(
            4.4,
            1,
            3
    );

    private final double durabilityMult;
    private final double enchantabilityMult;
    private final double bonusWandDamage;

    WandTiers(double durabilityMult, double enchantabilityMult, double bonusWandDamage) {

        this.durabilityMult = durabilityMult;
        this.enchantabilityMult = enchantabilityMult;
        this.bonusWandDamage = bonusWandDamage;

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

}
