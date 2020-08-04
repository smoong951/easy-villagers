package de.maxhenkel.easyvillagers.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import de.maxhenkel.corelib.inventory.ScreenBase;
import de.maxhenkel.easyvillagers.Main;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ITextProperties;

public abstract class InputOutputScreen<T extends Container> extends ScreenBase<T> {

    public static final ResourceLocation DEFAULT_IMAGE = new ResourceLocation(Main.MODID, "textures/gui/container/breeder.png");

    private PlayerInventory playerInventory;

    public InputOutputScreen(T container, PlayerInventory playerInventory, ITextComponent name) {
        super(DEFAULT_IMAGE, container, playerInventory, name);
        this.playerInventory = playerInventory;
        xSize = 176;
        ySize = 164;
    }

    @Override
    protected void func_230451_b_(MatrixStack matrixStack, int mouseX, int mouseY) {
        drawCentered(matrixStack, getTopText(), 9, FONT_COLOR);
        drawCentered(matrixStack, getBottomText(), 40, FONT_COLOR);
        field_230712_o_.func_238422_b_(matrixStack, playerInventory.getDisplayName(), 8F, (float) (ySize - 96 + 3), FONT_COLOR);
    }

    protected void drawCentered(MatrixStack matrixStack, ITextProperties text, int y, int color) {
        int width = field_230712_o_.getStringWidth(text.getString());
        field_230712_o_.func_238422_b_(matrixStack, text, xSize / 2F - width / 2F, y, color);
    }

    protected abstract ITextProperties getTopText();

    protected abstract ITextProperties getBottomText();

}