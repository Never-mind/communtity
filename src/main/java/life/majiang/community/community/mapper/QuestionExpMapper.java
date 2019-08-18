package life.majiang.community.community.mapper;

import life.majiang.community.community.model.Question;

public interface QuestionExpMapper {

    int inCView(Question record);
    int inCComment(Question record);
}