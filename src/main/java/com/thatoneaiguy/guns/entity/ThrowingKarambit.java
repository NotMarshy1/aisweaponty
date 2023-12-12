package com.thatoneaiguy.guns.entity;

import com.thatoneaiguy.guns.init.Aisguns;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ThrowingKarambit extends PersistentProjectileEntity {
    public ThrowingKarambit(EntityType<? extends ThrowingKarambit> entityType, World world) {
        super(entityType, world);
        this.setSound(this.getHitSound());
        this.setDamage(512);
        this.pickupType = PickupPermission.DISALLOWED;


    }

    public ThrowingKarambit(World world, PlayerEntity user, double v, double v1, double v2) {
        super(Aisguns.ThrowingKarabitEntityType, v, v1, v2, world);
        this.addVelocity(v * 3, v1 * 3, v2 * 3);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.AIR);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.world.isClient && !this.inGround) {
            this.world.addParticle(ParticleTypes.ASH, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }
        if (this.inGround) {
            for (int i = 0; i < 8; ++i) {
                this.kill();
            }
        }
        if (this.age > 50) {
            for (int i = 0; i < 8; ++i) {
                this.kill();
            }
        }
    }
}
