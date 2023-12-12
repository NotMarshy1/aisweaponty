package com.thatoneaiguy.guns.init;

import com.thatoneaiguy.guns.items.Karambit;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GunsItems {

    public static final Item KARAMBIT = registerItem("karambit", new Karambit(new FabricItemSettings().fireproof().group(GunsItemGroup.AISGUNS)));

    public static final Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Aisguns.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Aisguns.LOGGER.debug("Contact!");
    }
}
