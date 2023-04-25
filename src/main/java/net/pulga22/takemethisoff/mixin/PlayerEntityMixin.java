package net.pulga22.takemethisoff.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.pulga22.takemethisoff.util.BlindedState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements BlindedState {

    //Mixin to add blindedState var to the ClientPlayerEntity

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    private boolean blindedState = false;

    @Override
    public void setBlindedState(boolean newState){
        this.blindedState = newState;
    }

    @Override
    public boolean getBlindedState(){
        return this.blindedState;
    }

}
