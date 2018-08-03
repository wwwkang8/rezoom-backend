package com.nexters.rezoom.controller;

import com.nexters.rezoom.domain.HashTag;
import com.nexters.rezoom.dto.QuestionDTO;
import com.nexters.rezoom.dto.QuestionListRequestDTO;
import com.nexters.rezoom.dto.QuestionListResponseDTO;
import com.nexters.rezoom.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // 이력서에 여러 개 문항 삽입
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void createQuestions(@RequestBody QuestionListRequestDTO questionListRequestDTO, Principal principal) {
        questionService.createQuestions(questionListRequestDTO, principal.getName());
    }

    // 이력서 내 모든 문항 조회
    @GetMapping(value="")
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionListResponseDTO> getAllQuestion(@RequestParam int resumeId, Principal principal) {
        return questionService.getAllQuestion(resumeId, principal.getName());
    }

    // 단일 문항 상세 조회
    @GetMapping("/{questionId}")
    @ResponseStatus(HttpStatus.OK)
    public QuestionDTO getQuestion(@RequestParam int resumeId, @PathVariable int questionId, Principal principal){
        QuestionDTO question = questionService.getQuestion(principal.getName(), resumeId, questionId);
        return question;
    }

    // TODO : 이력서 내 모든 문항 수정 API 필요
    /**
     * 이력서의 문항이 1,2,3,4 있었는데 사용자가 수정해서 1,2만 남김
     * 그럼 1,2에 대한 문항은 수정하고 3,4에 대한 문항은 삭제해야함
     * 또한, 각 문항에 해쉬태그를 업데이트해야하는데 이건  insert into on duplicate key update를 해야함..
     */
}
