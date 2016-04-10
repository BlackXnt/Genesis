package com.github.maxopoly.Genesis.entities.animals;

import java.util.List;
import java.util.Map;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wolf;

import com.github.maxopoly.Genesis.combatEffects.CombatEffect;
import com.github.maxopoly.Genesis.misc.RandomSelector;

public class GenesisWolf extends GenesisAnimal {
	
	private RandomSelector<DyeColor> colorSelector;
	
	private Map <DyeColor, Double> collarColors;

	public GenesisWolf(String customName, List<CombatEffect> onHitEffects,
			List<CombatEffect> onDeathEffects,
			List<CombatEffect> onSpawnEffects,
			List<CombatEffect> onGetHitEffects,
			Map<CombatEffect, Long> randomEffects, boolean ageLocked,
			boolean isBaby, Map <DyeColor, Double> collarColors) {
		super(EntityType.WOLF, customName, onHitEffects, onDeathEffects,
				onSpawnEffects, onGetHitEffects, randomEffects, ageLocked,
				isBaby);
		this.collarColors = collarColors;
		colorSelector = new RandomSelector<DyeColor>();
	}
	
	public LivingEntity spawnAt(Location loc) {
		Wolf wolf = (Wolf) super.spawnAt(loc);
		if (collarColors != null) {
			DyeColor color = colorSelector.pickRandomly(collarColors);
			if (color != null) {
				wolf.setCollarColor(color);
			}
		}
		return wolf;
	}
}