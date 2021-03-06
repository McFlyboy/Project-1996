package com.nyhammer.p96.util.timing;

public class TargetTimer {
	private Timer timer;
	private double targetTime;
	public TargetTimer(double targetTime) {
		this(null, targetTime);
	}
	public TargetTimer(Timer baseTimer, double targetTime) {
		timer = new Timer(baseTimer, false);
		this.targetTime = targetTime;
	}
	public double getTime() {
		return timer.getTime();
	}
	public double getTargetTime() {
		return targetTime;
	}
	public void setTargetTime(double targetTime) {
		this.targetTime = targetTime;
	}
	public double getProgress() {
		return timer.getTime() / targetTime;
	}
	public void start() {
		timer.start();
	}
	public void pause() {
		timer.pause();
	}
	public void reset() {
		timer.reset(false);
	}
	public boolean targetReached() {
		double time = timer.getTime();
		if(time >= targetTime) {
			timer.setTime(time - targetTime);
			return true;
		}
		return false;
	}
}
