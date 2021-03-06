package com.nyhammer.p96.structure.patterns;

import java.util.List;

import com.nyhammer.p96.Game;
import com.nyhammer.p96.entities.Bullet;
import com.nyhammer.p96.structure.BulletPattern;
import com.nyhammer.p96.structure.ResourceStorage;
import com.nyhammer.p96.util.math.vector.Vector2f;
import com.nyhammer.p96.util.timing.TargetTimer;
import com.nyhammer.p96.util.timing.Timer;

public class RandomPattern extends BulletPattern {
	private TargetTimer intervalTimer;
	private boolean normalized;
	public RandomPattern(List<Bullet> levelBullets, float speed, float size, Timer baseTimer, float interval, boolean normalized) {
		super(levelBullets, speed, size);
		intervalTimer = new TargetTimer(baseTimer, interval);
		this.normalized = normalized;
	}
	@Override
	protected void startSpecifics() {
		intervalTimer.start();
	}
	@Override
	protected void updateSpecifics(float deltaTime, Vector2f sourcePosition, Vector2f targetPosition, float speed) {
		if(intervalTimer.targetReached()) {
			Vector2f direction = new Vector2f(Game.getRandom().nextFloat() * 2f - 1f, -Game.getRandom().nextFloat());
			if(normalized) {
				direction.normalize();
			}
			addBullet(sourcePosition, direction.getMul(speed), ResourceStorage.getTexture("bulletRedTex"));
		}
	}
}
