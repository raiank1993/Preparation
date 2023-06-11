package com.example.preparation.phonepenew.service.main;

import in.gameskraft.communicationservice.controllers.facebook.phonepenew.enums.Platform;
import in.gameskraft.communicationservice.controllers.facebook.phonepenew.exceptions.DeviceUnSupportedException;
import in.gameskraft.communicationservice.controllers.facebook.phonepenew.model.App;
import in.gameskraft.communicationservice.controllers.facebook.phonepenew.model.Device;
import in.gameskraft.communicationservice.controllers.facebook.phonepenew.service.UpdateApp;
import in.gameskraft.communicationservice.controllers.facebook.phonepenew.service.strategy.BetaRollOutStrategy;
import in.gameskraft.communicationservice.controllers.facebook.phonepenew.service.strategy.DefaultStrategy;

import java.util.ArrayList;
import java.util.List;

public class MainMethod {

    public static void main(String args[]){
        App a = App.builder().appName("PhonePe").platform(Platform.BOTH).build();
        List<App> list = new ArrayList<>();
        list.add(a);
        Device d1 = Device.builder().deviceName("OPPO").id(1).appList(new ArrayList<>()).platform(Platform.ANDROID).build();
        Device d2 = Device.builder().deviceName("IPHONE").id(2).appList(new ArrayList<>()).platform(Platform.IOS).build();
        checkForInstall(a, d1);
    }

    private static void checkForInstall(App app, Device d) {
        if(app.getPlatform() == d.getPlatform()){
            //check device has app
            List<App> appListInDevice = d.getAppList();
            if(!appListInDevice.isEmpty() && deviceContainApp(appListInDevice, app)){
                //update the app
                UpdateApp updateApp = new UpdateApp(new BetaRollOutStrategy());
                updateApp.executeApp();
                appListInDevice.add(app);
                d.setAppList(appListInDevice);
            }
            else{
                //install new app
                UpdateApp updateApp = new UpdateApp(new DefaultStrategy());
                updateApp.executeApp();
                appListInDevice.add(app);
                d.setAppList(appListInDevice);
            }
        }else{
            throw new DeviceUnSupportedException();
        }
    }

    private static boolean deviceContainApp(List<App> appListInDevice, App app) {
        for(App a : appListInDevice){
            if(a.getAppName().equals(app.getAppName())){
                return true;
            }
        }
        return false;
    }


}
