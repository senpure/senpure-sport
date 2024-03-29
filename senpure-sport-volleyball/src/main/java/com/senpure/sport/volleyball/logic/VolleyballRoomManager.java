package com.senpure.sport.volleyball.logic;

import com.senpure.base.util.RandomUtil;
import com.senpure.io.server.provider.MessageSender;


import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * VolleyballRoomManager
 *
 * @author senpure
 * @time 2019-07-26 18:00:35
 */
public class VolleyballRoomManager {


    private ConcurrentHashMap<Integer, VolleyballRoom> roomMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, VolleyballRoom> playerRoomMap = new ConcurrentHashMap<>();

    private int startValue;
    private int endValue;
    public Set<Integer> roomIds = new LinkedHashSet<>();

    public BlockingDeque<Integer> using;


    public VolleyballRoomManager(int startValue, int endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
        easyRoom();
    }

    public VolleyballRoom createRoom(MessageSender messageSender, VolleyballRoomManager roomManager) {
        int roomId = nextRoomId();
        VolleyballRoom room = new VolleyballRoom(roomId, messageSender, roomManager);
        roomMap.put(roomId, room);
        return room;
    }


    public VolleyballRoom getRoom(int roomId) {
        return roomMap.get(roomId);
    }


    public VolleyballRoom markPlayerRoom(Long playerId, VolleyballRoom room) {
        return playerRoomMap.put(playerId, room);
    }

    public void playerExitRoom(Long playerId) {

        playerRoomMap.remove(playerId);
    }

    public VolleyballRoom getPlayerRoom(Long playerId) {
        return playerRoomMap.get(playerId);
    }

    public void closeRoom(VolleyballRoom room) {
        roomMap.remove(room.getRoomId());
        back(room.getRoomId());
    }


    private int nextRoomId() {
        int roomId = getEasyRoomId();
        if (roomId == 0) {
            do {
                roomId = RandomUtil.random(100000, 999999);
            }
            while (!canUse(roomId) && roomMap.get(roomId) != null);
        }
        return roomId;
    }

    private boolean canUse(Integer value) {

        return value >= startValue && value < endValue;
    }

    private Integer getEasyRoomId() {
        Integer roomId = using.poll();
        return roomId == null ? 0 : roomId;
    }

    private void back(Integer roomId) {
        if (roomIds.contains(roomId)) {
            // using.offerFirst(roomId);
            using.offerLast(roomId);
            //using.offer(roomId);
        }
    }

    private String leftIds() {
        return using.toString();
    }


    private void easyRoom() {
        //22222
        for (int i = 1; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                sb.append(i);
            }
            Integer id = Integer.valueOf(sb.toString());
            if (canUse(id)) {
                roomIds.add(id);
            }
        }
        List<Integer> temps = new ArrayList<>();
        temps.add(123456);
        temps.add(654321);
        for (Integer id : temps) {
            if (canUse(id)) {
                roomIds.add(id);
            }
        }

        //111222
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j || i == j) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(i).append(i).append(j).append(j).append(j);
                Integer id = Integer.valueOf(sb.toString());
                if (canUse(id)) {
                    roomIds.add(id);
                }
            }

        }
        //112233
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || j == k || i == j) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(i).append(j).append(j);
                    sb.append(k).append(k);
                    Integer id = Integer.valueOf(sb.toString());
                    if (canUse(id)) {
                        roomIds.add(id);
                    }
                }
            }

        }
        //122222

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {

                if (i == j || i == j) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(j).append(j).append(j);
                sb.append(j).append(j);
                Integer id = Integer.valueOf(sb.toString());
                if (canUse(id)) {
                    roomIds.add(id);
                }

            }

        }
        using = new LinkedBlockingDeque<>(roomIds.size());
        List<Integer> ids = new ArrayList<>(roomIds);
        Collections.shuffle(ids);
        ids.forEach(id ->
                using.offer(id)
        );

    }
}
