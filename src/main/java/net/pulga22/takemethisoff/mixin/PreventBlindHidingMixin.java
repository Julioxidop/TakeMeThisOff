package net.pulga22.takemethisoff.mixin;


import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.pulga22.takemethisoff.util.BlindedState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public abstract class PreventBlindHidingMixin {

    @Shadow @Final private MinecraftClient client;

    //Inject at the tail, normally it cycles hudHidden when pressing f1, this changes that,
    //now if the player have a true blindedState, it's always set to false, so the hud
    //doesn't hide
    @Inject(method = "onKey", at = @At("TAIL"))
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci){
        if (client.player != null && ((BlindedState) client.player).getBlindedState()){
            client.options.hudHidden = false;
        }

    }

}
