package com.example.preparation.phonepenew.model;


import in.gameskraft.communicationservice.controllers.facebook.phonepenew.enums.Platform;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class App {

    private List<Version> versionList;
    private String appName;
    private Platform platform;

}
