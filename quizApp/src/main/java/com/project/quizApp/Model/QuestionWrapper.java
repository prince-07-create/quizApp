package com.project.quizApp.Model;

import lombok.Data;

@Data
public class QuestionWrapper {
    
    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the questionTitle
     */
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * @param questionTitle the questionTitle to set
     */
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    /**
     * @return String return the option1
     */
    public String getOption1() {
        return option1;
    }

    /**
     * @param option1 the option1 to set
     */
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    /**
     * @return String return the option2
     */
    public String getOption2() {
        return option2;
    }

    /**
     * @param option2 the option2 to set
     */
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    /**
     * @return String return the option3
     */
    public String getOption3() {
        return option3;
    }

    /**
     * @param option3 the option3 to set
     */
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    /**
     * @return String return the option4
     */
    public String getOption4() {
        return option4;
    }

    /**
     * @param option4 the option4 to set
     */
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public QuestionWrapper(Integer id, String questionTitle, String option1, String option2, String option3, String option4){
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

}