package net.thevaliantsquidward.rainbowreef.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


import java.util.Random;

public class BoxfishBreadItem extends Item {

    public BoxfishBreadItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        super.finishUsingItem(stack, world, entity);


        if (entity instanceof Player) {
            Player player = (Player) entity;


            Random random = new Random();

if (random.nextInt(100) == 0) {
        if (!world.isClientSide) {
            player.setHealth(0);
        }
 }

        }

        return stack;
    }
}