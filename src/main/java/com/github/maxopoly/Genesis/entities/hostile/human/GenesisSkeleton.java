package com.github.maxopoly.Genesis.entities.hostile.human;

import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.inventory.ItemStack;

import com.github.maxopoly.Genesis.combatEffects.CombatEffect;
import com.github.maxopoly.Genesis.combatEffects.EffectCause;

public class GenesisSkeleton extends GenesisHumanEntity {

	private boolean isWitherSkeleton;

	public GenesisSkeleton(String uniqueTag,
			String customName, Map<EffectCause, List<CombatEffect>> effects, ItemStack helmetSlot,
			ItemStack chestSlot, ItemStack pantSlot, ItemStack bootSlot,
			ItemStack handSlot, double helmetDropChance,
			double chestplateDropChance, double leggingsDropChance,
			double bootsDropChance, double handDropChance, boolean canPickupItems,
			boolean isWitherSkeleton) {
		super(EntityType.SKELETON, uniqueTag, customName, effects, helmetSlot,
				chestSlot, pantSlot, bootSlot, handSlot, helmetDropChance,
				chestplateDropChance, leggingsDropChance, bootsDropChance,
				handDropChance, canPickupItems);
		this.isWitherSkeleton = isWitherSkeleton;
	}

	public LivingEntity spawnAt(Location loc) {
		LivingEntity l = super.spawnAt(loc);
		Skeleton skele = ((Skeleton) l);
		if (isWitherSkeleton) {
			skele.setSkeletonType(SkeletonType.WITHER);
		} else {
			skele.setSkeletonType(SkeletonType.NORMAL);
		}
		return l;
	}

	/**
	 * @return Whether this skeleton is a wither skeleton or just a normal
	 *         skeleton
	 */
	public boolean isWitherSkeleton() {
		return isWitherSkeleton;
	}
}
