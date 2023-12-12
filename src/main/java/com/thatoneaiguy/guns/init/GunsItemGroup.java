package com.thatoneaiguy.guns.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class GunsItemGroup {
    public static final ItemGroup AISGUNS = FabricItemGroupBuilder.build(
            new Identifier(Aisguns.MOD_ID, "aisguns"), () -> new ItemStack(GunsItems.KARAMBIT));
}
