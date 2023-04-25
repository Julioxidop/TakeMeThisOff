package net.pulga22.takemethisoff.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.pulga22.takemethisoff.TakeMeThisOff;
import net.pulga22.takemethisoff.util.BlindedState;

public class BlindedHud implements HudRenderCallback {
    private static final Identifier TEXTURE = new Identifier(TakeMeThisOff.MOD_ID, "blind.png");

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        int x = client.getWindow().getScaledWidth();
        int y = client.getWindow().getScaledHeight();

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);

        if (player != null){
            if (((BlindedState) player).getBlindedState()){
                DrawableHelper.drawTexture(matrixStack, 0, 0, 0,0,x,y,x,x);
            }
        }
    }
}
