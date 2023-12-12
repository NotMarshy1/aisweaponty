package com.thatoneaiguy.guns.init;

import com.thatoneaiguy.guns.statuseffect.Berserk;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GunsStatusEffects {
    public static final StatusEffect BERSERK = registerStatusEffect("berserk", new Berserk(StatusEffectCategory.NEUTRAL, 0x8A0303).addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 6.0, EntityAttributeModifier.Operation.ADDITION));

    public static <T extends StatusEffect> T registerStatusEffect(String name, T effect) {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(Aisguns.MOD_ID, name), effect);
        return effect;
    }

    public static void registerStatusEffect() {
        Aisguns.LOGGER.debug("Clear the area!");
    }
}
