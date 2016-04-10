package com.github.maxopoly.Genesis.entities.hostile;

import java.util.List;
import java.util.Map;

import org.bukkit.entity.EntityType;

import com.github.maxopoly.Genesis.combatEffects.CombatEffect;
import com.github.maxopoly.Genesis.entities.GenesisLivingEntity;

public class GenesisCaveSpider extends GenesisLivingEntity {

	public GenesisCaveSpider(String customName, List<CombatEffect> onHitEffects,
			List<CombatEffect> onDeathEffects,
			List<CombatEffect> onSpawnEffects,
			List<CombatEffect> onGetHitEffects,
			Map<CombatEffect, Long> randomEffects) {
		super(EntityType.CAVE_SPIDER, customName, onHitEffects, onDeathEffects,
				onSpawnEffects, onGetHitEffects, randomEffects);
	}
}