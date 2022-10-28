package com.example.feed.infrastructure.fcm;

import com.example.feed.domain.board.domain.Board;
import com.example.feed.domain.member.domain.Member;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class FCMFacade {

    @Async
    public void sendJoinNotification(Member member, Board board) {

        Message message = Message.builder()
                .setToken(board.getAdmin().getDeviceToken())
                .setTopic(board.getId().toString())
                .setNotification(Notification.builder()
                        .setTitle(member.getName() + "님이 " + board.getTitle() + "에 참여 요청을 보냈습니다.")
                        .setBody("참여를 수락하거나 거절하세요.")
                        .build())
                .build();

        FirebaseMessaging.getInstance().sendAsync(message);
    }

    @Async
    public void sendPermitNotification(Member member, Board board) {

        Message message = Message.builder()
                .setToken(member.getUser().getDeviceToken())
                .setTopic(board.getId().toString())
                .setNotification(Notification.builder()
                        .setTitle(board.getAdmin().getName() + "님이 " + board.getTitle() + "에 참여 요청을 허가했습니다.")
                        .setBody("게시글을 마음껏 작성하세요!")
                        .build())
                .build();

        FirebaseMessaging.getInstance().sendAsync(message);
    }

    @Async
    public void sendUnPermitNotification(Member member, Board board) {

        Message message = Message.builder()
                .setToken(member.getUser().getDeviceToken())
                .setTopic(board.getId().toString())
                .setNotification(Notification.builder()
                        .setTitle(board.getAdmin().getName() + "님이 " + board.getTitle() + "에 참여 요청을 불허했습니다.")
                        .setBody("아쉬워어라")
                        .build())
                .build();

        FirebaseMessaging.getInstance().sendAsync(message);
    }
}
