package com.example.shop.member;

import com.example.shop.common.exception.BadRequestException;
import com.example.shop.common.exception.NotFoundException;
import com.example.shop.common.message.ErrorMessage;
import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    @Transactional
    public Long createMember(MemberCreateRequest request){
        Member existingMember = memberRepository.findByLoginId(request.getLoginId());
        if(existingMember != null) {
            throw new BadRequestException(ErrorMessage.MEMBER_ALREADY_EXISTS + request.getLoginId());
        }

        Member member = new Member(
                request.getLoginId(),
                request.getPassword(),
                request.getAddress(),
                request.getPhoneNumber()
        );

        memberRepository.save(member);
        return member.getId();
    }
    @Transactional(readOnly = true)
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member getMemberById(Long id) {

        Member member = memberRepository.findById(id);
        if (member ==null){
            throw new NotFoundException( ErrorMessage.MEMBER_NOT_FOUND);
        }

        return member;

    }



    @Transactional
    public void updateMember(Long id, MemberUpdateRequest request){
        Member member = memberRepository.findById(id);
        if (member ==null){
            throw new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND);
        }


        String password = request.getPassword() != null
                ? request.getPassword()
                : member.getPassword();
        String phoneNumber= request.getPhoneNumber() != null
                ? request.getPhoneNumber()
                : member.getPhoneNumber();
        String address= request.getAddress() != null
                ? request.getAddress()
                : member.getAddress();


        member.updateInfo(password,phoneNumber,address);

    }




    @Transactional
    public void deleteMember(Long id){
        Member member = memberRepository.findById(id);
        if (member ==null){
            throw new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND);
        }

        memberRepository.deleteById(id);
    }

}
