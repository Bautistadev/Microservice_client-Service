package com.Microservice.clientService.Configuration;

import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;

public class EurekaInstanceBean extends EurekaInstanceConfigBean {

    public EurekaInstanceBean(InetUtils inetUtils) {
        super(inetUtils);
    }

    /**
     * INSTANCE ID
     * */
    @Override
    public void setInstanceId(String instanceId) {
        super.setInstanceId(instanceId);
    }

    @Override
    public String getInstanceId() {
        return super.getInstanceId();
    }

    /**
     * TIEMPO DE ACTUALIZACION ENTRE EL SERVIDOR DE EUREKA
     * */
    @Override
    public int getLeaseRenewalIntervalInSeconds() {
        return super.getLeaseRenewalIntervalInSeconds();
    }

    @Override
    public void setLeaseRenewalIntervalInSeconds(int leaseRenewalIntervalInSeconds) {
        super.setLeaseRenewalIntervalInSeconds(leaseRenewalIntervalInSeconds);
    }
    /**
     *  VIDA DEL MICROSERVICIO
     * */
    @Override
    public String getHealthCheckUrlPath() {
        return super.getHealthCheckUrlPath();
    }

    @Override
    public void setHealthCheckUrlPath(String healthCheckUrlPath) {
        super.setHealthCheckUrlPath(healthCheckUrlPath);
    }
    /**
     * ESTADOS DEL MICROSERVICIO
     * */
    @Override
    public String getStatusPageUrlPath() {
        return super.getStatusPageUrlPath();
    }

    @Override
    public void setStatusPageUrlPath(String statusPageUrlPath) {
        super.setStatusPageUrlPath(statusPageUrlPath);
    }
     /**
      * PAGINA PRINCIPAL DEL MICROSERVICO
      * */
    @Override
    public String getHomePageUrlPath() {
        return super.getHomePageUrlPath();
    }

    @Override
    public void setHomePageUrlPath(String homePageUrlPath) {
        super.setHomePageUrlPath(homePageUrlPath);
    }


}
