package com.bestiario.entity;

import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

/**
 * Viuda de las Cuevas: arana oscura que vive bajo tierra (Y &lt; 50).
 * Hereda de Spider, asi que trepa paredes. Su picadura envenena y debilita.
 */
public class ViudaDeLasCuevas extends Spider {

    public ViudaDeLasCuevas(EntityType<? extends ViudaDeLasCuevas> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Spider.createAttributes()
                .add(Attributes.MAX_HEALTH, 22.0)
                .add(Attributes.MOVEMENT_SPEED, 0.33)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.FOLLOW_RANGE, 24.0);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        if (super.doHurtTarget(target)) {
            if (target instanceof LivingEntity living) {
                int poisonSeconds = 0;
                Difficulty difficulty = this.level().getDifficulty();
                if (difficulty == Difficulty.NORMAL) {
                    poisonSeconds = 7;
                } else if (difficulty == Difficulty.HARD) {
                    poisonSeconds = 15;
                }
                if (poisonSeconds > 0) {
                    living.addEffect(new MobEffectInstance(MobEffects.POISON, poisonSeconds * 20, 0), this);
                }
                // Veneno que debilita (siempre, salvo en Pacifico)
                if (difficulty != Difficulty.PEACEFUL) {
                    living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 8 * 20, 0), this);
                }
            }
            return true;
        }
        return false;
    }
}
