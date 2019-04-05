package com.task.urlMinimizator.utils;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ClientInfoUtil {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ClientInfoUtil.class);

    public String getIpAddress() throws UnknownHostException {
        InetAddress iAddress = InetAddress.getLocalHost();
        String currentIp = iAddress.getHostAddress();
        LOGGER.info("Ip address successfully loaded.");
        return currentIp;
    }
}
