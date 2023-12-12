package com.thatoneaiguy.guns.mixin;

import com.thatoneaiguy.guns.init.GunsDamageSource;
import com.thatoneaiguy.guns.init.GunsStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }
    @Shadow
    @Nullable
    public abstract StatusEffectInstance getStatusEffect(StatusEffect effect);

    @Shadow
    public abstract boolean hasStatusEffect(StatusEffect effect);


    @Inject(method = "tick", at = @At("TAIL"), cancellable = true)
    public void tick(CallbackInfo callbackInfo) {

        if (this.hasStatusEffect(GunsStatusEffects.BERSERK) && (this.age % (20 / (MathHelper.clamp(this.getStatusEffect(GunsStatusEffects.BERSERK).getAmplifier() + 1, 1, 20))) == 0)) {
            this.damage(GunsDamageSource.BERSERK, 1);
            this.timeUntilRegen = 0;
        }
    }
}
