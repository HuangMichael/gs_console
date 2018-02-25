package com.huangbin.gsarts.util.ftp;

import com.huangbin.gsarts.model.sysInfo.SysParams;
import com.huangbin.gsarts.service.systemInfo.SysParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by huangbin on 2017/10/31.
 */
@Component
public class FTPconfig {
    @Autowired
    SysParamsService sysParamsService;

    public static final String IP = "58.213.65.98";
    public static final int PORT = 21;
    public static final int NGINX_PORT = 9090;
    public static final String USERNAME = "bmis";
    public static final String PASSWORD = "bmislinkbit";
    public static final String ROOT = "f:/ftp/mediaDocs";


    /**
     * @return 获取FTP URL地址
     */
    public String getFTPUrl() {
        SysParams sysParams = sysParamsService.findByParamName("FTP_URL");
        return sysParams.getParamValue();
    }
}
