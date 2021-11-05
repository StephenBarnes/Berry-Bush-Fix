package com.stebars.berrybushesdonthurtvillagers.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

@Mixin(SweetBerryBushBlock.class)
public abstract class SweetBerryBushBlockMixin extends BushBlock {

	public SweetBerryBushBlockMixin(Properties p_i48437_1_) {
		super(p_i48437_1_);
	}

	@Shadow public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

	@Overwrite
	public void entityInside(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
		if (p_196262_4_ instanceof LivingEntity
				&& p_196262_4_.getType() != EntityType.FOX
				&& p_196262_4_.getType() != EntityType.BEE
				&& p_196262_4_.getType() != EntityType.VILLAGER) {
			p_196262_4_.makeStuckInBlock(p_196262_1_, new Vector3d((double)0.8F, 0.75D, (double)0.8F));
			if (!p_196262_2_.isClientSide && p_196262_1_.getValue(AGE) > 0 && (p_196262_4_.xOld != p_196262_4_.getX() || p_196262_4_.zOld != p_196262_4_.getZ())) {
				double d0 = Math.abs(p_196262_4_.getX() - p_196262_4_.xOld);
				double d1 = Math.abs(p_196262_4_.getZ() - p_196262_4_.zOld);
				if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
					p_196262_4_.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0F);
				}
			}

		}
	}
}