package com.thatoneaiguy.guns.client;

import com.thatoneaiguy.guns.init.Aisguns;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AisGunsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Aisguns.ThrowingKarabitEntityType, ThrowingKarambitRenderer::new);
    }
}
