package com.github.hps.util;

public class SnowFlakeIdGenerator implements IdGenerator {
    private static final long workerIdBits = 4L;
    public static final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private static final long sequenceBits = 10L;
    private static final long workerIdShift = sequenceBits;
    private static final long timestampLeftShift = sequenceBits + workerIdBits;
    public static final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long twepoch = 1530700315824L;
    private final long workerId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowFlakeIdGenerator(final long workerId) {
        super();

        if ((workerId > this.maxWorkerId) || (workerId < 0)) {
            throw new IllegalArgumentException(String.format(
                    "worker Id can't be greater than %d or less than 0",
                    this.maxWorkerId));
        }

        this.workerId = workerId;
    }

    public Long generateId() {
        return this.nextId();
    }

    public Long generateId(String name) {
        return this.generateId();
    }

    public Long generateId(Class<?> clz) {
        return this.generateId();
    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();

        if (this.lastTimestamp == timestamp) {
            this.sequence = (this.sequence + 1) & this.sequenceMask;

            if (this.sequence == 0) {
                System.out.println("###########" + sequenceMask);

                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }

        if (timestamp < this.lastTimestamp) {
            try {
                throw new Exception(
                        String.format(
                                "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                                this.lastTimestamp - timestamp));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.lastTimestamp = timestamp;

        long nextId = ((timestamp - twepoch) << timestampLeftShift)
                | (this.workerId << this.workerIdShift) | (this.sequence);
        return nextId;
    }

    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();

        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }

        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    public void setTwepoch(long twepoch) {
        this.twepoch = twepoch;
    }

    public static void main(String[] args) {
        SnowFlakeIdGenerator worker2 = new SnowFlakeIdGenerator(2);

        System.out.println(worker2.nextId());
    }
}
