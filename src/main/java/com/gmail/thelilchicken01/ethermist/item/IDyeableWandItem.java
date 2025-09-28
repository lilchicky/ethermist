package com.gmail.thelilchicken01.ethermist.item;

import com.gmail.thelilchicken01.ethermist.util.EMRegistries;
import com.gmail.thelilchicken01.ethermist.component.EMDataComponents;
import com.gmail.thelilchicken01.ethermist.component.WandHandleEntry;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.EMWandHandles;
import com.gmail.thelilchicken01.ethermist.item.wands.wand_handle_effects.WandHandle;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public interface IDyeableWandItem {

    default WandHandle getHandle(ItemStack stack) {
        WandHandleEntry entry = stack.get(EMDataComponents.WAND_HANDLE.get());
        if (entry == null) return EMWandHandles.WOODEN.get();

        String id = entry.handle();

        ResourceLocation location = ResourceLocation.tryParse(id);
        if (location == null) return EMWandHandles.WOODEN.get();

        Registry<WandHandle> registry = EMRegistries.WAND_HANDLES.getRegistry().get();
        WandHandle handle = registry.get(location);
        return handle != null ? handle : EMWandHandles.WOODEN.get();
    }

}
