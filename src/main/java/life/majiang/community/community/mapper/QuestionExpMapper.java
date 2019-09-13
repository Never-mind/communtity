package life.majiang.community.community.mapper;

import life.majiang.community.community.model.Question;

import java.util.List;

public interface QuestionExpMapper {

    int inCView(Question record);
    int inCComment(Question record);
    List<Question> selectRelated(Question question);
}