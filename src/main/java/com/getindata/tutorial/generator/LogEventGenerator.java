package com.getindata.tutorial.generator;

import com.getindata.tutorial.avro.LogEvent;

import java.util.Random;

final class LogEventGenerator {

  private final static String[] SERVERS = {
      "ny.stream.rock.net",
      "wa.stream.rock.net",
      "bos.stream.rock.net",
      "phi.stream.rock.net"};

  private final static String[] EVENTS = {"SongPlayed"};

  private final Random random = new Random();

  public LogEvent generate() {
    LogEvent.Builder logEventBuilder = LogEvent.newBuilder()
        .setDuration(getSongDuration()).setServer(pickServer())
        .setSongid(getRandomSongId()).setUserid(getRandomUserId())
        .setTimestamp(getCurrentTime())
        .setName(pickEvent());

    return logEventBuilder.build();
  }

  private long getCurrentTime() {
    return System.currentTimeMillis();
  }

  private String pickServer() {
    return SERVERS[random.nextInt(SERVERS.length)];
  }

  private String pickEvent() {
    return EVENTS[random.nextInt(EVENTS.length)];
  }

  private String getRandomUserId() {
    return String.valueOf(random.nextInt(10000));
  }

  private int getRandomSongId() {
    return random.nextInt(1000);
  }

  private int getSongDuration() {
    return random.nextInt(420)
        + (random.nextInt(20) == 0 ? 10000 : 0);
  }
}
