package com.Microservice.clientService.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
public class EurekaConfig {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${random.uuid}")
    private String randomValue;

    @Bean
    public InetUtils inetUtils(InetUtilsProperties inetUtilsProperties){
        return new InetUtils(inetUtilsProperties);
    }

    @Bean
    public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils){
        EurekaInstanceBean eurekaBean = new EurekaInstanceBean(inetUtils);
        eurekaBean.setInstanceId(applicationName+":"+randomValue);
        eurekaBean.setLeaseRenewalIntervalInSeconds(10);
        eurekaBean.setNonSecurePort(8813);
        eurekaBean.setNonSecurePortEnabled(true);
        eurekaBean.setHealthCheckUrlPath("/actuator/health");
        eurekaBean.setHomePageUrlPath("/swagger-ui/index.html");
        eurekaBean.setStatusPageUrlPath("/actuator/health");
        return eurekaBean;
    }


    @Bean
    public EurekaClientConfigBean eurekaClientConfigBean(){
        EurekaClientBean eurekaClientBean = new EurekaClientBean();
        eurekaClientBean.setEurekaServerPort("8761");
        return eurekaClientBean;
    }



}
