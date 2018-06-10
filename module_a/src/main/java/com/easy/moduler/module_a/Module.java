package com.easy.moduler.module_a;

import android.os.Message;

import com.easy.moduler.lib.Constants;
import com.easy.moduler.lib.okbus.BaseModule;
import com.easy.moduler.lib.okbus.CallBack;
import com.easy.moduler.lib.okbus.IModule;
import com.easy.moduler.lib.okbus.ServiceBus;
import com.easy.moduler.lib.utils.LogUtils;
import com.google.auto.service.AutoService;

/**
 * Created by baixiaokang on 18/3/6.
 */

@AutoService(IModule.class)
public class Module extends BaseModule {

    @Override
    public void afterConnected() {

        ServiceBus.getInstance().registerService(Constants.SERVICE_A_UID, new CallBack<String>() {
            @Override
            public String onCall(Message msg) {
                LogUtils.logOnUI(Constants.TAG, "afterConnected  a 进程收到[服务请求]消息:ServiceMessage-->hello:  " + Integer.toHexString(Math.abs(msg.what)));
                return "10086";
            }
        });
    }

    @Override
    public int getModuleId() {
        return Constants.MODULE_A;
    }

}
