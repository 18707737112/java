package com.iotek.entity;

import java.io.Serializable;

public class Encrypted implements Serializable {
    private int id;//学号
    private String problem;
    private String answer;

    public Encrypted() {
    }

    public Encrypted(String problem, String answer) {
        this.problem = problem;
        this.answer = answer;
    }

    public Encrypted(int id, String problem, String answer) {
        this.id = id;
        this.problem = problem;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "密保id：" + id +" "+
                "问题：" + problem +" "+
                "答案：" + answer;
    }
}
