package com.gmail.thelilchicken01.ethermist.screen;

import com.gmail.thelilchicken01.ethermist.Ethermist;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CyclingSlotBackground;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class WandforgingTableScreen extends ItemCombinerScreen<WandforgingTableMenu> {

    private static final ResourceLocation ERROR_SPRITE = ResourceLocation.withDefaultNamespace("container/smithing/error");

    private static final ResourceLocation EMPTY_SLOT_ORB = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/empty_slot_orb");
    private static final ResourceLocation EMPTY_SLOT_HANDLE = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/empty_slot_handle");
    private static final ResourceLocation EMPTY_SLOT_WAND = ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "item/empty_slot_wand");
    private static final List<ResourceLocation> EMPTY_SLOT_ITEMS = List.of(EMPTY_SLOT_ORB, EMPTY_SLOT_HANDLE, EMPTY_SLOT_WAND);

    private static final Component MISSING_TEMPLATE_TOOLTIP = Component.translatable("container.upgrade.missing_template_tooltip");
    private static final Component ERROR_TOOLTIP = Component.translatable("container.upgrade.error_tooltip");

    private static final int TITLE_LABEL_X = 44;
    private static final int TITLE_LABEL_Y = 15;
    private static final int ERROR_ICON_WIDTH = 28;
    private static final int ERROR_ICON_HEIGHT = 21;
    private static final int ERROR_ICON_X = 65;
    private static final int ERROR_ICON_Y = 46;
    private static final int TOOLTIP_WIDTH = 115;
    private final CyclingSlotBackground input_1 = new CyclingSlotBackground(0);
    private final CyclingSlotBackground input_2 = new CyclingSlotBackground(1);

    public WandforgingTableScreen(WandforgingTableMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, ResourceLocation.fromNamespaceAndPath(Ethermist.MODID, "textures/gui/container/wandforging_table.png"));
        this.titleLabelX = TITLE_LABEL_X;
        this.titleLabelY = TITLE_LABEL_Y;
    }

    @Override
    public void containerTick() {
        super.containerTick();
        this.input_1.tick(EMPTY_SLOT_ITEMS);
        this.input_2.tick(EMPTY_SLOT_ITEMS);
    }

    /**
     * Renders the graphical user interface (GUI) element.
     *
     * @param guiGraphics the GuiGraphics object used for rendering.
     * @param mouseX      the x-coordinate of the mouse cursor.
     * @param mouseY      the y-coordinate of the mouse cursor.
     * @param partialTick the partial tick time.
     */
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderOnboardingTooltips(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        super.renderBg(guiGraphics, partialTick, mouseX, mouseY);
        this.input_1.render(this.menu, guiGraphics, partialTick, this.leftPos, this.topPos);
        this.input_2.render(this.menu, guiGraphics, partialTick, this.leftPos, this.topPos);
    }

    @Override
    protected void renderErrorIcon(GuiGraphics guiGraphics, int x, int y) {
        if (this.hasRecipeError()) {
            guiGraphics.blitSprite(ERROR_SPRITE, x + 65, y + 46, 28, 21);
        }
    }

    private void renderOnboardingTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        Optional<Component> optional = Optional.empty();
        if (this.hasRecipeError() && this.isHovering(65, 46, 28, 21, (double)mouseX, (double)mouseY)) {
            optional = Optional.of(ERROR_TOOLTIP);
        }

        if (this.hoveredSlot != null) {
            ItemStack itemstack = this.menu.getSlot(0).getItem();
            ItemStack itemstack1 = this.hoveredSlot.getItem();
            if (itemstack.isEmpty()) {
                if (this.hoveredSlot.index == 0) {
                    optional = Optional.of(MISSING_TEMPLATE_TOOLTIP);
                }
            } else if (itemstack.getItem() instanceof SmithingTemplateItem smithingtemplateitem && itemstack1.isEmpty()) {
                if (this.hoveredSlot.index == 1) {
                    optional = Optional.of(smithingtemplateitem.getBaseSlotDescription());
                } else if (this.hoveredSlot.index == 2) {
                    optional = Optional.of(smithingtemplateitem.getAdditionSlotDescription());
                }
            }
        }

        optional.ifPresent(p_280863_ -> guiGraphics.renderTooltip(this.font, this.font.split(p_280863_, 115), mouseX, mouseY));
    }

    private boolean hasRecipeError() {
        return this.menu.getSlot(0).hasItem()
                && this.menu.getSlot(1).hasItem()
                && this.menu.getSlot(2).hasItem()
                && !this.menu.getSlot(this.menu.getResultSlot()).hasItem();
    }
}
