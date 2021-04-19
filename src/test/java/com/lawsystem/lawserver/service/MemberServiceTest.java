package com.lawsystem.lawserver.service;

import com.lawsystem.lawserver.model.LawVote;
import com.lawsystem.lawserver.model.Member;
import com.lawsystem.lawserver.repo.LawContentRepository;
import com.lawsystem.lawserver.repo.LawRepository;
import com.lawsystem.lawserver.repo.LawVoteRepository;
import com.lawsystem.lawserver.repo.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private LawRepository lawRepository;

    @Mock
    private LawVoteRepository lawVoteRepository;

    @Mock
    private LawContentRepository lawContentRepository;

    @Mock
    private Member member;

    private MemberService memberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        memberService = new MemberService(memberRepository,lawContentRepository,lawRepository);


    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void requestRegister() {
        String name = "name" ;
        String phone = "phone";

        when(memberRepository.save(any())).thenReturn(member);




        verify(memberRepository).save(any());
    }

    @Test
    void allUsers() {

        List<Member> list = List.of(new Member("a","0").setRegistered(true), new Member("b","1"));

        when(memberRepository.findAll())
            .thenReturn(list);

        assertSame(memberService.allUsers(), list);

        verify(memberRepository).findAll();
    }

    @Test
    void testAllUsers() {

    }
}