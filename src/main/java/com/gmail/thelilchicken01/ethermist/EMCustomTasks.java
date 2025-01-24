package com.gmail.thelilchicken01.ethermist;

import net.minecraft.world.ticks.ScheduledTick;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EMCustomTasks {

    private final PriorityQueue<ScheduledTask> queue = new PriorityQueue<>();

    public void schedule(int tick, Runnable task) {
        queue.add(new ScheduledTask(tick, task));
    }

    public void tick(int currentTick) {
        while (!queue.isEmpty() && queue.peek().tick <= currentTick) {
            ScheduledTask task = queue.poll();
            task.task.run();
        }
    }

    private static class ScheduledTask implements Comparable<ScheduledTask> {
        final int tick;
        final Runnable task;

        ScheduledTask(int tick, Runnable task) {
            this.tick = tick;
            this.task = task;
        }

        @Override
        public int compareTo(@NotNull EMCustomTasks.ScheduledTask o) {
            return Integer.compare(this.tick, o.tick);
        }
    }

}
