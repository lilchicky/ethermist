package com.gmail.thelilchicken01.ethermist.item.wands;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;

public class DullWand extends WandItem {

    public DullWand() {
        super(new Item.Properties().durability(400), SoundEvents.SHULKER_SHOOT);
    }

    @Override
    public int getLifespanSeconds() {
        return 1;
    }

    @Override
    public float getInaccuracy() {
        return 0.5f;
    }

}
