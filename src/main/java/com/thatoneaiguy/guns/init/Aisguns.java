package com.thatoneaiguy.guns.init;

import com.thatoneaiguy.guns.entity.ThrowingKarambit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aisguns implements ModInitializer {

	public static final String MOD_ID = "aisguns";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<ThrowingKarambit> ThrowingKarabitEntityType = Registry.register(

			Registry.ENTITY_TYPE,
			new Identifier(MOD_ID, "throwing_karambit_entity"),
			FabricEntityTypeBuilder.<ThrowingKarambit>create(SpawnGroup.MISC, ThrowingKarambit::new)
					.dimensions(EntityDimensions.fixed(0.5F, 0.5F))
					.fireImmune()
					.trackRangeBlocks(4).trackedUpdateRate(10)
					.build());

	@Override
	public void onInitialize() {

		GunsItems.registerModItems();

		GunsStatusEffects.registerStatusEffect();

		LOGGER.info("Let's make this right as rain.");
	}
}