package com.thatoneaiguy.guns.items;

import com.thatoneaiguy.guns.entity.ThrowingKarambit;
import com.thatoneaiguy.guns.init.GunsStatusEffects;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Karambit extends SwordItem {

    public Karambit(FabricItemSettings settings) {
        super(ToolMaterials.NETHERITE, 2, -2.2F, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (Screen.hasShiftDown()) {
            user.getItemCooldownManager().set(this, 500);
            user.addStatusEffect(new StatusEffectInstance(GunsStatusEffects.BERSERK, 300, 0));
        }

        Vec3d vec3d = user.getRotationVec(1.0F);
        double x = user.getX() + vec3d.x;
        double y = user.getEyeY() + vec3d.y;
        double z = user.getZ() + vec3d.z;

        if (!world.isClient) {
            user.getItemCooldownManager().set(this, 100);
            ThrowingKarambit throwingKarambit = new ThrowingKarambit(world, user, x - user.getX(), y - user.getEyeY(), z - user.getZ());
            throwingKarambit.setPosition(x, y, z);
            world.spawnEntity(throwingKarambit);
        }

        return TypedActionResult.success(itemStack, world.isClient);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Item Ability: No Pain No Gain (SHIFT + RIGHT CLICK)").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Deals slow damage but you do more damage").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.literal("for 30 seconds with a two minute cooldown").formatted(Formatting.DARK_GRAY));
            tooltip.add(Text.literal("").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Item Ability: THROWING_KARAMBIT (RIGHT CLICK)").formatted(Formatting.GRAY));
            tooltip.add(Text.literal("Throws your karambit").formatted(Formatting.DARK_GRAY));
        } else {
            tooltip.add(Text.literal("Press [Sneak] to show abilities").formatted(Formatting.DARK_GRAY));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
