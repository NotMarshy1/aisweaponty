package com.thatoneaiguy.guns.init;

import net.minecraft.entity.damage.DamageSource;

public class GunsDamageSource extends DamageSource {
    public static final DamageSource BERSERK = new GunsDamageSource("berserk").setBypassesArmor().setUnblockable();

    protected GunsDamageSource(String name) {
        super(name);
    }
}

