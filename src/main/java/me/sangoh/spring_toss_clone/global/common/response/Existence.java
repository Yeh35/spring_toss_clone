package me.sangoh.spring_toss_clone.global.common.response;


import lombok.Getter;

@Getter
public class Existence {

    private boolean existence;

    public Existence(boolean existence) {
        this.existence = existence;
    }
}
