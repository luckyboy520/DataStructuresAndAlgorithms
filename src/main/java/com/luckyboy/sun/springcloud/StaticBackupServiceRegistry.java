package com.luckyboy.sun.springcloud;

import com.netflix.appinfo.DataCenterInfo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.MyDataCenterInfo;
import com.netflix.discovery.BackupRegistry;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-10-20 11:39
 **/
public class StaticBackupServiceRegistry implements BackupRegistry {

    private Applications localRegionApps = new Applications();
    public StaticBackupServiceRegistry() {
        Application orgApplication = new Application("org");
        InstanceInfo orginstancel = InstanceInfo.Builder.newBuilder()
                .setAppName("org-service")
                .setVIPAddress("org-service")
                .setSecureVIPAddress("org-service")
                .setInstanceId("org-instance-1")
                .setHostName("192.168.99.100")
                .setIPAddr("192.168.99.100")
                .setPort(9090)
                .setDataCenterInfo(new MyDataCenterInfo(DataCenterInfo.Name.MyOwn)) .setStatus(InstanceInfo.InstanceStatus.UP)
                .build();

        InstanceInfo orginstancel2 = InstanceInfo.Builder.newBuilder()
                .setAppName("org-service")
                .setVIPAddress("org-service")
                .setSecureVIPAddress("org-service")
                .setInstanceId("org-instance-1")
                .setHostName("192.168.99.100")
                .setIPAddr("192.168.99.100")
                .setPort(9090)
                .setDataCenterInfo(new MyDataCenterInfo(DataCenterInfo.Name.MyOwn)) .setStatus(InstanceInfo.InstanceStatus.UP)
                .build();
        orgApplication.addInstance(orginstancel);
        orgApplication.addInstance(orginstancel2);
        localRegionApps.addApplication(orgApplication);
    }
        @Override
    public Applications fetchRegistry() {
        return null;
    }

    @Override
    public Applications fetchRegistry(String[] includeRemoteRegions) {
        return null;
    }
}
