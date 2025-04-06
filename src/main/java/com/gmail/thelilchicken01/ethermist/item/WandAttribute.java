package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.item.wands.WandItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.common.extensions.IAttributeExtension;
import org.jetbrains.annotations.Nullable;

public class WandAttribute extends RangedAttribute implements IAttributeExtension {

    public WandAttribute(String descriptionId, double defaultValue, double min, double max) {
        super(descriptionId, defaultValue, min, max);
    }

    @Override
    public @Nullable ResourceLocation getBaseId() {
        if (this == EMAttributes.COOLDOWN.value()) return WandItem.COOLDOWN_ID;
        else if (this == EMAttributes.WAND_DAMAGE.value()) return WandItem.BASE_WAND_DAMAGE_ID;
        else if (this == EMAttributes.LIFESPAN.value()) return WandItem.LIFESPAN_ID;
        // else if (this == EMAttributes.ACCURACY.value()) return WandItem.ACCURACY_ID;
        // else if (this == EMAttributes.WAND_KNOCKBACK.value()) return WandItem.WAND_KNOCKBACK_ID;
        // else if (this == EMAttributes.PROJECTILE_SPEED.value()) return WandItem.PROJECTILE_SPEED_ID;
        return null;
    }
}
