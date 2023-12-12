package com.thatoneaiguy.guns.client;

import com.thatoneaiguy.guns.entity.ThrowingKarambit;
import com.thatoneaiguy.guns.init.Aisguns;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class ThrowingKarambitRenderer extends ProjectileEntityRenderer<ThrowingKarambit> {
    public static final Identifier TEXTURE = new Identifier(Aisguns.MOD_ID, "textures/item/karambit.png");

    public ThrowingKarambitRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(ThrowingKarambit entity) {
        return TEXTURE;
    }
}

